package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class KeyEvents extends BaseTest{
    @Test
    public void keyEvents(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Preference\")")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
        String wifiText = driver.findElement(By.id("android:id/alertTitle")).getText();
        //This returns a string which we can then store as a regular string variable
        System.out.println("The text displayed in the pop-up is "+ wifiText);
        Assert.assertEquals(wifiText, "WiFi settings");

        //Working with Clipboard
        driver.setClipboardText("MyWifi");
        driver.findElement(AppiumBy.
                androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")"))
                .sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();

        //Keyboard events
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        //Create an object for the KeyEvent class, then pass the android key action that needs to be performed
    }
}
