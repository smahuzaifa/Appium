package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Miscellaneous extends BaseTest {
    @Test
    public void miscellaneous(){
        //Windows: Command to know app package and activity: adb shell dumpsys window | find "mCurrentFocus"
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
        String wifiText = driver.findElement(By.id("android:id/alertTitle")).getText();
        //This returns a string which we can then store as a regular string variable
        System.out.println("The text displayed in the pop-up is "+ wifiText);
        Assert.assertEquals(wifiText, "WiFi settings");
    }

}
