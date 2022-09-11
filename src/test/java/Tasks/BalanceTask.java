package Tasks;

import PageObjects.BalancePage;
import PageObjects.ExtractPage;
import Validations.BalanceValidation;
import Validations.ExtractValidation;
import org.openqa.selenium.WebDriver;

public class BalanceTask {
    private WebDriver driver;
    private BalancePage balancePage;
    private BalanceValidation balanceValidation;

    public BalanceTask(WebDriver driver) {
        this.driver = driver;
        balancePage = new BalancePage(this.driver);
        balanceValidation = new BalanceValidation(this.driver);
    }

    public void verificarSaldoParametrizado(String saldoConta1,String saldoConta2) {
        balancePage.getBalanceLink().click();
        balanceValidation.validationBalancePage();
        balanceValidation.validationBalance(saldoConta1,saldoConta2);
    }
}