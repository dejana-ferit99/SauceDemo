package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    public HomePage() {
    }

    public static void connectToServer(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
    }
}
