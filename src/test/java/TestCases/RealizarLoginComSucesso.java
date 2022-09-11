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
    private BalanceTask balanceTask = new BalanceTask(driver);
    private DateTime dateTime = new DateTime();
    private ExtractTask extractTask = new ExtractTask(driver);
    private FakersGeneration fakersGeneration = new FakersGeneration(driver);
    private LoginTask loginTask = new LoginTask(driver);
    private RegisterTask registerTask = new RegisterTask(driver);
    private TransactionTask transactionTask = new TransactionTask(driver);

    private final String CONTA[] = {"Salário", "Aluguel", "Empréstimo"};
    private final String EMAIL = fakersGeneration.getEmail();
    private final String SENHA = fakersGeneration.getPassword();
    private final String USUARIO = fakersGeneration.getUserName();
    private final String VALOR_DESPESA_PAGA = "800";
    private final String VALOR_RECEITA_PAGA = "5000";
    private final String VALOR_RECEITA_PAGA_BONUS = "2000";
    private final String VALOR_DESPESA_PENDENTE = "500";

    @Test
    @Tag("regressao")
    public void realizarAcesso() {
        try {

            Report.creatTest("Realizar movimentações", ReportType.GROUP);
            Report.createStep("Acessar o site");
            loginTask.AcessarSite();

            Report.createStep("Registrar um novo usuário");
            registerTask.efetuarCadastroParametrizado(USUARIO, EMAIL, SENHA);

            Report.createStep("Acessar a plataforma");
            registerTask.efetuarLoginParametrizado(USUARIO, EMAIL, SENHA);

            Report.createStep("Criar contas de Receitas e Despesas");
            accountTask.criarContasDespesaReceitaParametrizado(CONTA[0]);
            accountTask.criarContasDespesaReceitaParametrizado(CONTA[1]);
            accountTask.criarContasDespesaReceitaParametrizado(CONTA[2]);

            Report.createStep("Inserir movimentações");
            transactionTask.acessarTransactionPage();
            try {
                transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                        "Movimentação de conta do tipo receita paga", USUARIO, VALOR_RECEITA_PAGA, CONTA[0], ETypeTransation.RECEITA, ESituation.PAGO);
                transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                        "Movimentação de conta do tipo receita paga bônus", USUARIO, VALOR_RECEITA_PAGA_BONUS, CONTA[0], ETypeTransation.RECEITA, ESituation.PAGO);
                transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                        "Movimentação de conta do tipo despesa paga", USUARIO, VALOR_DESPESA_PAGA, CONTA[1], ETypeTransation.DESPESA, ESituation.PAGO);
                transactionTask.criarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), dateTime.getDateTimeNowFormat(),
                        "Movimentação de conta do tipo despesa pendente", USUARIO, VALOR_DESPESA_PENDENTE, CONTA[2], ETypeTransation.DESPESA, ESituation.PENDENTE);
            } catch (Exception e) {
                Report.log(Status.FAIL, "Ocorreu um erro: ".concat(e.getMessage()), Screenshot.capture(driver));
            }

            Report.createStep("Validar saldo conforme as movimentações criadas");
            balanceTask.verificarSaldoParametrizado("7000.00", "-800.00");

            Report.createStep("Validar as movimentações inseridas");
            extractTask.acessarMovimentacao();
            try {
                extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo receita paga", "5000.00", CONTA[0], "1", "Pago");
                extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo receita paga bônus", "2000.00", CONTA[0], "2", "Pago");
                extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo despesa paga", "-800.00", CONTA[1], "3", "Pago");
                extractTask.verificarMovimentacaoParametrizado(dateTime.getDateTimeNowFormat(), "Movimentação de conta do tipo despesa pendente", "-500.00", CONTA[2], "4", "Pendente");
                Report.log(Status.PASS, "Movimentações validadas com sucesso", Screenshot.captureBase64(driver));
            } catch (Exception e) {
                Report.log(Status.FAIL, "Ocorreu um erro: ".concat(e.getMessage()), Screenshot.capture(driver));
            }

        } catch (Exception e) {
            Report.log(Status.FAIL, "Ocorreu um erro: ".concat(e.getMessage()), Screenshot.capture(driver));
        }
    }
}