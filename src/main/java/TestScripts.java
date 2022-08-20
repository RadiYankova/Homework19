import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

public class TestScripts extends BaseTestClass {

    @Test
    public void LoginSuccessfully() throws InterruptedException {
        PageOne login = new PageOne(driver, wait);
        login.NavigateToSite();
        login.Login("Reni Yankova", "12345");

        PageTwo afterLogin = new PageTwo(driver, wait);
        Assert.assertTrue(afterLogin.isDisplayed(afterLogin.logOutButton));
        Thread.sleep(5000);
    }

    @Test
    public void SaveDetailsLogOut() {
        PageOne login = new PageOne(driver, wait);
        login.NavigateToSite();
        login.Login("Reni Yankova", "12345");

        PageTwo afterLogin = new PageTwo(driver, wait);
        afterLogin.Country("Bulgaria");

        afterLogin.AddressEmailPhone("Sofia", "mymail@mail.com", "02505050");
        afterLogin.SaveLogout();

        Assert.assertTrue(login.isDisplayed(login.loginButton));
        var stop = 0;
    }

    @ParameterizedTest
    @CsvSource({"1, Radostina, 12345, Hello Radostina",
                "2, Radostina, 123, Password is invalid",
                "3, '', 12345, Please provide your full name"})


    public void LoginOptions(int testNum, String fullname, String password, String message) throws InterruptedException {
        PageOne login = new PageOne(driver, wait);
        login.NavigateToSite();
        login.Login(fullname, password);
        if(testNum==1){ Assert.assertEquals(message+", let's complete the test form:", login.AssertErrorValidationMessage(login.validationMessage));}
            else if(testNum==2) { Assert.assertEquals(message, login.AssertErrorValidationMessage(login.errorMessage1));}
                    else Assert.assertEquals(message, login.AssertErrorValidationMessage(login.errorMessage2));
        Thread.sleep(5000);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestUsers.csv")

    public void LoginOptionsFromFile(int testNum, String fullname, String password, String message) throws InterruptedException {
        PageOne login = new PageOne(driver, wait);
        login.NavigateToSite();
        login.Login(fullname, password);
        if (testNum == 1) {
            Assert.assertEquals(message + ", let's complete the test form:", login.AssertErrorValidationMessage(login.validationMessage));
        } else if (testNum == 2) {
            Assert.assertEquals(message, login.AssertErrorValidationMessage(login.errorMessage1));
        } else Assert.assertEquals(message, login.AssertErrorValidationMessage(login.errorMessage2));
        Thread.sleep(5000);
    }

}
