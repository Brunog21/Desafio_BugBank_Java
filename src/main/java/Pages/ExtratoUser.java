package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtratoUser {
    WebDriver driver;

    By exitbtn = By.id("btnExit");

    By extratMoney = By.id("textBalanceAvailable");

    public ExtratoUser(WebDriver driver) {
        this.driver = driver;
    }

    public void exitAccount() throws InterruptedException {
        driver.findElement(exitbtn).click();
    }

    public void accounttransfervalue() throws InterruptedException {
        WebElement element = driver.findElement(extratMoney);
        String value = element.getText();
        if (!value.equals("R$ 1.000,00")) {
            System.out.println("O valor não é igual a 1000, transferencia ocorreu com sucesso");
        } else {
            Assert.fail("Teste falhou! O valor é igual ou maior que 1000.");
            driver.quit();
        }
    }

    public void accountrecebyvalue() throws InterruptedException {
        WebElement element = driver.findElement(extratMoney);
        String value = element.getText();
        if (value.equals("R$ 1.500,00")) {
            System.out.println("O valor é igual a 1500, transferencia ocorreu com sucesso (valor Fixo)");
        } else {
            Assert.fail("Teste falhou! O valor é diferente de 1500.");
            driver.quit();
        }
    }
}