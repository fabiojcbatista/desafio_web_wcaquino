package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.RegisterPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class RegisterValidation {
    private WebDriver driver;
    private RegisterPage registerPage;
    private Waits waits;

    public RegisterValidation(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationPlataformAccess(String user) {
        try {
            String Expectedlabel = "Bem vindo, ".concat(user).concat("!");
            waits.loadElement(registerPage.getSucessAlert());
            String label = registerPage.getSucessAlert().getText();
            Assertions.assertEquals(label, Expectedlabel);
            Report.log(Status.PASS, "Acessou a plataforma com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao registrar novo usuário - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegister() {
        try {
            waits.loadElement(registerPage.getSucessAlert());
            String label = registerPage.getSucessAlert().getText();
            Assertions.assertEquals(label, "Usuário inserido com sucesso");
            Report.log(Status.PASS, "Registrou com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao registrar novo usuário - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegisterPage() {
        try {
            waits.loadElement(registerPage.getUserNameTextField());
            Assertions.assertTrue(registerPage.getUserNameTextField().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina de registro com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Falha ao acessar a pagina de registro - ".concat(e.getMessage()), Screenshot.captureBase64(driver));
        }
    }
}