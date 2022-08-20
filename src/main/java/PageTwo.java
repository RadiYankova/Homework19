import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.DimensionUIResource;
import java.time.Duration;
import java.util.List;

public class PageTwo extends BaseClass{

    public PageTwo(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public void NavigateToSite(){
        Driver().navigate().to("https://example.testproject.io/web/");
    }
    By logOutButton = By.xpath("//button[contains(text(),'Logout')]");
    By country = By.id("country");
    By address = By.id("address");
    By email = By.id("email");
    By phone = By.id("phone");
    By save = By.id("save");
    By saved = By.xpath("//span[contains(text(),'Saved')]");

//    public boolean LogOutIsDisplayed(){
//        boolean isElementPresent = true;
//        try{
//            Driver().findElement(logOutButton);
//        }
//        catch(NoSuchElementException e){
//            isElementPresent = false;
//        }
//        return isElementPresent;
//    }

    public void Country(String countyName){
       findElementWithWait(country).click();
       findElementWithWait(By.xpath("//*[contains(text(),'"+countyName+"')]")).click();
    }
    public void AddressEmailPhone(String myAddress, String myEmail, String myPhone){
        findElementWithWait(address).sendKeys(myAddress);
        findElementWithWait(email).sendKeys(myEmail);
        findElementWithWait(phone).sendKeys(myPhone);
    }

    public void SaveLogout(){
        findElementWithWait(save).click();
        Assert.assertTrue(isDisplayed(saved));
        findElementWithWait(logOutButton).click();
    }

//    public boolean SavedIsDisplayed(){
//        boolean isElementPresent = true;
//        try{
//            Driver().findElement(saved);
//        }
//        catch(NoSuchElementException e){
//            isElementPresent = false;
//        }
//        return isElementPresent;
//    }
}
