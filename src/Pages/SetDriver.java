package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetDriver {
    private final WebDriver driver;

    public SetDriver(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
    }

    public boolean waitForElementToAppear(By locator, Duration timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            System.err.println("Failed to find element within timeout: " + locator);
            e.printStackTrace();
            return false;
        }
    }

    public WebElement findElement(By locator, Duration timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            String errorMessage = "Element not found within timeout: " + locator;
            System.err.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

}
