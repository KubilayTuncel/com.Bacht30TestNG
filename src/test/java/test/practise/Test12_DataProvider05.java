package test.practise;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test12_DataProvider05 extends TestBase {

    @DataProvider
    public static Object[][] sigInTest() {

        Object gmibankData [][] = {
                {"username1@gmail.com","passwqord1"},
                {"username2@gmail.com","passwqord2"},
                {"username3@gmail.com","passwqord3"}
        };
        return gmibankData;
    }

    @Test (dataProvider = "sigInTest")
    public void test(String username, String password){


        driver.findElement(By.xpath("//li[@id='account-menu']")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys();
        driver.findElement(By.id("password")).sendKeys();
        driver.findElement(By.xpath("(//span[text()='Sign in'])[2]")).click();


    }
}
