package testcases;

import pages.HomePage;
import utilities.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @Test
    public void testHomePageTitle(){
        homePage.loadawebpage(homePage.homepageurl);
        Assert.assertEquals(getDriver().getTitle(), "IELTS Package");

    }
}
