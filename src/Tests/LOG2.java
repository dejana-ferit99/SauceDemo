package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LOG2 {
    public WebDriver driver;
    public SetDriver setDriver;
    public HomePage homePage;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public InventoryItemPage inventoryItemPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage();
        setDriver = new SetDriver(driver);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        inventoryItemPage =  new InventoryItemPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void LOGIN2() {
        homePage.connectToServer(driver);
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.verifyInventoryPageIsDisplayed();
        inventoryPage.addFirstItemToCart();
        inventoryPage.verifyCartBadge();
        inventoryPage.removeFirstItemToCart();
        inventoryPage.openInventoryItemAndVerifyName();
        inventoryItemPage.clickAddToCartButton();
        inventoryPage.verifyCartBadge();
        inventoryPage.openCart();
        cartPage.navigateBackToInventory();
        inventoryPage.addChepestItemToCart();
        inventoryPage.openCart();
        cartPage.checkAmountOfItemsAtCheckout(2);
        cartPage.navigateToCheckout();
        checkoutPage.populateCheckoutData("Test", "Lastname", "10001");
        checkoutPage.clickContinue();
        checkoutPage.checkOrderOverview();
        checkoutPage.clickFinish();
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
