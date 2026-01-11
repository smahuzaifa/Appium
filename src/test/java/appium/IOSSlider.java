package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSlider extends IOSBaseTest {
    @Test
    public void slidingAction() throws InterruptedException {
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Sliders\"`]")).click();
        WebElement slider = driver.findElement(By.xpath("//XCUIElementTypeSlider[@value=\"42%\"]"));
        driver.findElement(By.xpath("//XCUIElementTypeSlider[@value=\"42%\"]")).sendKeys("1&");
        driver.findElement(By.xpath("//XCUIElementTypeSlider[@value=\"84%\"]")).sendKeys("0%");
        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals("100%",slider.getAttribute("value"));
    }
}
