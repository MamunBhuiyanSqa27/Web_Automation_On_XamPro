package testcases;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.DataProvider;
import pages.LoginPage;
import utilities.DriverSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestLoginPage extends DriverSetup{

    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    LoginPage loginPage = new LoginPage();


    @BeforeMethod
    public void loadpage(){
        loginPage.navigatetologinpage();
    }


    @Test(dataProvider ="dp")
    public void userLogin(String email, String password) throws InterruptedException {
        loginPage.clickonelement(loginPage.login_email);
        loginPage.writeonelement(loginPage.login_email, email); //email
        loginPage.clickonelement(loginPage.login_password);
        loginPage.writeonelement(loginPage.login_password, password); //password
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.login_button);
        Thread.sleep(10000);
    }

    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException {
        FileReader reader = new FileReader("./src/test/java/jsonfiles/LoginData.json");
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject userloginsJsonobj = new JSONObject(tokener);
        JSONArray userloginsArray = userloginsJsonobj.getJSONArray("userlogins");

        Object[][] array = new Object[1][2];
        JSONObject users = userloginsArray.getJSONObject(userloginsArray.length()-1);
        array[0][0] = users.getString("email");;
        array[0][1] = users.getString("password");

        return array;
    }

//    @DataProvider(name = "dp")
//    public Object[][] readJson() throws IOException {
//        FileReader reader = new FileReader("./src/test/java/jsonfiles/LoginData.json");
//        JSONTokener tokener = new JSONTokener(reader);
//        JSONObject userloginsJsonobj = new JSONObject(tokener);
//        JSONArray userloginsArray = userloginsJsonobj.getJSONArray("userlogins");
//
//        Object[][] array = new Object[userloginsArray.length()][2];
//
//        for (int i = 0; i < userloginsArray.length(); i++) {
//            JSONObject users = userloginsArray.getJSONObject(i);
//            String email = users.getString("email");
//            String password = users.getString("password");
//
//            array[i][0] = email;
//            array[i][1] = password;
//        }
//
//        return array;
//    }


}
