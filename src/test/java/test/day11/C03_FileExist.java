package test.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist  {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));
        //"/Users/kerimmac/Desktop/picture.jpg"

        //Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin dosya yolunu ikiye ayiracagiz
        //1- herkesin bilgisayarinda farkli olan kisim; bu kismi bilgisardan System.getProperty("user.home") kodu ile alabiliriz
        //2. hekes icin ayni olan kisim; bu ksim 1. maddedeki yolun devami seklinde olur

        //Örnek: masausutundeki picture dosyasi icin yol kaydedelim
        String dosyaYoluManuel="/Users/kerimmac/Desktop/picture.jpg";
        String dosyaYolu=System.getProperty("user.home")+ "/Desktop/picture.jpg";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluManuel)));


    }
}
