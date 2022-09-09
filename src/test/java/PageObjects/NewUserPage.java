package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage {
    private WebDriver driver;
    private Waits waits;

    public NewUserPage(WebDriver driver){
        this.driver = driver;
        waits= new Waits(this.driver);
    }

    public WebElement getUserNameTextField(){
        return driver.findElement(By.id("nome"));
    }

    public WebElement getUserEmailTextField(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordTextField(){
        return driver.findElement(By.id("senha"));
    }

    public WebElement getAddUserButton(){
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }
}