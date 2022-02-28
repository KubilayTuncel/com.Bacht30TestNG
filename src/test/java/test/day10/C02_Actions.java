package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[9]")).click();
    }
}
