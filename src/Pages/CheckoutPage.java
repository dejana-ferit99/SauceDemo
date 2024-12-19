package Pages;

import Mappings.CheckoutPageMapping;
import Mappings.InventoryPageMappings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;
    SetDriver setDriver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.setDriver = new SetDriver(driver);
    }

    public boolean populateCheckoutData(String firstName, String lastName, String zipCode) {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement nameField = setDriver.findElement(CheckoutPageMapping.fieldFirstName, Duration.ofSeconds(10));
            WebElement lastField = setDriver.findElement(CheckoutPageMapping.fieldLastName, Duration.ofSeconds(10));
            WebElement zipCodeField = setDriver.findElement(CheckoutPageMapping.fieldZipCode, Duration.ofSeconds(10));

            nameField.sendKeys(firstName);
            lastField.sendKeys(lastName);
            zipCodeField.sendKeys(zipCode);

            if (!nameField.getAttribute("value").equals(firstName) ||
                    !lastField.getAttribute("value").equals(lastName) ||
                    !zipCodeField.getAttribute("value").equals(zipCode)) {
                lsExceptions.add("Failed to populate checkout fields with correct data!");
                System.err.println(lsExceptions.get(0));
                return false;
            }
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to populate checkout data!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean clickContinue(){
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement continueButton = setDriver.findElement(CheckoutPageMapping.btnContinue, Duration.ofSeconds(10));
            continueButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed add item to cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkOrderOverview() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement itemTotal = setDriver.findElement(CheckoutPageMapping.itemTotal, Duration.ofSeconds(10));
            String itemPriceText = itemTotal.getText();
            double itemPrice = Double.parseDouble(itemPriceText.replaceAll("[^\\d.]", "").trim());

            double expectedTotalWithTax = Math.round((itemPrice + (itemPrice * 0.08)) * 100.0) / 100.0;

            WebElement orderTotal = setDriver.findElement(CheckoutPageMapping.totalPrice, Duration.ofSeconds(10));
            String orderTotalText = orderTotal.getText();
            double actualOrderTotal = Double.parseDouble(orderTotalText.replaceAll("[^\\d.]", "").trim());

            Assert.assertEquals(actualOrderTotal, expectedTotalWithTax, "Total amount mismatch!");
            return true;

        } catch (Exception e) {
            lsExceptions.add("An error occurred while checking the order overview: " + e.getMessage());
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean clickFinish(){
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement finishButton = setDriver.findElement(CheckoutPageMapping.btnFinish, Duration.ofSeconds(10));
            finishButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to finish order.");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean verifyThankYouPage(String expectedText) {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try{
            WebElement thankYouElement = setDriver.findElement(CheckoutPageMapping.txtThankYou, Duration.ofSeconds(10));
            String actualThankYouText = thankYouElement.getText();
            Assert.assertEquals(actualThankYouText, expectedText, "Thank you message mismatch!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("Error in Thank You page text!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean clickBackHome() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement backHomeButton = setDriver.findElement(CheckoutPageMapping.btnBackHome, Duration.ofSeconds(10));
            backHomeButton.click();
            boolean isHomePageLoaded = setDriver.waitForElementToAppear(InventoryPageMappings.inventoryPageLogo, Duration.ofSeconds(10));
            Assert.assertTrue(isHomePageLoaded, "Failed to verify navigation to the home page.");
            return true;
        } catch (Exception e) {
            String error = "Exception occurred while clicking 'Back Home': " + e.getMessage();
            lsExceptions.add(error);
            System.err.println(error);
            throw new RuntimeException(error);
        }
    }

}

