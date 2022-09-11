package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.TransactionPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class TransactionValidation {
    private WebDriver driver;
    private TransactionPage transactionPage;
    private Waits waits;

    public TransactionValidation(WebDriver driver) {
        this.driver = driver;
        transactionPage = new TransactionPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationTransaction() {
        try {
            waits.loadElement(transactionPage.getSucessAlert());
            String label = transactionPage.getSucessAlert().getText();
            Assertions.assertEquals(label, "Movimentação adicionada com sucesso!");
            Report.log(Status.PASS, "Inseriu com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao inserir movimentação - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }

    public void validationTransactionPage() {
        try {
            waits.loadElement(transactionPage.getTransationTypeSelect());
            Assertions.assertTrue(transactionPage.getTransationTypeSelect().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina de movimentações com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao acessar a pagina de movimentações - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }
}
