package test.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C03_DependsOn {
    //● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    //    1. Test : Amazon ana sayfaya gittiginizi test edin
    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //    arama yapin ve aramanizin gerceklestigini Test edin
    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //    $16.83 oldugunu test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup (){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1(){
        String expectedUrl="https://www.amazon.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test (dependsOnMethods = "test1")
    public void test2(){
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        WebElement searchBox1= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox1.sendKeys("Nutella"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"),"Aramada Nutella bulunamadi");

    }
    @Test (dependsOnMethods = "test2")
    public void test3(){
        WebElement nutella=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        nutella.click();
        WebElement fiyat= driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        Assert.assertEquals(fiyat.getText(),"$16.83");
    }
}
