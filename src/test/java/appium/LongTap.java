package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongTap extends BaseTest {
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
}
