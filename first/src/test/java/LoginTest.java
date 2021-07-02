import LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @Test(description = "Проверка в браузерах")
    @Parameters("browser")
    public void setUp(String browser){
        driver = getBrowser(browser);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");
    }

    public WebDriver getBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            return new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
            return new EdgeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
            return new FirefoxDriver();
        }
        return null;
    }
    @Test(description = "Авторизация на форме")
    @Parameters({"login", "password"})
    public void loginTest(String login, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLogin(login)
                 .enterPassword(password)
                 .tapButton();

        WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или пароль.']"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или пароля не отобразился");
    }


    @Test(description = "Ставится отметка")
    public void rememberTest(){
        WebElement rememberTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div[2]/div/label/span/tl-icon"));
        rememberTest.click();
    }

    @Test(description = "Проверка работы кнопки Забыли пароль")
    public void forgotButtonTest(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.forgotButton();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[1]/div/tl-alert"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт укажите логин и связанный с ним email-адрес");
    }

    @Test(description = "Проверка работы кнопки AppStore")
    public void appStoreTest(){
        WebElement appStoreTest = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]"));
        appStoreTest.click();
    }

    @Test(description = "Проверка работы кнопки GooglePlay")
    public void googlePlayTest(){

        WebElement googlePlayTest = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]"));
        googlePlayTest.click();
    }

    @Test(description = "Проверка работы кнопки Вернуться")
    public void backButtonTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotButton()
                 .backButton();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"login-cont\"]/div"));
        Assert.assertTrue(alert.isDisplayed(), "Вход в личный кабинет ");
    }

    @Test(description = "Проверка работы кнопок с языками")
    @Parameters({"language1", "language2", "text"})
    public void languageTest(String language1, String language2, String text){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.languageOne(language1)
                 .languageTwo(language2);

        WebElement button = driver.findElement(By.className(text));
        Assert.assertTrue(button.isDisplayed(), "Вход в личный кабинет ");
    }


    @Test(description = "Проверка работы замены пароля для отрицательных данных")
    @Parameters({"login", "email"})
    public void forgotTest(String login, String email) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotButton()
                 .enterLogin(login)
                 .emailInput(email)
                 .hilButton();

        WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или Email.']"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или Email не отобразился");
    }

    @Test(description = "Проверка работы замены пароля для положительных данных")
    @Parameters({"login", "email"})
    public void correctforgotTest(String login, String email) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotButton()
                .enterLogin(login)
                .emailInput(email)
                .hilButton();

        WebElement alert = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div/span/span[1]/span"));
        Assert.assertTrue(alert.isDisplayed(), "О правельном вводе логина или Email не отобразился");
    }


    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}