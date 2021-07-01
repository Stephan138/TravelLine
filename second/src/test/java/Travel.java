
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Travel {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://bf.qatl.ru/?hotel=7750&date=2021-08-24&nights=4&adults=2");
        Thread.sleep(5000);
    }


    @Test(description = "Ставится отметка")
    public void Test(){

        driver.switchTo().frame(5);
        WebElement room = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344785-rp320222-877958_adult_1___-\"]/div[1]/div[2]/div/div[1]/div[1]/span"));
        room.click();

        WebElement number = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344785-rp320222-877958_adult_1___-\"]/div[1]/div[2]/div/div[2]/div[2]/div[3]/span"));
        number.click();

        WebElement save = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344785-rp320222-877958_adult_1___-\"]/div[2]/span"));
        save.click();

        WebElement soreName = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[1]/div/div/div[2]/div[1]/div[1]/input"));
        soreName.sendKeys("Королев");

        WebElement name = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[1]/div/div/div[2]/div[2]/div[1]/input"));
        name.sendKeys("Степан");

        WebElement names = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[1]/div/div/div[2]/div[3]/div[1]/input"));
        names.sendKeys("Александрович");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[1]/div/div/div[3]/div[1]/div/div[1]/input"));
        email.sendKeys("Stepkorol38@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//*[@id=\"ci-tel\"]"));
        phone.sendKeys("79026641030");

        WebElement secondSoreName = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[2]/div[1]/div[2]/div[2]/div/div/div/div[1]/input"));
        secondSoreName.sendKeys("Иванов");

        WebElement secondName = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[2]/div[1]/div[2]/div[2]/div/div/div/div[2]/input"));
        secondName.sendKeys("Иван");

        WebElement secondNames = driver.findElement(By.xpath("//*[@id=\"contactInformation\"]/section[2]/div[1]/div[2]/div[2]/div/div/div/div[3]/input"));
        secondNames.sendKeys("Иванович");

        WebElement savePay = driver.findElement(By.xpath("//*[@id=\"paymentInformation\"]/div/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span"));
        savePay.click();

        WebElement changeRoom = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[3]/div/p[3]/a"));
        changeRoom.click();

        WebElement changeOneRoom = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section[4]/div[2]/span"));
        changeOneRoom.click();

        WebElement newRoom = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/div/div/section[2]/div[2]/div/div[2]/div/div[2]/span"));
        newRoom.click();

        WebElement doneChanges = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/div/div/section/div[3]/div/span[2]"));
        doneChanges.click();

        WebElement detailsButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/div/div/div[2]/div/span"));
        detailsButton.click();

        WebElement closeBron = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section[2]/div[4]/div/span"));
        closeBron.click();

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[2]/div/div/span/span"));
        continueButton.click();

        WebElement notToGo = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[2]/div/div[1]/div[3]"));
        notToGo.click();

        WebElement closeBronButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[2]/div/div[2]/span/span"));
        closeBronButton.click();

        WebElement deleteInf = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/div/div[2]/div/div/span"));
        deleteInf.click();

        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[1]/div/div[1]/tl-status-modal/div/div[4]/div/span"));
        closeButton.click();
    }

}