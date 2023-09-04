package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class HomePage extends BasePage{
    @FindBy(id = "nameofuser")
    public WebElement nameofuser;

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceText;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartBtn;

    public void verifyWelcomeMessage(){
        BrowserUtils.waitFor(2);
        String actualMessage=nameofuser.getText();
        Assert.assertTrue(actualMessage.contains(ConfigurationReader.get("username")));
    }
    public void verifyWelcomeMessage(String nameOfUser){
        BrowserUtils.waitFor(2);
        String actualMessage=nameofuser.getText();
        Assert.assertTrue(actualMessage.contains(nameOfUser));
    }

    public int addProduct(String product,String category){

        String categoryMenu="//a[text()='"+category+"']";

        String item="//a[text()='"+product+"']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(categoryMenu),5);
            WebElement categoryElm=Driver.get().findElement(By.xpath(categoryMenu));
            categoryElm.click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(categoryMenu),5);
        }
        try {
            BrowserUtils.waitForClickablility(By.xpath(item),5);
            WebElement productItem=Driver.get().findElement(By.xpath(item));
            productItem.click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(item),5);
        }

        String[] arrayAmount = priceText.getText().split(" ");
        System.out.println(Arrays.toString(arrayAmount));
        //substring(..)method ile bir string ifadesinden bazı verileri atlayaral okuyabiliriz
        int lastPrice = Integer.parseInt(arrayAmount[0].substring(1));
        System.out.println("lastPrice = " + lastPrice);

        addToCartBtn.click();
        BrowserUtils.waitFor(2);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();

        homeLink.click();
        BrowserUtils.waitFor(2);

        return lastPrice;
    }
}
