package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class C01_Alerts {
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult ="You successfully clicked an alert";

        assertEquals(actualResult,expectedResult,"Sonuc yazisi beklenen ile ayni degil");

    }

    @Test
    public void dismissAlert(){
    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    driver.switchTo().alert().dismiss();
    String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
    String expectedResult="successfuly";
    assertFalse(actualResult.contains(expectedResult),"Result yazisi istenmeyen kelimeyi icerir");
    }
    @Test
    public void sendKeysAlert(){
        String isim="Kerim";
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys(isim);
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualResult.contains(isim));
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){driver.quit();
         }
}
