package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.BalancePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class BalanceValidation {
    private WebDriver driver;
    private BalancePage balancePage;
    private Waits waits;

    public BalanceValidation(WebDriver driver) {
        this.driver = driver;
        balancePage = new BalancePage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationBalance(String saldoConta1, String saldoConta2) {
        try {
            waits.loadElement(balancePage.getRowAndColumnOfTableTextField("1", "2"));
            String labelvalue = balancePage.getRowAndColumnOfTableTextField("1", "2").getText();
            Assertions.assertEquals(labelvalue, saldoConta1);

            waits.loadElement(balancePage.getRowAndColumnOfTableTextField("2", "2"));
            String labelvalue2 = balancePage.getRowAndColumnOfTableTextField("2", "2").getText();
            Assertions.assertEquals(labelvalue2, saldoConta2);

            Report.log(Status.PASS, "Saldo validado com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao validar o saldo - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }

    public void validationBalancePage() {
        try {
            waits.loadElement(balancePage.getTable());
            Assertions.assertTrue(balancePage.getTable().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina Home com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao acessar a pagina Home- ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }
}
