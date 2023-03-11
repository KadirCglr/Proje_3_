package Proje2;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Target;
import java.time.Duration;
import java.util.concurrent.Callable;

public class Proje extends BaseDriver {

    @Test
    public void Case1()
    {

        driver.get(" https://shopdemo.e-junkie.com/ ");

        WebElement Ebook = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        Ebook.click();

        MyFunc.Bekle(2);
        driver.switchTo().frame(5);

        MyFunc.Bekle(2);
        WebElement addPromaCode = driver.findElement(By.xpath("//*[@class='Apply-Button Show-Promo-Code-Button']"));
        addPromaCode.click();

        MyFunc.Bekle(2);
        WebElement promoCode = driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        promoCode.sendKeys("123456");

        MyFunc.Bekle(2);
        WebElement apply = driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        apply.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement mesaj= wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//span[text()='Invalid promo code']")));

        Assert.assertTrue(mesaj.isDisplayed());

        MyFunc.Bekle(2);
        driver.switchTo().defaultContent();

    }

    @Test
    public void Case2()
    {

        driver.get(" https://shopdemo.e-junkie.com/ ");

        WebElement Ebook = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        Ebook.click();

        MyFunc.Bekle(2);
        driver.switchTo().frame(5);

        WebElement usingDebit = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        usingDebit.click();

        MyFunc.Bekle(4);
        WebElement payButton = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement mesaj2= wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='SnackBar']/span")));
        Assert.assertTrue(mesaj2.isDisplayed());
    }

    @Test
    public void Case3()
    {

        driver.get(" https://shopdemo.e-junkie.com/ ");

        WebElement Ebook = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        Ebook.click();

        MyFunc.Bekle(1);
        driver.switchTo().frame(5);

        MyFunc.Bekle(1);
        WebElement usingDebit = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        usingDebit.click();

        MyFunc.Bekle(2);
        driver.switchTo().frame(2);

        MyFunc.Bekle(1);
        WebElement kartNo = driver.findElement(By.xpath("//input[@class='InputElement is-empty Input Input--empty']"));
        kartNo.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement mesaj3= wait.until(ExpectedConditions.
            visibilityOfElementLocated(By.xpath("//div[@id='SnackBar']/span")));

        String ms="Kart numaranız geçersiz";

        if (ms.equals("Kart numaranız geçersiz"))
            System.out.println(ms);
        else
            System.out.println("Gecerli kart giriniz");

        MyFunc.Bekle(2);

    }

    @Test
    public void Case4()
    {

        driver.get(" https://shopdemo.e-junkie.com/ ");

        WebElement Ebook = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        Ebook.click();

        MyFunc.Bekle(1);
        driver.switchTo().frame(5);

        MyFunc.Bekle(1);
        WebElement usingDebit = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        usingDebit.click();

        MyFunc.Bekle(2);
        WebElement Email = driver.findElement(By.xpath("//input[@placeholder='Email']"));

        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.moveToElement(Email)  // kutucuğa gel

                .click()                 // içine tıklat
                .sendKeys("Kcaglar@gmail")
                .sendKeys(Keys.TAB)
                .sendKeys("Kcaglar@gmail")     // shift e bas
                .sendKeys(Keys.TAB)
                .sendKeys("kadir caglar")
                .sendKeys(Keys.TAB)
                .sendKeys("04545214585")
                .sendKeys(Keys.TAB)
                .sendKeys("Techno")
                .sendKeys(Keys.TAB)
                .build();

        aksiyon.perform();
        MyFunc.Bekle(2);
        aksiyon=aksiyonlar
                .sendKeys("4242 4242 4242 4242")
                .sendKeys("12")
                .sendKeys("23")
                .build();

        aksiyon.perform();
        MyFunc.Bekle(2);
        aksiyon=aksiyonlar
                .sendKeys("000")
                        .build();

        MyFunc.Bekle(2);
        aksiyon.perform(); // gerçekleştirildi.

        MyFunc.Bekle(1);
        WebElement Pay = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        Pay.click();

        WebElement dogrulama2 = driver.findElement(By.xpath("//*[text()='kadir, your order is confirmed. Thank you!']"));
        Assert.assertTrue(dogrulama2.getText().contains("kadir, your order is confirmed. Thank you!"));

    }

    @Test
    public void Case5()
    {
        driver.get(" https://shopdemo.e-junkie.com/ ");

        MyFunc.Bekle(1);
        WebElement ContactUs = driver.findElement(By.xpath("//*[text()=' Contact Us']"));
        ContactUs.click();

        MyFunc.Bekle(1);
        WebElement Name = driver.findElement(By.xpath("//*[@id='sender_name']"));
        Name.sendKeys("Kadir");

        MyFunc.Bekle(1);
        WebElement eMail = driver.findElement(By.xpath("//*[@id='sender_email']"));
        eMail.sendKeys("Kcaglar@gmail");

        MyFunc.Bekle(1);
        WebElement subject = driver.findElement(By.xpath("//*[@id='sender_subject']"));
        subject.sendKeys("Testing");

        MyFunc.Bekle(1);
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='sender_message']"));
        mesaj.sendKeys("Test bitmek üzere");

        MyFunc.Bekle(1);
        WebElement SendButton = driver.findElement(By.xpath("//*[@id='send_message_button']"));
        SendButton.click();

        MyFunc.Bekle(2);
        driver.switchTo().alert().accept();

        BekleKapat();

    }
        }

