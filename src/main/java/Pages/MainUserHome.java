package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MainUserHome {
    WebDriver driver;

    public MainUserHome(WebDriver driver) {
        this.driver = driver;

    }

    //  By digitalAccountNumber = By.id("textAccountNumber");
    By extratnButton = By.xpath("//*[@id=\"btn-EXTRATO\"]/span/img");
    By exitbtn = By.id("btnExit");

    By transferenciatbn = By.id("btn-TRANSFERÊNCIA");
    By backbtn = By.id("btnBack");

    List<String> AccountMoneyList = new ArrayList<String>();

    String contaDigital;

    public String saveAccountNumber() throws InterruptedException {
        Thread.sleep(2000);
        WebElement accountnumber = driver.findElement(By.id("textAccountNumber"));
        String accountNumber = accountnumber.getText().replaceAll("[^\\d]", "");
        AccountMoneyList.add(accountNumber);
        ;
        return accountNumber;
    }

    public void numberAccountDigital() throws InterruptedException {
        Thread.sleep(5000);
        WebElement contaDigitalElement = driver.findElement(By.id("textAccountNumber"));
        this.contaDigital = contaDigitalElement.getText();
    }

    public void extratobtn() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(extratnButton).click();
    }

    public void exitAccount() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(exitbtn).click();
    }

    public void transferenciaScreen() throws InterruptedException {
        driver.findElement(transferenciatbn).click();
    }
}
