package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSScroll extends IOSBaseTest {
    @Test
    public void iOSScroll() {
        WebElement webviews = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Web View\"]"));
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) webviews).getId());
        params.put("direction", "down");
        driver.executeScript("mobile:scroll", params);
        webviews.click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"BackButton\"]")).click();
        scrollAction(webviews, "down");
        webviews.click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"BackButton\"]")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Picker View\"")).click();
        //Handling date picker type scroller on iOS
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Red color component value\"`]")).sendKeys("150");
        System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Red color component value\"`]")).getText());
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Green color component value\"`]")).sendKeys("200");
        System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Green color component value\"`]")).getText());
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("150");
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText());
    }
}
