package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TransferenciaUserHome {
    WebDriver driver;
    String contaDigital;
    By accountNumberTransferencia = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input");
    By digitoAccount = By.xpath("//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[2]/input[1]");
    By transferValue = By.xpath("//body/div[@id='__next']/div[1]/div[3]/form[1]/div[2]/input[1]");
    By description = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[3]/input");
    By transferbtn = By.xpath("//button[contains(text(),'Transferir agora')]");
    By closebtn = By.id("btnCloseModal");
    By backbtn = By.id("btnBack");
    public TransferenciaUserHome(WebDriver driver){
        this.driver = driver;
    }

    public void Fazertransferencia(String contaTransferencia) throws InterruptedException {
        WebElement contaDigitalElement = driver.findElement(By.id("textAccountNumber"));
        contaDigital = contaDigitalElement.getText();
        Thread.sleep(1000);
        String numeroConta = contaTransferencia.substring(0,contaTransferencia.length()-1);
        String digitoConta = contaTransferencia.substring(contaTransferencia.length()-1,contaTransferencia.length());
        driver.findElement(digitoAccount).sendKeys(digitoConta);
        driver.findElement(accountNumberTransferencia).sendKeys(numeroConta);
        driver.findElement(transferValue).sendKeys("500");
        driver.findElement(description).sendKeys("TransferenciaBancaria");
        driver.findElement(transferbtn).click();
        Thread.sleep(1000);
        driver.findElement(closebtn).click();
        Thread.sleep(1000);
        driver.findElement(backbtn).click();
    }
}
