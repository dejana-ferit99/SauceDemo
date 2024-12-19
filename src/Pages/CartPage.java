package Pages;

import Mappings.CartPageMapping;
import Mappings.CheckoutPageMapping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class CartPage {
    WebDriver driver;
    SetDriver setDriver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.setDriver = new SetDriver(driver);
    }

    public boolean verifyItemIsInCart() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            boolean itemInCart = setDriver.waitForElementToAppear(CartPageMapping.cartItem, Duration.ofSeconds(10));
            Assert.assertTrue(itemInCart, "Item is not added to chart!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("Item is not visiable in cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean removeFromCart() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement removeButton = setDriver.findElement(CartPageMapping.btnRemove, Duration.ofSeconds(10));
            removeButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Item is not visiable in cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkIfCartIsEmpty() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            boolean itemInCartButton = setDriver.waitForElementToAppear(CartPageMapping.btnContinueShopping, Duration.ofSeconds(10));
            Assert.assertTrue(itemInCartButton, "Item in cart can not be found!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("There is mote items in cart or something is wrong with displaying page!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean navigateBackToInventory() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement btnContinueShopping = setDriver.findElement(CartPageMapping.btnContinueShopping, Duration.ofSeconds(10));
            btnContinueShopping.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Button can not be clicked!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean navigateToCheckout() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement checkoutButton = setDriver.findElement(CartPageMapping.btnCheckout, Duration.ofSeconds(10));
            checkoutButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Checkout button can not be clicked!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkAmountOfItemsAtCheckout(int expectedItemNumber){
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            List<WebElement> itemsInCart = driver.findElements(CheckoutPageMapping.cartItems);
            int itemNumber = itemsInCart.size();
            Assert.assertEquals(itemNumber, expectedItemNumber, "Expected and actual number of items in cart is not equal!");
            return true;
        } catch (Exception e) {
            String error = "Incorrect number of items at checkout!";
            lsExceptions.add(error);
            System.err.println(error);
            throw new RuntimeException(error);
        }
    }

}
