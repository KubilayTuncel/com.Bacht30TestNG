package test.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DataProviderTest extends TestBase {
    @DataProvider
    public static Object[] AramaYapma() {
        String arr[]={"Mac","ipod","samsung"};
        return  arr;
    }
    // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
// login yapiniz Email: asd@gmail.com   password : 123qweasd
// Search fonksiyonunu kullanarak
// Mac,ipod ve samsung icin Dataprovider ile yapınız.

    @Test (dataProvider = "AramaYapma")
    public void test(String aranacaklar){

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement userName= driver.findElement(By.xpath("//input[@name='email']"));
        userName.sendKeys("asd@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123qweasd");

    }
}
