package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDiscount extends BaseTest {
    String email;
    String password;

    public void login() {
        driver.findElement(By.name("zip_code")).sendKeys("12345");/*Ищем элемент зип код и вводим в это поле значение 12345*/
        driver.findElement(By.cssSelector("input[value='Continue']")).click();/* после ввода зип кода найти элемент континуе и кликнуть по нему*/
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Sudarikov");
        driver.findElement(By.name("email")).sendKeys("fdser@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        email = driver.findElement(By.xpath("//td[text()='Email']/following::b")).getText();
        password = driver.findElement(By.xpath("//td[text()='Password']/following::td")).getText();
        driver.findElement(By.cssSelector("img[src='../images/logo.jpg']")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Login']")).click();
    }

    @Test
    public void discountLessThanTwentyBooks() {
        login();
        driver.get("https://www.sharelane.com/cgi-bin/show_book.py?book_id=1");
        driver.findElement(By.cssSelector("img[src='../images/add_to_cart.gif']")).click();
        driver.findElement(By.cssSelector("img[src='../images/shopping_cart.gif']")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("input[value='Update']")).click();
        String discount = driver.findElement(By.xpath("//td/table/tbody/tr/td/p/b")).getText();
        System.out.println("Скидка на сайте = " + discount);
        System.out.println("Ожидается - 0");
        Assert.assertEquals(discount, "0");
    }

    @Test
    public void discountMoreThanTwentyBooks() {
        login();
        driver.get("https://www.sharelane.com/cgi-bin/show_book.py?book_id=1");
        driver.findElement(By.cssSelector("img[src='../images/add_to_cart.gif']")).click();
        driver.findElement(By.cssSelector("img[src='../images/shopping_cart.gif']")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("input[value='Update']")).click();
        String discount = driver.findElement(By.xpath("//td/table/tbody/tr/td/p/b")).getText();
        System.out.println("Скидка на сайте = " + discount);
        System.out.println("Ожидается - 2");
        Assert.assertEquals(discount, "2");
    }

}
