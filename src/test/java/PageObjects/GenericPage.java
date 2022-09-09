package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {
    private WebDriver driver;
    private Waits waits;

    public GenericPage (WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//nav[@class='navbar navbar-default']/div[@class='container-fluid']/div[@class='navbar-header']/a[@class='navbar-brand']"));
    }

    public WebElement getTable(){
        return waits.visibilityOfElement(By.id("tabelaSaldo"));
    }
}

