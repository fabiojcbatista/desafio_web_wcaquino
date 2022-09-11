package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPage {
    private WebDriver driver;
    private Waits waits;

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTransationTypeSelect() {
        return driver.findElement(By.id("tipo"));
    }

    public WebElement getRevenueTransationTypeSelect() {
        return driver.findElement(By.xpath("//*[@id='tipo']/option[1]"));
    }

    public WebElement getExpenseTransationTypeSelect() {
        return driver.findElement(By.xpath("//*[@id='tipo']/option[2]"));
    }

    public WebElement getTransationDateTextField() {
        return driver.findElement(By.id("data_transacao"));
    }

    public WebElement getPaymentDateTextField() {
        return driver.findElement(By.id("data_pagamento"));
    }

    public WebElement getDescriptionTextField() {
        return driver.findElement(By.id("descricao"));
    }

    public WebElement getInterestedTextField() {
        return driver.findElement(By.id("interessado"));
    }

    public WebElement getValueTextField() {
        return driver.findElement(By.id("valor"));
    }

    public WebElement getAccountTextField() {
        return driver.findElement(By.id("conta"));
    }

    public WebElement getAccount1TextField() {
        return driver.findElement(By.xpath("//*[@id='conta']/option[1]"));
    }

    public WebElement getAccount2TextField() {
        return driver.findElement(By.xpath("//*[@id='conta']/option[2]"));
    }

    public WebElement getAccount3TextField() {
        return driver.findElement(By.xpath("//*[@id='conta']/option[3]"));
    }


    public WebElement getSituationPaidTextField() {
        return driver.findElement(By.id("status_pago"));
    }

    public WebElement getSituationOutstandingTextField() {
        return driver.findElement(By.id("status_pendente"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/form/div[4]/button"));
    }

    public WebElement getTransactionLink() {
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[3]/a"));
    }

    public WebElement getSucessAlert() {
        return driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        //Movimentação adicionada com sucesso!
    }
}