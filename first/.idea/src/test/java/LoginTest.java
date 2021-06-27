import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Авторизация на форме")
    @Parameters({"login", "password"})
    public void loginTest(String login, String password) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Войти']"));
        loginButton.click();

        WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или пароль.']"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или пароля не отобразился");
    }

    @Test
    public void RememberTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");
        WebElement RememberTest = driver.findElement(By.xpath("//input[@text='Забыли пароль?']"));
        RememberTest.click();
    }

    @Test
    public void ForgotTest(String login, String email) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);

        WebElement hilButton = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[2]/tl-button/button"));
        hilButton.click();

        WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или Email.']"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или Email не отобразился");
    }

    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}