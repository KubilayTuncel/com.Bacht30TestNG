package test.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class test2 extends TestBase{
    // 1) "http://automationpractice.com/" ADRESiNE GiDiN
// 2) 2. URUNUN UZERiNE GELiP Add to chart YAPIN
// 3) 4. URUNUN UZERiNE GELiP Add to chart YAPIN
// 4) 5. URUNUN UZERiNE GELiP Add to chart YAPIN
// 5) CHART a gelin 3 ürün olduğunu doğrulayın
// 6) CHART'A GELiP Chek out TIKLAYIN
// 7) toplam alışveriş miktarının 108.97 olduğunu doğrula

    @Test
    public void test2(){

        driver.get("http://automationpractice.com/");
        Actions actions = new Actions(driver);
        WebElement bluse = driver.findElement(By.xpath("(//a[@class='product-name'])[2]"));

        actions.moveToElement(bluse).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();

        WebElement bluse2 = driver.findElement(By.xpath("(//img[@title='Printed Dress'])[2]"));
        actions.moveToElement(bluse2).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[4]")).click();
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();

        WebElement bluse3 = driver.findElement(By.xpath("(//img[@title='Printed Summer Dress'])[1]"));
        actions.moveToElement(bluse3).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[5]")).click();



     }
}
