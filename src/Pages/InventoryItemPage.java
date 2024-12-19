package Pages;

import Mappings.InventoryItemPageMappings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;

public class InventoryItemPage {

    WebDriver driver;
    SetDriver setDriver;

    public InventoryItemPage(WebDriver driver) {
        this.driver = driver;
        this.setDriver = new SetDriver(driver);
    }

    public boolean clickAddToCartButton() {
        ArrayList<Object> lsExceptions = new ArrayList<>();
        try {
            WebElement addToCartButton = setDriver.findElement(InventoryItemPageMappings.btnAddToCart, Duration.ofSeconds(10));
            addToCartButton.click();
            return true;
        } catch (Exception e) {
            lsExceptions.add("Failed click add to cart button");
            System.err.println(lsExceptions.get(0));
            return false;
        }
    }
}
