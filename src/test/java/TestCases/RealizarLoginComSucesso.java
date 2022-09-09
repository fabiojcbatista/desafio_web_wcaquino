package TestCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.HomeTask;
import Tasks.NewUserTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarLoginComSucesso extends TestBase {
    private WebDriver driver = this.getDriver();
    HomeTask homeTask = new HomeTask(driver);
    NewUserTask newUserTask = new NewUserTask(driver);

    @Test
    @Tag("regressao")
    public void realizarLogin() {
        try {
            Report.creatTest("Realizar login com sucesso", ReportType.SINGLE);
            homeTask.efetuarLogin();
            Report.creatTest("Realizar cadastro com sucesso", ReportType.SINGLE);
            newUserTask.efetuarCadastro();
        } catch (Exception e) {
            Report.log(Status.FAIL, "Não foi possível realizar login com sucesso: "+ e.getMessage(), Screenshot.capture(driver));
        }
    }
}
