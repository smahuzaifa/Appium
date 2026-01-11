package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSPhotosApp extends IOSBaseTest {
    @Test
    public void photosApp() {
        //In iOS we use Bundle ID
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp", params);
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"PXGGridLayout-Info\"`]"));
        System.out.println(allPhotos.size());

    }
}
