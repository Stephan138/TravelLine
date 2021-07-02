package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage{
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage enterLogin(String login){
        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password){
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage tapButton(){
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Войти']"));
        loginButton.click();
        return this;
    }

    public LoginPage forgotButton(){
        WebElement forgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        forgotButtonTest.click();
        return this;
    }

    public LoginPage backButton(){
        WebElement backButtonTest = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[1]/tl-button/button/span[1]/span[2]/span[2]"));
        backButtonTest.click();
        return this;
    }

    public LoginPage emailInput(String email){
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage hilButton(){
        WebElement hilButton = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[2]/tl-button/button/span[1]/span[2]"));
        hilButton.click();
        return this;
    }

    public LoginPage  languageOne(String language1){
        WebElement languageOneTest = driver.findElement(By.className(language1));
        languageOneTest.click();
        return this;
    }

    public LoginPage  languageTwo(String language2){
        WebElement languageOneTest = driver.findElement(By.className(language2));
        languageOneTest.click();
        return this;
    }
 }