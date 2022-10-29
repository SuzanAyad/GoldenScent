package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
//import Pages.*;
import Pages.P01_HomePage;
import Pages.P02_CategoriesPage;
import Pages.P03_ProductsPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetupClass {
    public static AppiumDriver driver ;
    public static P01_HomePage homePage;
    public static P02_CategoriesPage categoriesPage;
    public static P03_ProductsPage productsPage;

    public static AndroidTouchAction action;


    @Before
    public static void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("noReset", "true");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "GoldenScent");
        caps.setCapability("udid", "emulator-5554");
        //caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");
        caps.setCapability("appPackage", "com.goldenscent.c3po.dev");
        caps.setCapability("appActivity", "com.goldenscent.c3po.ui.activity.SplashActivity");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        homePage = new P01_HomePage();
        categoriesPage = new P02_CategoriesPage();
        productsPage = new P03_ProductsPage();

        action = new AndroidTouchAction(driver);


    }

    @After
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}

