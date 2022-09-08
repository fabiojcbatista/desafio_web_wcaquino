package Framework.Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.Locale;

public class FakersGeneration {
    private Faker faker;
    private String firstName;
    private String valor;
    private String data;

    public FakersGeneration(WebDriver driver){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getInteressado(){
        firstName = faker.name().firstName();
        return firstName;
    }

    public String getValor(){
        valor = faker.commerce().price();
        return valor;
    }

    public String getData(){
        data = DateTime.getDateTimeFormatScreenshot();
        return data;
    }
}