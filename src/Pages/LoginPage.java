package Pages;

import Mappings.LoginPageMappings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class LoginPage {
    WebDriver driver;
    SetDriver setDriver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.setDriver = new SetDriver(driver);
    }

    public boolean verifyLoginPageIsDisplayed() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            boolean loginPageLogo = setDriver.waitForElementToAppear(LoginPageMappings.imgPageLogo, Duration.ofSeconds(10));
            Assert.assertTrue(loginPageLogo, "Login page logo is not displayed.");
            return true;
        } catch (Exception e) {
            String error = "Exception occurred while verifying login page: " + e.getMessage();
            lsExceptions.add(error);
            System.err.println(error);
            return false;
        }
    }


    public boolean fillLoginForm(String username, String password) {
        ArrayList<String> lsExceptions = new ArrayList<>();
        try {
            WebElement usernameField = setDriver.findElement(LoginPageMappings.inputdUsername, Duration.ofSeconds(10));
            WebElement passwordField = setDriver.findElement(LoginPageMappings.inputPassword, Duration.ofSeconds(10));
            usernameField.sendKeys(username);
            Thread.sleep(1000);
            cleanField(LoginPageMappings.inputPassword);
            passwordField.sendKeys(password);
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to enter values.");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean clickLoginButton() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement loginbtn = setDriver.findElement(LoginPageMappings.btnLogin, Duration.ofSeconds(10));
            loginbtn.click();
            return true;
        } catch (Exception e) {
            String error = "Exception occurred while verifying login button: " + e.getMessage();
            lsExceptions.add(error);
            System.err.println(error);
            return false;
        }
    }

    public boolean cleanField(By locator){
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed() && element.isEnabled()) {
                element.clear();
                return true;
            } else {
                lsExceptions.add("Element is not enabled or not displayed: " + locator);
                System.err.println(lsExceptions.get(0));
                return false;
            }
        } catch (Exception e) {
            lsExceptions.add("Failed to clear the field for locator: " + locator + ". Error: " + e.getMessage());
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean verifyLoginErrorMessage(String expectedErrorMessage) {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement errorMessage = setDriver.findElement(LoginPageMappings.txtLoginError, Duration.ofSeconds(10));
            String actualErrorText = errorMessage.getText();
            Assert.assertEquals(actualErrorText, expectedErrorMessage, "Difference found!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to verify login error message.");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }
}
