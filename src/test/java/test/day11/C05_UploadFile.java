package test.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void dosyaUpload(){
        driver.get("https://the-internet.herokuapp.com/upload");
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/logo.png";
        WebElement dosyaSec= driver.findElement(By.xpath("//input[@id='file-upload']"));
        dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        WebElement uploaded= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploaded.isDisplayed());


    }
}
