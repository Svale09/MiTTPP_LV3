package PageObjects;

import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasePage extends AppiumUtilities {
    private AndroidDriver driver;

    public BasePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void Tap(WebElement element){
        waitForElementToAppearByElement(element, driver);
        element.click();
    }

    public void InputText(WebElement element, String text){
        waitForElementToAppearByElement(element, driver);
        element.sendKeys(text);
    }

    public String GetText(WebElement element){
        waitForElementToAppearByElement(element, driver);
        return element.getText();
    }
    public void TapReturnButton(){
        driver.navigate().back();
    }
}
