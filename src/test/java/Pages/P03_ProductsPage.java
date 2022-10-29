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

    public void swipe(){

        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;
        Rectangle rect = driver.findElement(By.id("iv_view")).getRect();
        edgeBorder = 0;
        pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                rect.y + rect.height / 2);
        pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                rect.y + rect.height / 2);

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }


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
