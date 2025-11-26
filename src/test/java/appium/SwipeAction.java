package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SwipeAction extends BaseTest{
    @Test
    public void swipeAction(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        Assert.assertEquals(firstImage.getAttribute("selected"),"true");
        //Swipe
        swipeAction(firstImage,"left",0.1);
        Assert.assertEquals(firstImage.getAttribute("selected"),"false");


    }

}
