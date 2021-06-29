import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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


    @Test(description = "Авторизация на форме")
    @Parameters({"login", "password"})
    public void loginTest(String login, String password) {

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Войти']"));
        loginButton.click();

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

        WebElement forgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        forgotButtonTest.click();

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

        WebElement forgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        forgotButtonTest.click();

        WebElement backButtonTest = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[1]/tl-button/button/span[1]/span[2]/span[2]"));
        backButtonTest.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"login-cont\"]/div"));
        Assert.assertTrue(alert.isDisplayed(), "Вход в личный кабинет ");
    }

    @Test(description = "Проверка работы кнопок с языками")

    public void languageTest(){


        WebElement languageTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        languageTest.click();

        WebElement engButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[2]"));
        engButtonTest.click();

        WebElement button = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Log in']"));
        Assert.assertTrue(button.isDisplayed(), "Вход в личный кабинет ");

        WebElement language2Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        language2Test.click();

        WebElement frnButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[3]"));
        frnButtonTest.click();

        WebElement button2 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Se connecter']"));
        Assert.assertTrue(button2.isDisplayed(), "Вход в личный кабинет ");

        WebElement language3Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        language3Test.click();

        WebElement ukrButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[4]"));
        ukrButtonTest.click();

        WebElement button3 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Увійти']"));
        Assert.assertTrue(button3.isDisplayed(), "Вход в личный кабинет ");

        WebElement language4Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        language4Test.click();

        WebElement polButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[5]"));
        polButtonTest.click();

        WebElement button4 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Wejdź']"));
        Assert.assertTrue(button4.isDisplayed(), "Вход в личный кабинет ");

        WebElement language5Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        language5Test.click();

        WebElement gruButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[6]"));
        gruButtonTest.click();

        WebElement button5 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='შესვლა']"));
        Assert.assertTrue(button5.isDisplayed(), "Вход в личный кабинет ");

        WebElement language6Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        language6Test.click();

        WebElement belButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[7]"));
        belButtonTest.click();

        WebElement button6 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Влизане']"));
        Assert.assertTrue(button6.isDisplayed(), "Вход в личный кабинет ");
    }


    @Test(description = "Проверка работы замены пароля для отрицательных данных")
    @Parameters({"login", "email"})
    public void forgotTest(String login, String email) {

        WebElement forgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        forgotButtonTest.click();

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.name("email"));
        passwordInput.sendKeys(email);

        WebElement hilButton = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[2]/tl-button/button/span[1]/span[2]"));
        hilButton.click();

        WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или Email.']"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или Email не отобразился");
    }

    @Test(description = "Проверка работы замены пароля для положительных данных")
    @Parameters({"login", "email"})
    public void correctforgotTest(String login, String email) {

        WebElement forgotButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        forgotButton.click();

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);

        WebElement hilButton = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[2]/tl-button/button/span[1]/span[2]"));
        hilButton.click();

        WebElement alert = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div/span/span[1]/span"));
        Assert.assertTrue(alert.isDisplayed(), "О правельном вводе логина или Email не отобразился");
    }


    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}