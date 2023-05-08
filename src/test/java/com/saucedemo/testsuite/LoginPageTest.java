package com.saucedemo.testsuite;

import com.saucedemo.pages.ProductsPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    com.saucedemo.pages.LoginPage loginPage = new com.saucedemo.pages.LoginPage();
    ProductsPage productsPage = new ProductsPage();
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new com.saucedemo.pages.LoginPage();
        productsPage = new ProductsPage();

    }
    @Test(groups = {"sanity" , "regression"})
    //1. userSholdLoginSuccessfullyWithValidCredentials
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //* Enter “standard_user” username
        loginPage.enterLoginId();
        //* Enter “secret_sauce” password
        loginPage.enterPassword();
        //* Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        //* Verify the text “PRODUCTS”
        Assert.assertEquals(productsPage.verifyTextProducts(),"Products");
    }

    @Test(groups = {"smoke" , "regression"})
    //verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        loginPage.enterLoginId();
        //* Enter “secret_sauce” password
        loginPage.enterPassword();
        //* Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        //* Verify that six products are displayed on page
        Assert.assertEquals(productsPage.verifyTotalProductOfNumber(), 6);
    }
}