package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AppiumBasics2 extends BaseTest {
    // Locators for reuse
    public static final By preference = AppiumBy.androidUIAutomator("new UiSelector().text(\"Preference\")");
    public static final By preferenceDependencies = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]");
    public static final By checkbox = By.id("android:id/checkbox");
    public static final By wifiSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
    public static final By wifiEdit = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")");
    public static final By okButton = By.id("android:id/button1");
    /* What Each Keyword Means:
        public: The variable is accessible from any other class (if needed).

        static: The variable belongs to the class itself, not any instance.This means only one copy exists in
        memory for the entire class, saving space and preventing duplication.

        final: The variable cannot be changed after it's assigned—it's a constant.
     */

    @Test
    public void WifiSettingName() {
        driver.findElement(preference).click();
        driver.findElement(preferenceDependencies).click();
        driver.findElement(checkbox).click();
        driver.findElement(wifiSettings).click();
        driver.findElement(wifiEdit).sendKeys("Hello123");
        driver.findElement(okButton).click();

    }
}
