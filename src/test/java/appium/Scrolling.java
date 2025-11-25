package appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Scrolling extends BaseTest{
    @Test
    public void scrollActionIntoView() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        scrollIntoView("WebView");
        Thread.sleep(5000);
    }
}
