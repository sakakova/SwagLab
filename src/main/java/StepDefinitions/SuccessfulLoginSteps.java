package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SuccessfulLoginSteps {

    WebDriver driver = null;

    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() throws InterruptedException {
        System.out.println("The User is on the Login Page");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is :"+projectPath);

        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.navigate().to("https://www.saucedemo.com/");
        Thread.sleep(1000);

    }
    @When("User enters Username and the Password credentials")
    public void user_enters_username_and_the_password_credentials() throws InterruptedException {

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        System.out.println("Entered Username and Password");
        Thread.sleep(2000);
    }
    @And("User clicks loginButton")
    public void user_clicks_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        System.out.println("Clicked Submit Button");
    }
    @When("User redirected to the Main Page")
    public void user_redirected_to_the_main_page() {
        System.out.println("The User redirected to the Main Page");
    }
    @Then("User verify the App Logo exists")
    public void user_verify_the_app_logo_exists() {
        driver.findElement(By.id("//div[@id='']")).isDisplayed();
        System.out.println("The user verified the App Logo");

        driver.close();
        driver.quit();
    }
}
