package Pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import static Utils.SetupClass.driver;



public class P01_HomePage {

    public AndroidElement categoriesBtn() {

        return (AndroidElement) driver.findElementByAccessibilityId("Categories");
    }
    public void clickCategories() {
        categoriesBtn().click();
    }





}
