package testcases;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utilities.DriverSetup;

import java.io.FileReader;
import java.io.IOException;

public class TestSignUpPage extends DriverSetup {


    private static final Logger log = LoggerFactory.getLogger(TestSignUpPage.class);

    SignUpPage signuppage = new SignUpPage();


    @BeforeMethod
    public void loadpage(){
        signuppage.navigatetosignuppage();
    }



    @Test(dataProvider ="dp")
    public void userSignUp(String fullname, String email, String phone, String password, String confirmpassword) throws InterruptedException {
        signuppage.clickonelement(signuppage.full_name);
        signuppage.writeonelement(signuppage.full_name, fullname);
        signuppage.clickonelement(signuppage.email);
        signuppage.writeonelement(signuppage.email, email);
        signuppage.clickonelement(signuppage.phone);
        signuppage.writeonelement(signuppage.phone, phone);
        signuppage.clickonelement(signuppage.password);
        signuppage.writeonelement(signuppage.password, password);
        signuppage.clickonelement(signuppage.confirm_password);
        signuppage.writeonelement(signuppage.confirm_password, confirmpassword);
        Thread.sleep(3000);
        signuppage.clickonelement(signuppage.signup_button);
        Thread.sleep(10000);
    }


    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException {
        FileReader reader = new FileReader("./src/test/java/jsonfiles/SignUpData.json");
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject usersignupJsonobj = new JSONObject(tokener);
        JSONArray usersignupArray = usersignupJsonobj.getJSONArray("usersignup");

        Object[][] array = new Object[usersignupArray.length()][5];

        for (int i = 0; i < usersignupArray.length(); i++) {
            JSONObject users = usersignupArray.getJSONObject(i);
            String fullname = users.getString("fullname");
            String email = users.getString("email");
            String phone = users.getString("phone");
            String password = users.getString("password");
            String confirmpassword = users.getString("confirmpassword");

            array[i][0] = fullname;
            array[i][1] = email;
            array[i][2] = phone;
            array[i][3] = password;
            array[i][4] = confirmpassword;

        }

        return array;
    }


}
