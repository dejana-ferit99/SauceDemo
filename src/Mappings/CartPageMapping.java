package Mappings;

import org.openqa.selenium.By;

public class CartPageMapping {
    public static By cartItem = By.cssSelector("div.cart_item");
    public static By btnRemove = By.cssSelector("[data-test='remove-sauce-labs-onesie']");
    public static By btnContinueShopping = By.cssSelector("[data-test='continue-shopping']");
    public static By btnCheckout = By.cssSelector("[data-test='checkout']");
}
