package com.wypok_udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d_rudzki\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://udemy.com");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(), 'Zaloguj się')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"id_email\"]")).sendKeys("damianbeat@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys("Szpadyzornia1058!");
        driver.findElement(By.xpath("//*[@id=\"submit-id-submit\"]")).click();
        Thread.sleep(5000);

        driver.get("https://wykop.pl");
        driver.findElement(By.xpath("//*[@id=\"nav\"]/div/ul[2]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"text1\"]")).sendKeys("damianbeat");
        driver.findElement(By.xpath("//*[@id=\"text2\"]")).sendKeys("Szpadyzornia1058");
        driver.findElement(By.xpath("//*[@id=\"site\"]/div/div[2]/div/div/div/div/form/div/fieldset[2]/input[2]")).click();

        //driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[1]/div[2]/div[4]/div[3]/div/require-auth/div/a")).click();
        driver.get("https://www.wykop.pl/wpis/24997945/kursyudemy-dla-przypomnienia-1-po-zapisaniu-sie-na/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> links = driver.findElements(By.cssSelector("a[href*='udemy.com']"));
        int lenght_list = links.size();
        int i = 0;
        do{
            links = driver.findElements(By.cssSelector("a[href*='udemy.com']"));
            lenght_list = links.size();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            links.get(i).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.switchTo().activeElement();
            Thread.sleep(3000);

            WebElement test;

            if (WebElement test = driver.findElement(By.cssSelector("a[href*='payment']")) != null){
                test.click();
            } else {
                WebElement test2 = driver.findElement(By.xpath("//*[contains(text(), 'Zapisz się teraz')]"));
                test2.click();
            }
            Thread.sleep(3000);
            i++;
            driver.navigate().to("https://www.wykop.pl/wpis/24997945/kursyudemy-dla-przypomnienia-1-po-zapisaniu-sie-na/");
            Thread.sleep(5000);
        } while(lenght_list>=i);

    }
}