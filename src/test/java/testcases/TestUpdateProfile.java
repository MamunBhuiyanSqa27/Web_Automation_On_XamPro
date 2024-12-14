package testcases;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProfilePage;
import utilities.DriverSetup;

import java.io.FileReader;
import java.io.IOException;

public class TestUpdateProfile extends DriverSetup {

    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    ProfilePage profilePage = new ProfilePage();

    @BeforeMethod
    public void loadpage(){
        profilePage.navigatetoprofilepage();
    }



    @Test(dataProvider ="dp")
    public void userUpdate(String dob, String gender) throws InterruptedException {
        profilePage.clickonelement(profilePage.profile_dropdown);
        profilePage.clickonelement(profilePage.profile);
        Thread.sleep(5000);
        profilePage.scrollintoelement(profilePage.dob);
        profilePage.clickonelement(profilePage.dob);
        profilePage.writeonelement(profilePage.dob, dob);
        profilePage.clickonelement(profilePage.gender);
        Thread.sleep(3000);
        profilePage.scrollintoelement(profilePage.education);
        Thread.sleep(3000);
        WebElement education = getDriver().findElement(By.id("education"));
        education.click();
        Select select = new Select(education);
        select.selectByIndex(5);
        Thread.sleep(3000);
        profilePage.scrollintoelement(profilePage.university);
        Thread.sleep(5000);
        profilePage.clickonelement(profilePage.university);
        Thread.sleep(3000);
        profilePage.clickonelement(profilePage.select_university);
        Thread.sleep(3000);
        profilePage.scrollintoelement(profilePage.update_button);
        profilePage.clickonelement(profilePage.update_button);
        Thread.sleep(10000);

    }

    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException {
        FileReader reader = new FileReader("./src/test/java/jsonfiles/ProfileUpdateData.json");
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject profileupdateJsonobj = new JSONObject(tokener);
        JSONArray profileupdateArray = profileupdateJsonobj.getJSONArray("profileupdate");

        Object[][] array = new Object[profileupdateArray.length()][2];

        for (int i = 0; i < profileupdateArray.length(); i++) {
            JSONObject users = profileupdateArray.getJSONObject(i);
            String dob = users.getString("dob");
            String gender = users.getString("gender");

            array[i][0] = dob;
            array[i][1] = gender;
        }

        return array;
    }

}
