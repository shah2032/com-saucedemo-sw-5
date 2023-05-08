package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement getTextProducts;

    @CacheLookup
    @FindBy(className = "inventory_item")
    List<WebElement> getTotalProductQty;


    public String verifyTextProducts() {
        Reporter.log("Get Text Product" + getTextProducts.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Product");
        return getTextFromElement(getTextProducts);
    }

    public int verifyTotalProductOfNumber() {
        int expectedQty = 6;
        List<WebElement> actualElement = getTotalProductQty;
        int actualQty = actualElement.size();
        System.out.println("Total Products displayed are: " + actualQty);
        Reporter.log("Get Product Qty" + getTextProducts.toString());
        CustomListeners.test.log(Status.PASS, "Get Product Qty");
        return actualQty;
    }
}
