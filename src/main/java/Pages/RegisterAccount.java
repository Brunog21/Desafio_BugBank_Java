package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegisterAccount {
    WebDriver driver;
    By email = By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/input[1]");
    By name = By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]");
    By password = By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]");
    By confirmPassword = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input");
    By btnCreateAccount = By.xpath("//button[contains(text(),'Cadastrar')]");
    By confirmbtn = By.xpath("//*[@id='btnCloseModal']");
    By btnSaldo = By.id("toggleAddBalance");

    public RegisterAccount(WebDriver driver) {
        this.driver = driver;
    }

    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static String registeredEmail;
    public static String registeredEmailInsert;

    static List<String> registeredEmails = new ArrayList<String>();

    public void RegisterNewAccount(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            Thread.sleep(1000);
            registeredEmail = getSaltString() + "@gmail.com";
            driver.findElement(email).sendKeys(registeredEmail);
            driver.findElement(name).sendKeys(getSaltString());
            driver.findElement(password).sendKeys("123");
            driver.findElement(confirmPassword).sendKeys("123");
            driver.findElement(btnSaldo).click();
            driver.findElement(btnCreateAccount).click();
            Thread.sleep(1000);
            driver.findElement(confirmbtn).click();
            driver.navigate().refresh();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(text(),'Registrar')]")).click();
            registeredEmails.add(registeredEmail);
        }
    }
}
