package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IframeTest {
    // https://the-internet.herokuapp.com/iframe adresine gidin.
    //  ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
    // ○ Text Box’a “Merhaba Dunya!” yazin.
    // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

    // Her Allert JS Allert degildir
// Allert ciktiginda sag click yapip incele diyebiliyorsak bu bir HTML alert'dir
// HTML alert'ler siradan webelement'ler olarak locate edilip kullanilabilir
// Sag click yapamiyorsak alert bir JS Allert'dur ve switchTo() kullanilarak handle edilebilir
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void test1(){
        WebElement baslikYazisi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYazisi.isEnabled(),"baslik yazisi erisilebilir degil");
        System.out.println(baslikYazisi.getText());

        driver.switchTo().frame("mce_0_ifr");
        WebElement yaziKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutusu.clear();
        yaziKutusu.sendKeys("Merhaba Dunya");
        //Eger bir test de iframe ile baska bir sayfaya gidersek geri donmek icin tekrardan driver uzerinden
        //calisma sayfasina donmemiz gerekiyor. Ve asagidaki kod ile bir ustteki frame geri dönus yapabilioyruz
        //ama ana sayfaya gecmek istiyorsak driver.swichTo().defaultContent(); ile gecebiliriz.
        driver.switchTo().parentFrame();
        WebElement seleniumYazisi= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(seleniumYazisi.isDisplayed(),"selenium linki mevcut degil");
        System.out.println(seleniumYazisi.getText());
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){driver.quit();}
}
