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
    @Parameters({"login", "password"})
    public void CorrectLogTest(String login, String password){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Войти']"));
        loginButton.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div"));
        Assert.assertTrue(alert.isDisplayed(), "Блок квоты Основная онлайн-квота");
    }

    @Test
    public void RememberTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement RememberTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div[2]/div/label/span/tl-icon"));
        RememberTest.click();
    }

    @Test
    public void ForgotButtonTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement ForgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        ForgotButtonTest.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[1]/div/tl-alert"));
        Assert.assertTrue(alert.isDisplayed(), "Алерт о укажите логин и связанный с ним email-адрес. Убедитесь в правильности введенных данных. ");
    }

    @Test
    public void AppStoreTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement AppStoreTest = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]"));
        AppStoreTest.click();
    }

    @Test
    public void GooglePlayTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement AppStoreTest = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]"));
        AppStoreTest.click();
    }

    @Test
    public void BackButtonTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement ForgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        ForgotButtonTest.click();

        WebElement BackButtonTest = driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/div[4]/div[1]/tl-button/button/span[1]/span[2]/span[2]"));
        BackButtonTest.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"login-cont\"]/div"));
        Assert.assertTrue(alert.isDisplayed(), "Вход в личный кабинет ");
    }

    @Test
    public void LanguageTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement LanguageTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        LanguageTest.click();

        WebElement EngButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[2]"));
        EngButtonTest.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Log in']"));
        Assert.assertTrue(alert.isDisplayed(), "Вход в личный кабинет ");

        WebElement Language2Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        Language2Test.click();

        WebElement FrnButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[3]"));
        FrnButtonTest.click();

        WebElement alert2 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Se connecter']"));
        Assert.assertTrue(alert2.isDisplayed(), "Вход в личный кабинет ");

        WebElement Language3Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        Language3Test.click();

        WebElement UkrButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[4]"));
        UkrButtonTest.click();

        WebElement alert3 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Увійти']"));
        Assert.assertTrue(alert3.isDisplayed(), "Вход в личный кабинет ");

        WebElement Language4Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        Language4Test.click();

        WebElement PolButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[5]"));
        PolButtonTest.click();

        WebElement alert4 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Wejdź']"));
        Assert.assertTrue(alert4.isDisplayed(), "Вход в личный кабинет ");

        WebElement Language5Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        Language5Test.click();

        WebElement GruButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[6]"));
        GruButtonTest.click();

        WebElement alert5 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='შესვლა']"));
        Assert.assertTrue(alert5.isDisplayed(), "Вход в личный кабинет ");

        WebElement Language6Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        Language6Test.click();

        WebElement BelButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[7]"));
        BelButtonTest.click();

        WebElement alert6 = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Влизане']"));
        Assert.assertTrue(alert6.isDisplayed(), "Вход в личный кабинет ");
    }


    @Test
    public void ForgotTest() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement ForgotButtonTest = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div[1]/tl-link/a/span[1]/tl-button[2]/button/span[1]/span[2]"));
        ForgotButtonTest.click();



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