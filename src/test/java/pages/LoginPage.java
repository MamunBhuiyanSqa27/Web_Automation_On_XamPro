package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{


    public By login_email = By.xpath("//input[@id='email']");
    public By login_password = By.xpath("//input[@id='password']");
    public By login_button = By.xpath("//button[@type='submit']");

    HomePage homePage = new HomePage();


    public void navigatetologinpage(){
       homePage.loadhomepage();
       homePage.clickonelement(homePage.pop_up_message);
       homePage.clickonelement(homePage.signIn_button);
    }

}
