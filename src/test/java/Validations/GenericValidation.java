package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.GenericPage;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidation {
    private WebDriver driver;
    private GenericPage genericPage;
    private Waits waits;

    public GenericValidation(WebDriver driver){
        this.driver = driver;
        genericPage = new GenericPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationPageProducts(){
        try{
            waits.loadElement(genericPage.getHomeLink());
            String label = genericPage.getHomeLink().getText();
            Assertions.assertNotEquals(label, "Seu Barriga");
            Report.log(Status.PASS, " Acessou a pagina Home com sucesso", Screenshot.capture(driver));
        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
    }

}
