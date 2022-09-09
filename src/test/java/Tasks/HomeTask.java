package Tasks;

import PageObjects.HomePage;
import Validations.GenericValidation;
import Validations.LoginValidation;
import org.openqa.selenium.WebDriver;

public class HomeTask {
    private  WebDriver driver;
    private  HomePage homePage;
    private LoginValidation loginValidation;
    private GenericValidation genericValidation;

    public HomeTask (WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
        loginValidation = new LoginValidation(this.driver);
        genericValidation = new GenericValidation(this.driver);
    }

    public void efetuarLogin(){
        loginValidation.validationLoginPage();
        homePage.getUserNameTextField().sendKeys("fabiojcbweb@hotmail.com");
        homePage.getPasswordTextField().sendKeys("desafioweb");
        homePage.getLoginButton().click();
        genericValidation.validationPageProducts();
    }

    public void efetuarLoginParametrizado(String user, String password){
        loginValidation.validationLoginPage();
        homePage.getUserNameTextField().sendKeys(user);
        homePage.getPasswordTextField().sendKeys(password);
        homePage.getLoginButton().click();
        genericValidation.validationPageProducts();
    }
}
