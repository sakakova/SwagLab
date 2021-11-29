package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static WebDriver driver;

    public void getLoginPage() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void loginToMainPage() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }
    public String getUrlMainPage() {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(By.className("app_logo")).isDisplayed();
    }


    public void loginWithLockedOutUser() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    public String  getErrorMessage() {
        WebElement msg=driver.findElement(By.xpath("//h3[@data-test='error']"));
        String text=msg.getText();
        System.out.println("ACTUAL result: "+text);
        return text;
    }

}
