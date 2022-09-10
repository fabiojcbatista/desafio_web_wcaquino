package Tasks;

import PageObjects.RegisterPage;
import Validations.GenericValidation;
import Validations.LoginValidation;
import Validations.RegisterValidation;
import org.openqa.selenium.WebDriver;

public class RegisterTask {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginValidation loginValidation;
    private RegisterValidation registerValidation;
    private GenericValidation genericValidation;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
        registerValidation = new RegisterValidation(this.driver);
    }

    public void efetuarCadastroParametrizado(String user, String email, String password) {
        registerPage.getUserNameTextField().sendKeys(user);
        registerPage.getUserEmailTextField().sendKeys(email);
        registerPage.getPasswordTextField().sendKeys(password);
        registerPage.getAddUserButton().click();
        registerValidation.validationRegister();
    }

    public void efetuarLoginParametrizado(String user, String email, String password) {
        registerPage.getUserEmailTextField().sendKeys(email);
        registerPage.getPasswordTextField().sendKeys(password);
        registerPage.getAddUserButton().click();
        registerValidation.validationPlataformAccess(user);
    }
}