package org.example;

import PageObjects.AddTextPage;
import PageObjects.BasePage;
import PageObjects.TextPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    @Test
    public void OpenApp(){
        TextPage textPage= landingPage.TapTextOption();

        AddTextPage addTextPage = textPage.TapLogTextBoxOption();

        addTextPage.TapAddText();

        Assert.assertEquals(addTextPage.RetriveInputText(), "This is a test\n");

        addTextPage.TapReturnButton();
        textPage.TapReturnButton();

        Assert.assertTrue(landingPage.IsTextVisible());
    }
}
