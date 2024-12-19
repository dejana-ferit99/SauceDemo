package Pages;

import Mappings.InventoryPageMappings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InventoryPage {
    WebDriver driver;
    SetDriver setDriver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.setDriver = new SetDriver(driver);
    }

    public boolean verifyInventoryPageIsDisplayed() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try{
            boolean loginPageLogo = setDriver.waitForElementToAppear(InventoryPageMappings.inventoryPageLogo, Duration.ofSeconds(10));
            Assert.assertTrue(loginPageLogo, "Inventory page Logo is not visiable!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("Inventory page logo is not displayed!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean clickSortButton(){
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try{
            WebElement sortButton = setDriver.findElement(InventoryPageMappings.btnSort, Duration.ofSeconds(10));
            sortButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed click sort button");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean selectLowToHighSort(){
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement buttonLowToHigh = setDriver.findElement(InventoryPageMappings.btnLowToHigh, Duration.ofSeconds(10));
            buttonLowToHigh.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed click sort button");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkLowToHighSort() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            List<WebElement> inventoryItems = driver.findElements(InventoryPageMappings.inventoryItems);
            List<Double> prices = new ArrayList<>();
            for (WebElement item : inventoryItems) {
               String txtPrice = item.findElement(InventoryPageMappings.itemPrice).getText();
               double price = Double.parseDouble(txtPrice.replace("$", "").trim());
               prices.add(price);
            }
            for (int i = 1; i < prices.size(); i++) {
                if(prices.get(i) < prices.get(i - 1)) {
                    lsExceptions.add("Items are not sorted correctly from low to high!");
                    System.err.println(lsExceptions.get(0));
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            lsExceptions.add("Sort failed!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkTwitterLink() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement buttonLowToHigh = setDriver.findElement(InventoryPageMappings.lnkTwitter, Duration.ofSeconds(10));
            buttonLowToHigh.click();
            Thread.sleep(2000);
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            driver.switchTo().window(childWindow);
            Thread.sleep(5000);
            boolean TwitterLogo = setDriver.waitForElementToAppear(InventoryPageMappings.txtTwitter, Duration.ofSeconds(10));
            if (TwitterLogo){
                driver.close();
                driver.switchTo().window(parentWindow);
                return true;
            } else
                return false;
        } catch (Exception e) {
            lsExceptions.add("Failed to open Twitter!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkFacebookLink() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement buttonLowToHigh = setDriver.findElement(InventoryPageMappings.lnkFacebook, Duration.ofSeconds(10));
            buttonLowToHigh.click();
            Thread.sleep(2000);
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            driver.switchTo().window(childWindow);
            Thread.sleep(5000);
            boolean FacebookAllowAll = setDriver.waitForElementToAppear(InventoryPageMappings.txtFacebook, Duration.ofSeconds(10));
            if (FacebookAllowAll){
                driver.close();
                driver.switchTo().window(parentWindow);
                return true;
            } else
                return false;
        } catch (Exception e) {
            lsExceptions.add("Failed to open Facebook!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean checkLinkedinLink() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement buttonLowToHigh = setDriver.findElement(InventoryPageMappings.lnkLinkedin, Duration.ofSeconds(10));
            buttonLowToHigh.click();
            Thread.sleep(2000);
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            driver.switchTo().window(childWindow);
            Thread.sleep(5000);
            boolean newToLinkdeIn = setDriver.waitForElementToAppear(InventoryPageMappings.txtLinkedin, Duration.ofSeconds(10));
            if (newToLinkdeIn){
                driver.close();
                driver.switchTo().window(parentWindow);
                return true;
            } else
                return false;
        } catch (Exception e) {
            lsExceptions.add("Failed to open Linkedin!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean addChepestItemToCart() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement addToCart = setDriver.findElement(InventoryPageMappings.btnAddCheapestItemToCart, Duration.ofSeconds(10));
            addToCart.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed add item to cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean addFirstItemToCart() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement addToCart = setDriver.findElement(InventoryPageMappings.btnAddToCart, Duration.ofSeconds(10));
            addToCart.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed add item to cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean removeFirstItemToCart() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement removeToCart = setDriver.findElement(InventoryPageMappings.btnRemoveToCart, Duration.ofSeconds(10));
            removeToCart.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to remove from cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean openInventoryItemAndVerifyName() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement itemButton = setDriver.findElement(InventoryPageMappings.txtItemName, Duration.ofSeconds(10));
            String itemNameClicked = itemButton.getText();
            itemButton.click();
            WebElement itemName = setDriver.findElement(InventoryPageMappings.txtItemName, Duration.ofSeconds(10));
            String itemNameOpened = itemName.getText();
            Assert.assertEquals(itemNameClicked, itemNameOpened, "Items name are not equal!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to remove from cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }


    public boolean verifyCartBadge() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement cartBadge = setDriver.findElement(InventoryPageMappings.txtCartBadge, Duration.ofSeconds(10));
            String txtCartBadge = cartBadge.getText();
            Assert.assertEquals(txtCartBadge, "1", "Quantity is not equal!");
            return true;
        } catch (Exception e) {
            lsExceptions.add("Cart badge is not found or there was an issue with getting the text!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }

    public boolean openCart() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement cartButton = setDriver.findElement(InventoryPageMappings.btnCart, Duration.ofSeconds(10));
            cartButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed to open cart!");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }
}
