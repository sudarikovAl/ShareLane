package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpCheckFieldsTest extends BaseTest {
    @Test
    public void CheckInputField() {

        /*Тест на наличие полей ввода  First Name, Last Name, Email, Password, Confirm Password и на регистрацию при валидных значениях*/
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");/* Переходим на SignUp page*/
        assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "Отсутствует Элемент first_name ");
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        assertTrue(driver.findElement(By.name("last_name")).isDisplayed(), "Отсутствует Элемент last_name ");
        driver.findElement(By.name("last_name")).sendKeys("Sudarikov");
        assertTrue(driver.findElement(By.name("email")).isDisplayed(), "Отсутствует Элемент email ");
        driver.findElement(By.name("email")).sendKeys("fdser@gmail.com");
        assertTrue(driver.findElement(By.name("password1")).isDisplayed(), "Отсутствует Элемент Password ");
        driver.findElement(By.name("password1")).sendKeys("1111");
        assertTrue(driver.findElement(By.name("password2")).isDisplayed(), "Отсутствует Элемент Confirm Password ");
        driver.findElement(By.name("password2")).sendKeys("1111");
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        assertTrue(registerButton.isDisplayed(), "Отсутствует Элемент ");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        assertTrue(driver.findElement(By.cssSelector("span[class='confirmation_message']")).isDisplayed(), "перепиши тест");

        //Тест на невалидные данные в поле First Name(набор символов)

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "Отсутствует Элемент first_name ");
        driver.findElement(By.name("first_name")).sendKeys("!@#$%$#@@");
        assertTrue(driver.findElement(By.name("last_name")).isDisplayed(), "Отсутствует Элемент last_name ");
        driver.findElement(By.name("last_name")).sendKeys("Sudarikov");
        assertTrue(driver.findElement(By.name("email")).isDisplayed(), "Отсутствует Элемент email ");
        driver.findElement(By.name("email")).sendKeys("fdser@gmail.com");
        assertTrue(driver.findElement(By.name("password1")).isDisplayed(), "Отсутствует Элемент Password ");
        driver.findElement(By.name("password1")).sendKeys("1111");
        assertTrue(driver.findElement(By.name("password2")).isDisplayed(), "Отсутствует Элемент Confirm Password ");
        driver.findElement(By.name("password2")).sendKeys("1111");
        registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        assertTrue(registerButton.isDisplayed(), "Отсутствует Элемент ");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        assertTrue(driver.findElement(By.cssSelector("span[class='error_message']")).isDisplayed(), "перепиши тест");

        //Тест на невалидные данные в поле Email(ввести емэйл без точки)

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "Отсутствует Элемент first_name ");
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        assertTrue(driver.findElement(By.name("last_name")).isDisplayed(), "Отсутствует Элемент last_name ");
        driver.findElement(By.name("last_name")).sendKeys("");
        assertTrue(driver.findElement(By.name("email")).isDisplayed(), "Отсутствует Элемент email ");
        driver.findElement(By.name("email")).sendKeys("fdser@gmailcom");
        assertTrue(driver.findElement(By.name("password1")).isDisplayed(), "Отсутствует Элемент Password ");
        driver.findElement(By.name("password1")).sendKeys("1111");
        assertTrue(driver.findElement(By.name("password2")).isDisplayed(), "Отсутствует Элемент Confirm Password ");
        driver.findElement(By.name("password2")).sendKeys("1111");
        registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        assertTrue(registerButton.isDisplayed(), "Отсутствует Элемент ");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        assertTrue(driver.findElement(By.cssSelector("span[class='error_message']")).isDisplayed(), "перепиши тест");

        //Тест на невалидные данные в поле Password(оставить его пустым)

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "Отсутствует Элемент first_name ");
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        assertTrue(driver.findElement(By.name("last_name")).isDisplayed(), "Отсутствует Элемент last_name ");
        driver.findElement(By.name("last_name")).sendKeys("");
        assertTrue(driver.findElement(By.name("email")).isDisplayed(), "Отсутствует Элемент email ");
        driver.findElement(By.name("email")).sendKeys("fdser@gmail.com");
        assertTrue(driver.findElement(By.name("password1")).isDisplayed(), "Отсутствует Элемент Password ");
        driver.findElement(By.name("password1")).sendKeys("");
        assertTrue(driver.findElement(By.name("password2")).isDisplayed(), "Отсутствует Элемент Confirm Password ");
        driver.findElement(By.name("password2")).sendKeys("1111");
        registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        assertTrue(registerButton.isDisplayed(), "Отсутствует Элемент ");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        assertTrue(driver.findElement(By.cssSelector("span[class='error_message']")).isDisplayed(), "перепиши тест");

        //Тест на невалидные данные в поле Confirm Password(оставить его пустым)

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "Отсутствует Элемент first_name ");
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        assertTrue(driver.findElement(By.name("last_name")).isDisplayed(), "Отсутствует Элемент last_name ");
        driver.findElement(By.name("last_name")).sendKeys("");
        assertTrue(driver.findElement(By.name("email")).isDisplayed(), "Отсутствует Элемент email ");
        driver.findElement(By.name("email")).sendKeys("fdser@gmailcom");
        assertTrue(driver.findElement(By.name("password1")).isDisplayed(), "Отсутствует Элемент Password ");
        driver.findElement(By.name("password1")).sendKeys("1111");
        assertTrue(driver.findElement(By.name("password2")).isDisplayed(), "Отсутствует Элемент Confirm Password ");
        driver.findElement(By.name("password2")).sendKeys("");
        registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        assertTrue(registerButton.isDisplayed(), "Отсутствует Элемент ");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        assertTrue(driver.findElement(By.cssSelector("span[class='error_message']")).isDisplayed(), "перепиши тест");



    }


}
