package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EndToEndApplicationAndroid extends BaseTest2{
    @Test
    public void FirstPage(){
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView("Bermuda");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Bermuda\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/nameField\")")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
    @Test
    public void ToastMessage() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView("Bermuda");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Bermuda\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //Toast Message
        Thread.sleep(1500);
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //android.widget.Toast this is the class in which the toast messages are stored.
        //We are using this because we cannot inspect toast messages
        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
    @Test
    public void addToCart(){
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView("Bermuda");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Bermuda\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/nameField\")")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollIntoView("Air Jordan 9 Retro");
        //When there are multiple elemnts and no unique id can be found we use driver.findElements
        int productSize = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<productSize;i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase("Air Jordan 9 Retro")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        //Explicit wait
        waitForAttributeContains(By.id
                ("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart", 5);
        int cartSize = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<cartSize;i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase("Air Jordan 9 Retro")){
                System.out.println("The product has been added");
                break;
            }
        }
    }
}
