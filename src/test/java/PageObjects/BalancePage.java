package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BalancePage {
    private WebDriver driver;
    private Waits waits;

    public BalancePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getBalanceLink() {
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[1]/a"));
    }

    public WebElement getRowAndColumnOfTableTextField(String row, String column) {
        return driver.findElement(By.xpath("//*[@id='tabelaSaldo']/tbody/tr[".concat(row).concat("]/td[").concat(column).concat("]")));
    }

    public WebElement getTable() {
        return driver.findElement(By.id("tabelaSaldo"));
    }
}