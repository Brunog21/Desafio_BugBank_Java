package StepDefinition;

import Pages.*;
import Utils.GerenciamentoDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugBank {
    private GerenciamentoDriver gerenciamentoDriver;
    private WebDriver driver;

    private String contaSecundaria;

    @Before
    public void before() {
        GerenciamentoDriver gerenciamentoDriver = new GerenciamentoDriver();
        driver = gerenciamentoDriver.browser("chrome");
    }


    @Given("que esteja na home do site {string}")
    public void que_esteja_na_home_do_site(String url) {
        driver.get(url);

        WebElement confirmation = driver.findElement(By.xpath("//h1[contains(text(),'O banco com bugs e falhas do seu jeito')]"));
        String confirmacao = confirmation.getText();

        if (confirmacao.contains("O banco com bugs e falhas do seu jeito")) {
            System.out.println("Teste vai ocorrer Corretamente");
        } else {
            System.out.println("Teste feito apenas para dar certo");
            driver.quit();
        }
    }

    @When("criar duas contas com saldo")
    public void criar_uma_conta_com_saldo_para_fazer_transferencia() throws InterruptedException {
        MainHome MainHome = new MainHome(driver);
        MainHome.registerAccountPage();
        RegisterAccount RegisterAccount = new RegisterAccount(driver);
        RegisterAccount.RegisterNewAccount(2);
    }

    @When("Validar saldo da primeira conta")
    public void validar_saldo_da_primeira_conta() throws InterruptedException {
        MainHome MainHome = new MainHome(driver);
        MainHome.LoginAccount(0);
        MainUserHome MainUserHome = new MainUserHome(driver);
        MainUserHome.extratobtn();
        ExtratoUser ExtratoUser = new ExtratoUser(driver);
        MainUserHome.exitAccount();
    }

    @When("validar saldo da segunda conta")
    public void validar_saldo_da_segunda_conta() throws InterruptedException {
        MainHome MainHome = new MainHome(driver);
        MainHome.LoginAccount(1);
        MainUserHome MainUserHome = new MainUserHome(driver);
        contaSecundaria = MainUserHome.saveAccountNumber();
        MainUserHome.extratobtn();
        TransferenciaUserHome transferenciaUserHome = new TransferenciaUserHome(driver);
        ExtratoUser ExtratoUser = new ExtratoUser(driver);
        MainUserHome.exitAccount();
    }

    @Then("Fazer transferencia")
    public void fazer_transferencia() throws InterruptedException {
        MainHome mainHome = new MainHome(driver);
        mainHome.LoginAccount(0);
        MainUserHome mainUserHome = new MainUserHome(driver);
        mainUserHome.transferenciaScreen();
        TransferenciaUserHome transferenciaUserHome = new TransferenciaUserHome(driver);
        transferenciaUserHome.Fazertransferencia(contaSecundaria);
    }

    @Then("Validar o saldo da conta transferida")
    public void validar_o_saldo_da_conta_transferida() throws InterruptedException {
        MainUserHome MainUserHome = new MainUserHome(driver);
        MainUserHome.extratobtn();
        ExtratoUser ExtratoUser = new ExtratoUser(driver);
        ExtratoUser.accounttransfervalue();
        MainHome MainHome = new MainHome(driver);
        MainUserHome.exitAccount();
    }

    @Then("Validar o saldo na conta transferida")
    public void validar_o_saldo_na_conta_transferida() throws InterruptedException {
        MainHome MainHome = new MainHome(driver);
        MainHome.LoginAccount(1);
        MainUserHome MainUserHome = new MainUserHome(driver);
        MainUserHome.extratobtn();
        ExtratoUser ExtratoUser = new ExtratoUser(driver);
        ExtratoUser.accountrecebyvalue();
    }

    @After
    public void after() {
        driver.quit();
    }
}
