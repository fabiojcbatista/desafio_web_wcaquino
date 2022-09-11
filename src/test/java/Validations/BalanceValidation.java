package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.ExtractPage;
import PageObjects.TransactionPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ExtractValidation {
    private WebDriver driver;
    private ExtractPage extractPage;
    private Waits waits;

    public ExtractValidation(WebDriver driver) {
        this.driver = driver;
        extractPage = new ExtractPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationExtracPage() {
        try {
            waits.loadElement(extractPage.getTable());
            Assertions.assertTrue(extractPage.getTable().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina de resumo mensal com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao acessar a pagina de resumo mensal - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }
    public void validationExtract(String description, String paymentDate, String account, String value, String situation, String row ) {
        try {
            waits.loadElement(extractPage.getRowAndColumnOfTableTextField(row,"1"));
            String labeldescription = extractPage.getRowAndColumnOfTableTextField(row,"1").getText();
            Assertions.assertEquals(labeldescription, description);

            waits.loadElement(extractPage.getRowAndColumnOfTableTextField(row,"2"));
            String labelpaymentDate = extractPage.getRowAndColumnOfTableTextField(row,"2").getText();
            Assertions.assertEquals(labelpaymentDate, paymentDate);

            waits.loadElement(extractPage.getRowAndColumnOfTableTextField(row,"3"));
            String labelaccount = extractPage.getRowAndColumnOfTableTextField(row,"3").getText();
            Assertions.assertEquals(labelaccount, account);

            waits.loadElement(extractPage.getRowAndColumnOfTableTextField(row,"4"));
            String labelvalue = extractPage.getRowAndColumnOfTableTextField(row,"4").getText();
            value = value.concat(".00").replace("-","");
            Assertions.assertEquals(labelvalue, value);

            waits.loadElement(extractPage.getRowAndColumnOfTableTextField(row,"5"));
            String labelsituation = extractPage.getRowAndColumnOfTableTextField(row,"5").getText();
            Assertions.assertEquals(labelsituation, situation);

            Report.log(Status.PASS, "Movimentações validadas com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao validar as movimentações - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }
}