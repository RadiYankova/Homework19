import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageOne extends BaseClass{
    public PageOne(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public void NavigateToSite(){
        Driver().navigate().to("https://example.testproject.io/web/");
    }

    By fullName = By.xpath("//input[@placeholder=\"Enter your full name\"]");
    By password = By.xpath("//input[@placeholder=\"Enter your password\"]");
    By loginButton = By.id("login");
    By errorMessage1 = By.xpath("//div[contains(text(), 'Password is invalid')]");
    By errorMessage2 = By.xpath("//div[contains(text(), 'Please provide your full name')]");
    By validationMessage =By.id("greetings");

    public void Login(String name, String pass){
        findElementWithWait(fullName).sendKeys(name);
        findElementWithWait(password).sendKeys(pass);
        findElementWithWait(loginButton).click();
    }

    public String AssertErrorValidationMessage(By element) {
        return findElementWithWait(element).getText();
    }
//    public boolean LoginButtonIsDisplayed(){
//        boolean isElementPresent = true;
//        try{
//            Driver().findElement(loginButton);
//        }
//        catch(NoSuchElementException e){
//            isElementPresent = false;
//        }
//        return isElementPresent;
//    }
}
