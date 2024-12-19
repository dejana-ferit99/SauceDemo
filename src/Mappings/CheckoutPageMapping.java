package Mappings;

import org.openqa.selenium.By;

public class CheckoutPageMapping {
    public static By fieldFirstName = By.cssSelector("[data-test='firstName']");
    public static By fieldLastName = By.cssSelector("[data-test='lastName']");
    public static By fieldZipCode = By.cssSelector("[data-test='postalCode']");
    public static By btnContinue = By.cssSelector("[data-test='continue']");
    public static By txtItemName = By.cssSelector("[data-test='inventory-item-name']");
    public static By itemTotal = By.cssSelector("div.summary_subtotal_label");
    public static By totalPrice = By.cssSelector("[data-test='total-label']");
    public static By btnFinish = By.cssSelector("[data-test='finish']");
    public static By txtThankYou = By.cssSelector("[data-test='complete-header']");
    public static By btnBackHome = By.cssSelector("[data-test='back-to-products']");
    public static By cartItems = By.cssSelector("[data-test='inventory-item']");
}
