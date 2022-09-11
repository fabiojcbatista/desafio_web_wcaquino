package Tasks;

import PageObjects.AccountPage;
import Validations.AccountValidation;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class AccountTask {
    private WebDriver driver;
    private AccountPage accountPage;
    private AccountValidation accountValidation;

    public AccountTask(WebDriver driver) {
        this.driver = driver;
        accountPage = new AccountPage(this.driver);
        accountValidation = new AccountValidation(this.driver);
    }

    public void criarContasDespesaReceitaParametrizado(String account) {
        accountPage.getAccountLink().click();
        accountPage.getAddAccountLink().click();
        accountValidation.validationAccountPage();
        accountPage.getAccountNameTextField().sendKeys(account);
        accountPage.getSaveButton().click();
        accountValidation.validationAccount();
    }
}