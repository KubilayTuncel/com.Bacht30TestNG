package test.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class C02_Faker extends TestBase {
    //1. "https://facebook.com" Adresine gidin
    //2. “create new account” butonuna basin
    //3. “firstName” giris kutusuna bir isim yazin
    //4. “surname” giris kutusuna bir soyisim yazin
    //5. “email” giris kutusuna bir email yazin
    //6. “email” onay kutusuna emaili tekrar yazin
    //7. Bir sifre girin
    //8. Tarih icin gun secin
    //9. Tarih icin ay secin
    //10. Tarih icin yil secin
    //11. Cinsiyeti secin
    //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini
    //test edin.
    //13. Sayfayi kapatin

    @Test
    public void test(){
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement nameKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        String fakerEmail=faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        actions.click(nameKutusu).sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(fakerEmail).sendKeys(Keys.TAB).sendKeys(fakerEmail)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31))).sendKeys(Keys.TAB).sendKeys("May")
                .sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1955,2000))).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
