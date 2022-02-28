package test.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeybordActions extends TestBase {
    // https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(driver);
        actions.click(searchBox).perform();
        actions.sendKeys("Samsung ").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("a").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();
        /*
        actions.click(searchBox).
                sendKeys("Samsung").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();

         */
        String arananKelime="Samsung A71";
        String actuaalTitle=driver.getTitle();
        System.out.println(actuaalTitle);
        Assert.assertTrue(actuaalTitle.contains(arananKelime),"arama yapilamadi");

    }

}
