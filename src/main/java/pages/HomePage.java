package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends Pages {


    @FindBy(xpath = "//*[@class='submenu-item']")
    @CacheLookup
    public WebElement moreMenu;


    @FindBy(xpath = "//ul[@class='main-sub-menu submenu-open']/li/span")
    @CacheLookup
    public List<WebElement> moreMenuElements;


    @FindBy(xpath = "//*[@href='/']")
    @CacheLookup
    public WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
