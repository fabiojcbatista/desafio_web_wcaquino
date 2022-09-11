package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.AccountPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountValidation {
    private WebDriver driver;
    private AccountPage accountPage;
    private Waits waits;

    public AccountValidation(WebDriver driver) {
        this.driver = driver;
        accountPage = new AccountPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationAccount() {
        try {
            waits.loadElement(accountPage.getSucessAlert());
            String label = accountPage.getSucessAlert().getText();
            Assertions.assertEquals(label, "Conta adicionada com sucesso!");
            Report.log(Status.PASS, "Registrou uma nova conta com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao registrar uma nova conta - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }

    public void validationAccountPage() {
        try {
            waits.loadElement(accountPage.getAccountNameTextField());
            Assertions.assertTrue(accountPage.getAccountNameTextField().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina de Cadastro de Contas com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao acessar a pagina de Cadastro de Contas - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }
}
