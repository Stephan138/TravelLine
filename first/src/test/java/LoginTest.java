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

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");
    }

    @Test(description = "Проверка в браузерах")
    @Parameters("browser")
    public void initialization(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.chrome.driver", "C:\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://www.qatl.ru/secure/");
        } else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.chrome.driver", "C:\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.get("https://www.qatl.ru/secure/");
        }
    }

    @Test(description = "Авторизация на форме")
    @Parameters({"login", "password"})
    public void loginTest(String login, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLogin(login)
                 .enterPassword(password)
                 .tapButton()
                 .findInf();
    }


    @Test(description = "Ставится отметка")
    public void rememberTest(){
        WebElement rememberTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div[2]/div/label/span/tl-icon"));
        rememberTest.click();
    }

    @Test(description = "Проверка работы кнопки Забыли пароль")
    public void forgotButtonTest(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.forgotButton()
                .logEmailInf();
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
                 .backButton()
                 .inInf();
    }

    @Test(description = "Проверка работы кнопок с языками")
    @Parameters({"language1", "language2", "text"})
    public void languageTest(String language1, String language2, String text){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.languageOne(language1)
                 .languageTwo(language2)
                 .FindLog(text);
    }


    @Test(description = "Проверка работы замены пароля для отрицательных данных")
    @Parameters({"login", "email"})
    public void forgotTest(String login, String email) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotButton()
                 .enterLogin(login)
                 .emailInput(email)
                 .hilButton()
                 .wrongLogEmail();
    }

    @Test(description = "Проверка работы замены пароля для положительных данных")
    @Parameters({"login", "email"})
    public void correctforgotTest(String login, String email) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotButton()
                .enterLogin(login)
                .emailInput(email)
                .hilButton()
                .notEmailOrLogin();

    }


    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}