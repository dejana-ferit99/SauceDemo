package Mappings;

import org.openqa.selenium.By;

public class LoginPageMappings {

    public static By imgPageLogo = By.cssSelector("#root > div > div.login_logo");
    public static By inputdUsername =  By.id("user-name");
    public static By inputPassword = By.id("password");
    public static By btnLogin = By.id("login-button");
    public static By txtLoginError = By.cssSelector("div.error-message-container.error > h3");
}
