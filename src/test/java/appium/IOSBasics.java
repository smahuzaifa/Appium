package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
    @Test
    public void iOSBasics(){
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeAlert[`name == \"A Short Title Is Best\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell"))
                .sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm / Cancel\"")).click();
        String message = driver.findElement(AppiumBy.iOSNsPredicateString("name == \"A message should be a short, complete sentence.\"")).getText();
        System.out.println(message);
        Assert.assertEquals(message,"A message should be a short, complete sentence.");
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
    }

}
