package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{
    AndroidDriver driver;

    public LandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Text")
    private WebElement TextOption;

    public BasePage TapTextOption(){
        Tap(TextOption);
//TODO add matching POM for the return value
        return new BasePage(driver);
    }
}
