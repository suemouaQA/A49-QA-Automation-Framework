package StepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginStepDefinitions{
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--diable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
    @Given("I open Login Page")
    public void iOpenLoginPage() {
        LoginPage.openLogin();
    }
    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage.enterEmail(email);
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage.enterPassword(password);
    }
    @And("I submit")
    public void iSubmit() {
        LoginPage.submit();
    }
    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage.loggedIn();
    }
}