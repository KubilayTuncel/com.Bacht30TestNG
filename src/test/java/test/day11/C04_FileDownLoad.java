package test.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C04_FileDownLoad extends TestBase {
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
    // - https://the-internet.herokuapp.com/download adresine gidelim.
    // - code.txt dosyasını indirelim
    //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void downLoadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download ");
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        Thread.sleep(5000);
    }
   @Test
    public void isExist(){
        //"/Users/kerimmac/Desktop/logo.png"
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/logo.png";
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void isExistDownload(){
        //"/Users/kerimmac/Downloads/logo.png"
        String dosyaYolu=System.getProperty("user.home")+"/Downloads/logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
