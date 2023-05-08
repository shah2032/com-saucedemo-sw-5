package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "user-name")
    WebElement loginLink;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordLink;

    @CacheLookup
    @FindBy(name = "login-button")
    WebElement loginButton;


    public void enterLoginId() {
        Reporter.log("Enter email ID" + loginLink.toString());
        sendTextToElement(loginLink, "standard_user");
        CustomListeners.test.log(Status.PASS, "Enter email ID");
    }

    public void enterPassword() {
        Reporter.log("Enter Password" + passwordLink.toString());
        sendTextToElement(passwordLink, "secret_sauce");
        CustomListeners.test.log(Status.PASS, "Enter Password");
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on Login Button");
    }
}


