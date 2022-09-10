package Framework.Utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FakersGeneration {
    private Faker faker;
    private String email;
    private String userName;
    private String valor;
    private String data;
    private String password;

    public FakersGeneration(WebDriver driver) {
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getUserName() {
        this.userName = faker.name().firstName();
        return this.userName;
    }

    public String getEmail() {
        this.email = faker.internet().emailAddress();
        return this.email;
    }

    public String getValor() {
        this.valor = faker.commerce().price();
        return this.valor;
    }

    public String getData() {
        this.data = DateTime.getDateTimeFormatScreenshot();
        return this.data;
    }

    public String getPassword() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());
        this.password = fakeValuesService.regexify("[a-z1-9]{10}");
        return this.password;
    }
}