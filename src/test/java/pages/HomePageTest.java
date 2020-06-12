package pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Browser;

public class HomePageTest extends TestBase{

    @Test
    public void openMoreMenu() throws InterruptedException {

        homePage.moreMenu.click();

        String firstItemMoreMenu = homePage.moreMenuElements.get(0).getText();

        Assert.assertTrue(firstItemMoreMenu.equals("About Generation Apprenticeship"));

        for(int i = 0; i < homePage.moreMenuElements.size(); i++){
            int number = i+1;
            System.out.println("More menu item "+number+" is "+ homePage.moreMenuElements.get(i).getText());
        }
    }


}
