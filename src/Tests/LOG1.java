package Tests;

import Mappings.LoginPageMappings;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LOG1 {
    public WebDriver driver;
    public SetDriver setDriver;
    public HomePage homePage;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage();
        setDriver = new SetDriver(driver);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void LOGIN1(){
        String expectedErrorText = "Epic sadface: Username and password do not match any user in this service";
        String expectedThankYouPageText = "Thank you for your order!";

        homePage.connectToServer(driver);
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.fillLoginForm("standard_user", "123456");
        loginPage.clickLoginButton();
        loginPage.verifyLoginErrorMessage(expectedErrorText);
        loginPage.cleanField(LoginPageMappings.inputdUsername);
        loginPage.cleanField(LoginPageMappings.inputPassword);
        loginPage.fillLoginForm("standard_", "secret_sauce");
        loginPage.clickLoginButton();
        loginPage.verifyLoginErrorMessage(expectedErrorText);
        loginPage.cleanField(LoginPageMappings.inputdUsername);
        loginPage.cleanField(LoginPageMappings.inputPassword);
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.verifyInventoryPageIsDisplayed();
        inventoryPage.clickSortButton();
        inventoryPage.selectLowToHighSort();
        inventoryPage.checkLowToHighSort();
        inventoryPage.checkTwitterLink();
        inventoryPage.checkFacebookLink();
        inventoryPage.checkLinkedinLink();
        inventoryPage.addChepestItemToCart();
        inventoryPage.verifyCartBadge();
        inventoryPage.openCart();
        cartPage.verifyItemIsInCart();
        cartPage.removeFromCart();
        cartPage.checkIfCartIsEmpty();
        cartPage.navigateBackToInventory();
        inventoryPage.addChepestItemToCart();
        inventoryPage.openCart();
        cartPage.navigateToCheckout();
        checkoutPage.populateCheckoutData("Test", "Lastname", "10001");
        checkoutPage.clickContinue();
        checkoutPage.checkOrderOverview();
        checkoutPage.clickFinish();
        checkoutPage.verifyThankYouPage(expectedThankYouPageText);
        checkoutPage.clickBackHome();
        inventoryPage.verifyInventoryPageIsDisplayed();

    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
