package Tasks;

import Enum.ESituation;
import Enum.ETypeTransation;
import PageObjects.ExtractPage;
import PageObjects.TransactionPage;
import Validations.ExtractValidation;
import Validations.TransactionValidation;
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

    public void verificarMovimentacaoParametrizado(String paymentDate, String description, String value, String account, String row, String situation) {
        extractPage.getExtractLink().click();
        extractValidation.validationExtracPage();
        extractValidation.validationExtract(description,paymentDate,account,value,situation,row);
    }
}