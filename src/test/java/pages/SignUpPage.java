package pages;

import org.openqa.selenium.By;

public class SignUpPage extends BasePage{

    public By full_name = By.xpath("//input[@id='name']");
    public By email = By.xpath("//input[@id='email']");
    public By phone = By.xpath("//input[@id='phoneNumber']");
    public By password = By.xpath("//input[@id='password']");
    public By confirm_password = By.xpath("//input[@id='confirmPassword']");
    public By signup_button = By.xpath("//button[@type='submit']");

    HomePage homePage = new HomePage();


    public void navigatetosignuppage(){
        homePage.loadhomepage();
        homePage.clickonelement(homePage.pop_up_message);
        homePage.clickonelement(homePage.signUp_button);
    }


}
