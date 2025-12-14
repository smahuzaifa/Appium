package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void configuringAppium() throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        String appiumJSPath;

        if (os.contains("win")) {
            appiumJSPath = "C:\\Users\\huzai\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        } else if (os.contains("mac")) {
            appiumJSPath = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";
        } else {
            throw new RuntimeException("Unsupported OS: " + os);
        }

        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withAppiumJS(new File(appiumJSPath))
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723)
                        .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub") // <-- important
        );
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9 Pro");
        String apkPath;
        if (os.contains("win")) {
            apkPath = "C:\\Users\\huzai\\IdeaProjects\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk";
        } else if (os.contains("mac")) {
            apkPath = "/Users/huzaifa/IdeaProjects/Appium/src/test/java/resources/ApiDemos-debug.apk";
        } else {
            throw new RuntimeException("Unsupported OS: " + os);
        }
        options.setApp(apkPath);


        //Creating androidDriver object
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        // Uniform Resource Identifier (URI) is a string that identifies a resource, while a
        // Uniform Resource Locator (URL) is a type of URI that specifies both the identity and the
        // location of a resource, typically on the web

        //Adding timeouts or waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //this will wait a maximum of 10 seconds for each execution or line of code
    }
    public void longPressActions(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId()));
        //This does a long tap for 500ms
    }
    public void longPressActions(WebElement element, int time){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),"duration",time));
        //This does long click on the element. The long tap lasts for 2 sec as we have mentioned the duration
    }
    public void scrollIntoView(String element){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"));"));
        //Use this when you know where to scroll
    }
    public void scrollToEndAction(int a,int b,int c,int d, String x){ //Use this when the target of scroll is
        //not known
        boolean canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture"
        ,ImmutableMap.of("left",a,"top",b,"width",c,"height",d, "direction",x,
                        //x can be down or up or left or right
         "percent",3.0));
    }

    public void swipeAction(WebElement element, String x,double y){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture"
                ,ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "direction",x,
                        "percent",y)); //The value of y should be between 0 and 1
    }
    public void dragAndDropGesture(WebElement element,int x,int y){
        ((JavascriptExecutor)driver).executeScript("mobile: dragGesture"
                ,ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                "endX",x, "endY",y)); //Mention the coordinates by switching from select element modes
    }
    //This is called explicit wait
    public void waitForAttributeContains(By locator, String attribute, String value, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(locator), attribute, value));
    }
    @AfterClass
    public void tearDown(){
        driver.quit(); //Closes the app once automation is done
        service.stop();
    }
}

