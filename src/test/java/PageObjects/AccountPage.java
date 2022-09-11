package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;
    private Waits waits;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getAccountNameTextField() {
        return driver.findElement(By.id("nome"));
    }

    public WebElement getAccountLink() {
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[2]/a[@href='/']"));
    }

    public WebElement getAddAccountLink() {
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[2]/ul/li[1]/a[@href='/addConta']"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
    }

    public WebElement getSucessAlert() {
        return driver.findElement(By.xpath("//div[@class='alert alert-success']"));
    }
}