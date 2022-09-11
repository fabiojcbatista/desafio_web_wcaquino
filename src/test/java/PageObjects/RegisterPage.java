package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private Waits waits;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getAddUserButton() {
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public WebElement getPasswordTextField() {
        return driver.findElement(By.id("senha"));
    }

    public WebElement getSucessAlert() {
        return driver.findElement(By.xpath("//div[@class='alert alert-success']"));
    }

    public WebElement getUserEmailTextField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getUserNameTextField() {
        return driver.findElement(By.id("nome"));
    }
}