package test.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {
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
        driver.findElement(By.linkText("Click Here")).click();
        
        String actualYeniTitle= driver.getTitle();
        String expectedYeniTitle= "New Window";
        softAssert.assertEquals(actualYeniTitle,expectedYeniTitle,"Title istenen degerle eslesmiyor");

        softAssert.assertAll();

    }
}
