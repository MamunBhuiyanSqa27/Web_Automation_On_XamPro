package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class DriverSetup {

    //public WebDriver driver;

    private static String browsername = System.getProperty("browser", "Chrome");

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverSetup.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public WebDriver getbrowser(String browsername){
        if(browsername.equalsIgnoreCase("Chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("C:\\Users\\MB Mamun Bhuiyan\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
            chromeOptions.addArguments("user-data-dir=C:\\Users\\MB Mamun Bhuiyan\\AppData\\Local\\Google\\Chrome for Testing\\User Data");
            return new ChromeDriver(chromeOptions);
        }
        else if (browsername.equalsIgnoreCase("Firefox")) {
            return new FirefoxDriver();
        }
        else if (browsername.equalsIgnoreCase("Edge")) {
            return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser is not currently available with the given name: " +browsername);
        }
    }


    @BeforeMethod
    public void openabrowser(){
        //open a browser
        WebDriver driver= getbrowser(browsername);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        setDriver(driver);
    }


    @AfterMethod
    public void closedriver(){
        //quit browser
        getDriver().quit();
    }
}
