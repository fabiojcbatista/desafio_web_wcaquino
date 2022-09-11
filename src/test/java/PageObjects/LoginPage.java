package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private Waits waits;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getNewUserLink() {
        return driver.findElement(By.xpath("//*[contains(@href,'/cadastro')]"));
    }

    public WebElement getUserNameTextField() {
        return driver.findElement(By.id("email"));
    }
}