package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainHome {
    WebDriver driver;
    By btnRegister = By.xpath("//button[contains(text(),'Registrar')]");
    By emailLogin = By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
    By passwordLogin = By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
    By btnLogin = By.xpath("//button[contains(text(),'Acessar')]");

    public MainHome(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAccountPage() throws InterruptedException {
        driver.findElement(btnRegister).click();
    }

    public void LoginAccount(int index) throws InterruptedException {
        RegisterAccount registerAccount = new RegisterAccount(driver);
        String email = registerAccount.getSaltString();
        driver.findElement(emailLogin).sendKeys(RegisterAccount.registeredEmails.get(index));
        driver.findElement(passwordLogin).sendKeys("123");
        driver.findElement(btnLogin).click();
    }
}
