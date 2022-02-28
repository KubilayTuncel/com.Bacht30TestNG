package test.day10;

import com.sun.source.doctree.SeeTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String actualBaslik=driver.findElement(By.tagName("h3")).getText();
        String expectedBaslik="Opening a new window";
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualBaslik,expectedBaslik,"yazida bu ifade yer almiyor");
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");
        //window handle ederken ilk adim bir sayfa acik iken o sayfanin handle degerini alip bir string e atamak gerek
        String ilkHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        //2. adim iki sayfa acildiginda her iki sayfanin handle degerlerini koymak icin bir Set olusturup,
        //get window handle metodu ile bu degerleri elde etmemiz gerekir
        Set<String> tumWindowHandleri = driver.getWindowHandles();
        System.out.println("tum handler"+tumWindowHandleri);
        //3. adim set icerisindeki birinci sayfanin handle degerine esit olmayan handle degerini
        //bulup bir string degiskenine atamak
        String ikinciWindowHandle="";
        for (String each:tumWindowHandleri
             ) {
            if (!each.equals(ilkHandle)){
                ikinciWindowHandle=each;
            }
        }
        //bu satira geldigimizde ikinci sayfanin handle degeri var
        System.out.println("ikinci sayfa handle degeri : "+ikinciWindowHandle);
        driver.switchTo().window(ikinciWindowHandle);
        String actualYeniTitle= driver.getTitle();
        String expectedYeniTitle= "New Window";
        softAssert.assertEquals(actualYeniTitle,expectedYeniTitle,"Title istenen degerle eslesmiyor");

        WebElement yeniSayfaYazisiElementi = driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actualYaziYeniSayfa=yeniSayfaYazisiElementi.getText();
        softAssert.assertEquals(actualYaziYeniSayfa,expectedYaziYeniSayfa,"yeni sayfa yazisi beklenenden farkli");

        driver.switchTo().window(ilkHandle);
        actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");

        softAssert.assertAll();

    }
}
