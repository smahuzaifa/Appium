package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class AppiumBasics extends BaseTest {
    @Test
    public void WifiSettingName() throws URISyntaxException, MalformedURLException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Preference\")")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
        String wifiText = driver.findElement(By.id("android:id/alertTitle")).getText();
        //This returns a string which we can then store as a regular string variable
        System.out.println("The text displayed in the pop-up is "+ wifiText);
        Assert.assertEquals(wifiText, "WiFi settings");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")")).sendKeys("Hello123");
        driver.findElement(By.id("android:id/button1")).click();
    }
    @Test
    public void longPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        longPressActions(element,2000);
        By menuText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")");
        String menuTextValue = driver.findElement(menuText).getText();
        System.out.println(menuTextValue);
        Assert.assertEquals(menuTextValue,"Sample menu");
        Assert.assertTrue(driver.findElement(menuText).isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void scrollActionIntoView() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        scrollIntoView("WebView");
        Thread.sleep(5000);

    }
}