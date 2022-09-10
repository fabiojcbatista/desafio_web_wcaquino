package Tasks;

import PageObjects.LoginPage;
import Validations.LoginValidation;
import Validations.RegisterValidation;
import org.openqa.selenium.WebDriver;

public class LoginTask {
    private WebDriver driver;
    private LoginPage loginPage;
    private LoginValidation loginValidation;
    private RegisterValidation registerValidation;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
        registerValidation = new RegisterValidation(this.driver);
    }

    public void AcessarSite() {
        loginValidation.validationLoginPage();
        loginPage.getNewUserLink().click();
        registerValidation.validationRegisterPage();
    }
}
