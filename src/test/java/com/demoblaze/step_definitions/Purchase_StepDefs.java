package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPages;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
    HomePage homePage=new HomePage();
    CartPages cartPages=new CartPages();
    int expectedPurchaseAmount=0;
    @When("The user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
        expectedPurchaseAmount+= homePage.addProduct(product, category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

    }
    @When("The user removes {string} from Cart")
    public void the_user_removes_from_cart(String removeProduct) {
        expectedPurchaseAmount-=cartPages.removeProduct(removeProduct);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

    }
    @When("The user places order and captures and log amounts")
    public void the_user_places_order_and_captures_and_log_amounts() {
        cartPages.finishPurchase_logAmount();
    }
    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {
        cartPages.verifyPurchaseAmount(expectedPurchaseAmount);
    }

}

