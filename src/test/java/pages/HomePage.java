package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String homepageurl= "https://www.xampro.org/";

    public By signUp_button = By.xpath("//span[normalize-space()='Registration']");
    public By signIn_button = By.xpath("//a[@class='navbar-login-btn nav-link']");
    public By pop_up_message = By.xpath("//button[@aria-label='Close']");




    public void loadhomepage(){
        loadawebpage(homepageurl);
    }
}

