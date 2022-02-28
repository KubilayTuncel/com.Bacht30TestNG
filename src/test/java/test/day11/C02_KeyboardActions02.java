package test.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions02 extends TestBase {

    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    //5- videoyu calistirdiginizi test edin

    @Test
    public void test() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();


        WebElement iframe= driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iframe);
        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playTusu.click();
        Thread.sleep(3000);
        Assert.assertFalse(playTusu.isDisplayed());
    }
}
