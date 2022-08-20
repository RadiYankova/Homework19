import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    private WebDriver driver;
    private WebDriverWait wait;

    public BaseClass(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver Driver() {
        return driver;
    }

    public WebDriverWait Wait() {
        return wait;
    }

    public WebElement findElementWithWait(By locator){
        return Wait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isDisplayed(By element){
        boolean isElementPresent = true;
        try{
            Driver().findElement(element);
        }
        catch(NoSuchElementException e){
            isElementPresent = false;
        }
        return isElementPresent;
    }

}
