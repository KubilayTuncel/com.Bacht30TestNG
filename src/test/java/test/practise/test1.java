package test.practise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class test1 extends TestBase {

    // "http://automationpractice.com/" ADRESiNE GiDiP UYE OL.
    @Test
    public void test1(){
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("(//a[@class='login'])")).click();
        Faker faker = new Faker();
        WebElement email= driver.findElement(By.xpath("//input[@name='email_create']"));
        Actions actions = new Actions(driver);
        actions.click(email).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.cssSelector("#id_gender1")).click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
                .sendKeys(Keys.TAB)
                .sendKeys("May").sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1950,2003))).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().country()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.ENTER).perform();


    }
}
