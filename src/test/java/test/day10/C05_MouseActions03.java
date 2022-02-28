package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions03 extends TestBase {

    //1- https://www.amazon.com/ adresine gidelim
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
    //3- “Create a list” butonuna basalim
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='nav-line-2 ']"))).perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.xpath("//span[text()='Create a List']"))).perform();

        String actualBaslik = driver.findElement(By.xpath("//div[@aria-level='1']")).getText();
        String expectedBaslik = "Your Lists";
        Assert.assertEquals(actualBaslik,expectedBaslik,"Your List yazisina ulasamiyor");
    }
}
