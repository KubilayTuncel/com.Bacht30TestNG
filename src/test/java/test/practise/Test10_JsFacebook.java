package test.practise;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test10_JsFacebook extends TestBase {

    @Test
    public void setUp() throws InterruptedException {
        driver.get("https://www.facebook.com");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementById('email').value='deneme@abc.com';");
        js.executeScript("document.getElementById('pass').value='123465';");
        //value locate edilen yere deger gönderir. sendKeys islemini yapar
        //sayfada document kismini incele bölümündeki console kismina document ile baslayarak yaparsak elemente ulasabiliyoruz

        Thread.sleep(3000);


    }
}
