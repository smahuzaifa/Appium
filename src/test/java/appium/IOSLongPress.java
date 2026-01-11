package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSLongPress extends IOSBaseTest {
    @Test
    public void longPresstest() {
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Steppers\"]")).click();
        WebElement ele1 = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[3]"));
        WebElement ele2 = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[2]"));
        Map<String, Object> params = new HashMap<>(); //Seperate Injection
        params.put("element", ((RemoteWebElement) ele1).getId());
        params.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params); //different from android
        longPressActions(ele2, 5);

    }
}
