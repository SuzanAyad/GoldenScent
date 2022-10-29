package Pages;

import Utils.SetupClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import static Utils.SetupClass.driver;
import static Utils.SetupClass.action;



public class P02_CategoriesPage {
    public AndroidElement categoryItem() {

        return (AndroidElement) driver.findElementByAccessibilityId("Shop By Brand");
    }

    public void clickCategoryItem() {

        categoryItem().click();
    }

    public void scrollToCategoryItem(String categoryName) {

        AndroidElement element = (AndroidElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + categoryName + "\").instance(0))"));
        element.click();
        //AndroidTouchAction action = new AndroidTouchAction(driver);
        action.tap(ElementOption.element(element)).perform();

    }

    }



