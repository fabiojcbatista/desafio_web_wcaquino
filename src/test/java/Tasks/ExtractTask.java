package Tasks;

import Enum.ESituation;
import Enum.ETypeTransation;
import PageObjects.TransactionPage;
import Validations.TransactionValidation;
import org.openqa.selenium.WebDriver;

public class TransactionTask {
    private WebDriver driver;
    private TransactionPage transactionPage;
    private TransactionValidation transactionValidation;

    public TransactionTask(WebDriver driver) {
        this.driver = driver;
        transactionPage = new TransactionPage(this.driver);
        transactionValidation = new TransactionValidation(this.driver);
    }

    public void criarMovimentacaoParametrizado(String paymentDate, String transactionDate, String description, String interested, String value, String account, ETypeTransation typeTransaction, ESituation situation) {
        transactionPage.getTransactionLink().click();
        transactionValidation.validationTransactionPage();

        transactionPage.getTransationTypeSelect().click();
        if (ETypeTransation.RECEITA.equals(typeTransaction)) {
            transactionPage.getRevenueTransationTypeSelect().click();
        } else {
            transactionPage.getExpenseTransationTypeSelect().click();
        }

        transactionPage.getTransationDateTextField().sendKeys(transactionDate);
        transactionPage.getPaymentDateTextField().sendKeys(paymentDate);
        transactionPage.getDescriptionTextField().sendKeys(description);
        transactionPage.getInterestedTextField().sendKeys(interested);
        transactionPage.getValueTextField().sendKeys(value);

        transactionPage.getAccountTextField().click();
        switch (account) {
            case "Salário":
                transactionPage.getAccount1TextField().click();
                break;
            case "Aluguel":
                transactionPage.getAccount2TextField().click();
                break;
            case "Empréstimo":
                transactionPage.getAccount3TextField().click();
                break;
            default:
                break;
        }

        if (ESituation.PAGO.equals(situation)) {
            transactionPage.getSituationPaidTextField().click();
        } else {
            transactionPage.getSituationOutstandingTextField().click();
        }

        transactionPage.getSaveButton().click();
        transactionValidation.validationTransaction();
    }
}