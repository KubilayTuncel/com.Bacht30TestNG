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

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {
    // amazon sayfasina gidin
// url'in amazon icerdigini test edin
// title'in amazon icerdigini test edin
// java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin

    static WebDriver driver; //test ng olursa staic olmasina gerek yok
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        Assert.assertTrue(driver.getCurrentUrl().contains("Amazon"),"Url amazon icermiyor");

        WebElement searchBox1= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox1.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(ilkUrun.getText().contains("Java"));
    }

    @AfterClass
    public static void tearDown(){driver.quit();}
}
