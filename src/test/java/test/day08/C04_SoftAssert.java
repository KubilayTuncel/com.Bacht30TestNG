package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C04_SoftAssert {
    //1.“https://www.hepsiburada.com/” Adresine gidin
    //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3.search kutusuna araba yazip arattirin
    //4.bulunan sonuc sayisini yazdirin
    //5.sonuc yazisinin "araba" icerdigini dogrulayin
    //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){
        driver.get("https://www.hepsiburada.com/");
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle="Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actulaTitle= driver.getTitle();
        softAssert.assertEquals(actulaTitle,expectedTitle,"basliklar uyusmuyor");
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi"));
        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='category-suggestion-title']"));
        System.out.println(sonuc.getText());
        softAssert.assertTrue(sonuc.getText().contains("araba"),"sonuc yazisi araba icermiyor");
        softAssert.assertFalse(sonuc.getText().contains("oto"),"sonuc yazisi oto iceriyor");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){driver.quit();}
}
