package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddTextPage extends BasePage{
    private AndroidDriver driver;

    public AddTextPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Add")
    private WebElement AddText;

    @AndroidFindBy(id = "io.appium.android.apis:id/text")
    private WebElement TextBox;

    public AddTextPage TapAddText(){
        Tap(AddText);
        return this;
    }

    public String RetriveInputText(){
        return GetText(TextBox);
    }
}
