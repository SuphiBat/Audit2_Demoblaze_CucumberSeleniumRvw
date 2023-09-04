package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();

    }
    @Then("The user verify welcome message")
    public void The_user_verify_welcome_message() {
        homePage.verifyWelcomeMessage();

    }

    @When("The user enters {string} and {string} credential")
    public void theUserEntersAndCredential(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user verify welcome {string} message")
    public void theUserVerifyWelcomeMessage(String nameOfUser) {
        homePage.verifyWelcomeMessage(nameOfUser);
    }

    @When("The user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword(Map<String,String> userInfo){
        loginPage.login(userInfo.get("user"),userInfo.get("password"));
    } {
    }
}
