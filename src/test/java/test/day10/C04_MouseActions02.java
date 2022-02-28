package test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C04_MouseActions02 extends TestBase {
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test(){
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement dragElementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropAlani = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElementi,dropAlani).perform();
        String actualDropYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expectedDropYazisi ="Dropped!";
        Assert.assertEquals(actualDropYazisi,expectedDropYazisi,"Drop alanindaki yazi eslesmiyor");
    }
}
