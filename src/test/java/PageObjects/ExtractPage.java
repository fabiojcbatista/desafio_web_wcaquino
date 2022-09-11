package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtractPage {
    private WebDriver driver;
    private Waits waits;

    public ExtractPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTable() {
        return driver.findElement(By.id("tabelaExtrato"));
    }

    public WebElement getRowAndColumnOfTableTextField(String row, String column) {
        return driver.findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr[".concat(row).concat("]/td[").concat(column).concat("]")));
    }

    public WebElement getExtractLink() {
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[4]/a"));
    }
}