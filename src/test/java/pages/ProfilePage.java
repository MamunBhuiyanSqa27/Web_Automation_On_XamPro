package pages;

import org.openqa.selenium.By;


public class ProfilePage extends BasePage{

    public By profile_dropdown = By.xpath("//div[@class='profile-view-btn nav-item dropdown']//a[@id='basic-nav-dropdown']");
    public By profile = By.xpath("//span[normalize-space()='Profile']");
    public By dob = By.xpath("//input[@id='dob']");
    public By gender = By.xpath("//input[@id='radio-gender-male']");
    public By education = By.xpath("//select[@id='education']");
    //public By select_education = By.xpath("//select[@id='education']/option[@value='BSC']");
    public By university = By.xpath("//div[@class=' css-19bb58m']");
    public By select_university = By.xpath("//div[text()='University of Dhaka']");
    public By update_button = By.xpath("//button[normalize-space()='Update']");

    HomePage homePage = new HomePage();



    public void navigatetoprofilepage(){
        homePage.loadhomepage();
        homePage.clickonelement(homePage.pop_up_message);
        //homePage.clickonelement(homePage.signIn_button);
    }


}
