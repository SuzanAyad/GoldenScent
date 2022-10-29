package Pages;


import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static Utils.SetupClass.driver;
import static Utils.SetupClass.action;

public class P03_ProductsPage {




    public AndroidElement productItem() {
         return (AndroidElement) driver.findElement(By.id("com.goldenscent.c3po.dev:id/img"));
    }

    public void selectProduct(){
        productItem().click();
    }


    public AndroidElement color() {
        return (AndroidElement) driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']"));
    }

    public void selectColor(){
        color().click();
    }

    public AndroidElement addToCartBtn() {
        return (AndroidElement) driver.findElement(By.id("com.goldenscent.c3po.dev:id/addToCart"));
    }

    public void clickAddToCartBtn(){
       addToCartBtn().click();
    }

    public AndroidElement alertTitle() {
        return (AndroidElement) driver.findElement(By.id("com.goldenscent.c3po.dev:id/alertTitle"));
    }


    public void assertSuccessfullyAddingToTheCart(){
        SoftAssert softAssert=new SoftAssert();
        String expectedAlertTxt ="Awesome Choice!";
        softAssert.assertTrue(alertTitle().getText().contains(expectedAlertTxt));
        softAssert.assertAll();
    }

}
