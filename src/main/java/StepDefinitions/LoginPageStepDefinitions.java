package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;


public class LoginPageStepDefinitions {
 private final LoginPage loginPage;

    public LoginPageStepDefinitions(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("I am on the Sauce Demo Login Page")
    public void iAmOnTheSauceDemoLoginPage(){
        loginPage.getLoginPage();
    }

    @When("I fill the account information for account StandardUser into the Username field and the Password field")
    public void iFillTheAccountInformationForAccountStandardUserIntoTheUsernameFieldAndThePasswordField() throws InterruptedException {
        loginPage.loginToMainPage();
    }

    @And("I click the Login Button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I am redirected to the Sauce Demo Main Page")
    public void iAmRedirectedToTheSauceDemoMainPage() {
            Assert.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.getUrlMainPage());
        System.out.println(loginPage.getUrlMainPage());
    }

    @And("I verify the App Logo exists")
    public void iVerifyTheAppLogoExists() {
        Assert.assertTrue( loginPage.isLogoDisplayed());
    }

    @When("I fill the account information for account LockedOutUser into the Username field and the Password field")
    public void iFillTheAccountInformationForAccountLockedOutUserIntoTheUsernameFieldAndThePasswordField() throws InterruptedException {
//        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//        System.out.println("Entered Username and Password");
//        Thread.sleep(2000);
        loginPage.loginWithLockedOutUser();
    }

    @Then("I verify the Error Message contains the text {string}")
    public void iVerifyTheErrorMessageContainsTheText(String errorMessage) {
//        Assert.assertEquals(errorMessage, driver.findElement(By.xpath("<h3 data-test=\"error\" xpath=\"1\"></h3>")).toString());
//        driver.close();
        Assert.assertTrue(loginPage.getErrorMessage().contains(errorMessage));

    }
}
