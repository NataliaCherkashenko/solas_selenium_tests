package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utilities.Browser;

import java.io.File;
import java.io.IOException;

import static utilities.Browser.Driver;

public abstract class TestBase {

    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    HomePage homePage;

    @BeforeClass
    public void init() {
        Browser.Initialize();
        homePage = new HomePage(Driver());

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (Driver() != null) {
            Driver().quit();
        }
    }

    @AfterMethod
    public void setScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                WebDriver returned = new Augmenter().augment(Driver());
                if (returned != null) {
                    File f = ((TakesScreenshot) returned).getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(f,
                                new File(SCREENSHOT_FOLDER + result.getName() + SCREENSHOT_FORMAT));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (ScreenshotException se) {
                se.printStackTrace();
            }
        }
    }
}
