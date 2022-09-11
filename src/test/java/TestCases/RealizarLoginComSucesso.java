package TestCases;

import Enum.ESituation;
import Enum.ETypeTransation;
import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.DateTime;
import Framework.Utils.FakersGeneration;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class RealizarLoginComSucesso extends TestBase {
    private WebDriver driver = this.getDriver();
    private AccountTask accountTask = new AccountTask(driver);
    private LoginTask loginTask = new LoginTask(driver);
    private ExtractTask extractTask = new ExtractTask(driver);
    private BalanceTask balanceTask = new BalanceTask(driver);
    private RegisterTask registerTask = new RegisterTask(driver);
    private TransactionTask transactionTask = new TransactionTask(driver);
    private FakersGeneration fakersGeneration = new FakersGeneration(driver);
    private DateTime dateTime = new DateTime();
    private String saldoEsperado;

    public final String USER_NAME = fakersGeneration.getUserName();
    public final String VALUE_RECEITA_PAGA = "5000";
    public final String VALUE_RECEITA_PAGA_BONUS = "2000";
    public final String VALUE_DESPESA_PAGA = "800";
    public final String VALUE_DESPESA_PENDENTE = "500";
    private final String EMAIL = fakersGeneration.getEmail();
    private final String PASSWORD = fakersGeneration.getPassword();
    public final String CONTA[] = {"Salário", "Aluguel", "Empréstimo"};

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
            accountTask.criarContasDespesaReceitaParametrizado(CONTA[0]);
            accountTask.criarContasDespesaReceitaParametrizado(CONTA[1]);
            accountTask.criarContasDespesaReceitaParametrizado(CONTA[2]);

            Report.createStep("Inserir movimentações");
            transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                    "Movimentação de conta do tipo receita paga", USER_NAME, VALUE_RECEITA_PAGA, CONTA[0], ETypeTransation.RECEITA, ESituation.PAGO);

            transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                    "Movimentação de conta do tipo receita paga bônus", USER_NAME, VALUE_RECEITA_PAGA_BONUS, CONTA[0], ETypeTransation.RECEITA, ESituation.PAGO);

            transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                    "Movimentação de conta do tipo despesa paga", USER_NAME, VALUE_DESPESA_PAGA, CONTA[1], ETypeTransation.DESPESA, ESituation.PAGO);

            transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                    "Movimentação de conta do tipo despesa pendente", USER_NAME, VALUE_DESPESA_PENDENTE, CONTA[2], ETypeTransation.DESPESA, ESituation.PENDENTE);

            Report.createStep("Validar saldo conforme as movimentações criadas");
            int saldoReceita = Integer.parseInt(VALUE_RECEITA_PAGA) + Integer.parseInt(VALUE_RECEITA_PAGA_BONUS);
            this.saldoEsperado = String.valueOf(saldoReceita);
            balanceTask.verificarSaldoParametrizado(saldoEsperado, VALUE_DESPESA_PAGA);

            Report.createStep("Validar as movimentações inseridas");
            extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo receita paga", VALUE_RECEITA_PAGA, CONTA[0], "1", "Pago");
            extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo receita paga bônus", VALUE_RECEITA_PAGA_BONUS, CONTA[0], "2", "Pago");
            extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo despesa paga", VALUE_DESPESA_PAGA, CONTA[1], "3", "Pago");
            extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo despesa pendente", VALUE_DESPESA_PENDENTE, CONTA[2], "4", "Pendente");

        } catch (Exception e) {
            Report.log(Status.FAIL, "Ocorreu um erro: ".concat(e.getMessage()), Screenshot.capture(driver));
        }
    }
}