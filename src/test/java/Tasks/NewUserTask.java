package Tasks;

        import PageObjects.NewUserPage;
        import Validations.GenericValidation;
        import Validations.LoginValidation;
        import org.openqa.selenium.WebDriver;

public class NewUserTask {
    private WebDriver driver;
    private NewUserPage newUserPage;
    private LoginValidation loginValidation;
    private GenericValidation genericValidation;

    public NewUserTask (WebDriver driver){
        this.driver = driver;
        newUserPage = new NewUserPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
        genericValidation = new GenericValidation(this.driver);
    }

    public void efetuarCadastro(){
        loginValidation.validationLoginPage();
        newUserPage.getUserNameTextField().sendKeys("Ana Fernandes");
        newUserPage.getUserEmailTextField().sendKeys("ana.fernandes@gmail.com");
        newUserPage.getPasswordTextField().sendKeys("ana.fernandes");
        newUserPage.getAddUserButton().click();
        genericValidation.validationPageProducts();
    }

    public void efetuarCadastroParametrizado(String user, String email, String password){
        loginValidation.validationLoginPage();
        newUserPage.getUserNameTextField().sendKeys(user);
        newUserPage.getUserEmailTextField().sendKeys(email);
        newUserPage.getPasswordTextField().sendKeys(password);
        newUserPage.getAddUserButton().click();
        genericValidation.validationPageProducts();
    }
}