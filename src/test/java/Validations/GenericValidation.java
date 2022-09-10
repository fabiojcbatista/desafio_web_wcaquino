package Validations;

import Framework.Browser.Waits;
import PageObjects.GenericPage;
import org.openqa.selenium.WebDriver;

public class GenericValidation {
    private WebDriver driver;
    private GenericPage genericPage;
    private Waits waits;

    public GenericValidation(WebDriver driver) {
        this.driver = driver;
        genericPage = new GenericPage(this.driver);
        waits = new Waits(this.driver);
    }
}