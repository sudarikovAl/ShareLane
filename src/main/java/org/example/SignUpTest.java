package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest {

    /*
    1. Open browser
    2. go to https://www.sharelane.com/cgi-bin/register.py
    3. input numbers 12345
    4. Press "Continue button"
     */

    @Test
    public void ZipCodeShouldntBeValid() {

        /*Тест на ошибку при пустом поле ввода*/
        driver.findElement(By.name("zip_code")).sendKeys("");/*Ищем элемент зип код и вводим в это поле пустое значение*/
        driver.findElement(By.cssSelector("input[value='Continue']")).click();/* после ввода зип кода найти элемент континуе и кликнуть по нему*/
        /*проверка что невалидное значение привело к ожидаемой ошибке*/
        assertTrue(driver.findElement(By.cssSelector("span[class='error_message']")).isDisplayed(), "Зип код почему-то принял пустое значение");/* после клика по continue проверяем что отобразилось сообщение error message*/
    }
    @Test
            public void ZipCodeShouldBeValid() {
        /*Второй тест на валидное значение 12345 в поле зип код*/
        driver.findElement(By.name("zip_code")).sendKeys("12345");/*Ищем элемент зип код и вводим в это поле значение 12345*/
        driver.findElement(By.cssSelector("input[value='Continue']")).click();/* после ввода зип кода найти элемент континуе и кликнуть по нему*/
        /*проверка что валидное значение принято*/
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));/*На след странице объявить переменную регистербаттон и найти ее на странице*/
        assertTrue(registerButton.isDisplayed(), "Зип код не валиден");/*Убедиться что элемент регистербаттон существует и если нет то вывести сообщение юзеру*/
    }
    @Test
            public void ZipCodeXSSInjection(){
        /*Тест на ошибку при xss инъекции*/
        driver.findElement(By.name("zip_code")).sendKeys("<script>alert('XSS');</script>");/*Ищем элемент зип код и вводим в это поле инъекцию*/
        driver.findElement(By.cssSelector("input[value='Continue']")).click();/* после ввода зип кода найти элемент континуе и кликнуть по нему*/
        /*проверка что невалидное значение привело к ожидаемой ошибке*/
        assertTrue(driver.findElement(By.cssSelector("span[class='error_message']")).isDisplayed(), "XSS инъекция была принята");/* после клика по continue проверяем что отобразилось сообщение error message*/

    }
}
