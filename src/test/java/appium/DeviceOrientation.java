package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeviceOrientation extends BaseTest{
    @Test
    public void deviceOrientation(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Preference\")")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        //Changing orientation
        DeviceRotation dr = new DeviceRotation(0,0,90);
        driver.rotate(dr);

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
        String wifiText = driver.findElement(By.id("android:id/alertTitle")).getText();
        //This returns a string which we can then store as a regular string variable
        System.out.println("The text displayed in the pop-up is "+ wifiText);
        Assert.assertEquals(wifiText, "WiFi settings");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")")).sendKeys("Hello123");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
