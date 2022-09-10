package TestCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.FakersGeneration;
import Tasks.LoginTask;
import Tasks.RegisterTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarLoginComSucesso extends TestBase {
    private WebDriver driver = this.getDriver();
    private LoginTask loginTask = new LoginTask(driver);
    private RegisterTask registerTask = new RegisterTask(driver);
    private FakersGeneration fakersGeneration = new FakersGeneration(driver);

    public final String USER_NAME = fakersGeneration.getUserName();
    private final String EMAIL = fakersGeneration.getEmail();
    private final String PASSWORD = fakersGeneration.getPassword();

    @Test
    @Tag("regressao")
    public void realizarAcesso() {
        try {

            Report.creatTest("Realizar movimentações", ReportType.GROUP);
            Report.createStep("Acessar o site");
            loginTask.AcessarSite();

            Report.createStep("Registrar um novo usuário");
            registerTask.efetuarCadastroParametrizado(USER_NAME, EMAIL, PASSWORD);

            Report.createStep("Acessar a plataforma");
            registerTask.efetuarLoginParametrizado(USER_NAME, EMAIL, PASSWORD);

            Report.createStep("Criar contas de Receitas e Despesas");
            Report.createStep("Inserir movimentações");
            Report.createStep("Validar as movimentações inseridas");
            Report.createStep("Validar saldo conforme as movimentações criadas");

        } catch (Exception e) {
            Report.log(Status.FAIL, "Ocorreu um erro: ".concat(e.getMessage()), Screenshot.capture(driver));
        }
    }
}