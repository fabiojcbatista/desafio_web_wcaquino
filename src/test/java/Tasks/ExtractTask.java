package Tasks;

import PageObjects.ExtractPage;
import Validations.ExtractValidation;
import org.openqa.selenium.WebDriver;

public class ExtractTask {
    private WebDriver driver;
    private ExtractPage extractPage;
    private ExtractValidation extractValidation;

    public ExtractTask(WebDriver driver) {
        this.driver = driver;
        extractPage = new ExtractPage(this.driver);
        extractValidation = new ExtractValidation(this.driver);
    }

    public void acessarMovimentacao() {
        extractPage.getExtractLink().click();
        extractValidation.validationExtracPage();
    }

    public void verificarMovimentacaoParametrizado(String paymentDate, String description, String value, String account, String row, String situation) {
        extractValidation.validationExtract(description,paymentDate,account,value,situation,row);
    }
}