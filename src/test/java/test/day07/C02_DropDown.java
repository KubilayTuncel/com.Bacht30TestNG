package test.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    //Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    4.Tüm dropdown değerleri(value) yazdırın
    //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select selected= new Select(dropDown);
        selected.selectByIndex(1);
        System.out.println(selected.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        selected.selectByVisibleText("Option 1");
        System.out.println(selected.getFirstSelectedOption().getText());

        selected.selectByIndex(2);
        selected.selectByVisibleText("Option 2");
        System.out.println(selected.getFirstSelectedOption().getText());

        List<WebElement> tumOpsiyonlar = selected.getOptions();
        System.out.println("tum opsiyonlar");
        for (WebElement each:tumOpsiyonlar
             ) {
            System.out.println(each);
        }
        System.out.println(tumOpsiyonlar.size());
        if (tumOpsiyonlar.size()==4){
            System.out.println("true");
        }else{
            System.out.println("False");
        }

    }


    @AfterMethod
    public void tearDown(){ //driver.close();
         }
}
