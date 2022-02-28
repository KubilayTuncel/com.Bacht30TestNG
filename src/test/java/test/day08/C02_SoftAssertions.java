package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertions {
    // amazon sayfasina gidin
// url'in amazon icerdigini test edin
// title'in amazon icerdigini test edin
// java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
    //testleri soft assertions ile yapin

    WebDriver driver; //test ng olursa staic olmasina gerek yok
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        //soft Assertion da sorgularda hata alsak bile digerlerini calistiriken
        //hard Aseertion da sorgulamanin birinde hata alirsak sonrasindaki sorgulamalar calismaz

        SoftAssert softAssert=new SoftAssert();
        driver.get("https://www.amazon.com");
        softAssert.assertTrue(driver.getCurrentUrl().contains("Amazon"),"Url amazon icermiyor");

        softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon icermiyor");
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        WebElement searchBox1= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox1.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(ilkUrun.getText().contains("Java"), "ilk urun java icermioyor");
        softAssert.assertAll();
        // assertionlar pass olsa da olmasa da assertAll a kadar tum satirlar calisir
        //Eger testlerden bir tanesi bile failed ise assertAll'dan sonra execution stop
    }

    @AfterClass
    public void tearDown(){driver.quit();}
}
