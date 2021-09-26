package com.utility;

import com.utility.Driver;
import com.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Login  {
static WebDriver driver = Driver.getDriver();

public static void login(){

    ArrayList<String> userNames = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));
    for (String name : userNames) {

        driver.findElement(By.id("inputEmail")).sendKeys(name);
        //password
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");
        //And librarian click sign in button
        driver.findElement(By.cssSelector("#login-form > button")).click();
    }
}
    public static void login( String username, String password){


            driver.findElement(By.id("inputEmail")).sendKeys(username);
            //password
            driver.findElement(By.id("inputPassword")).sendKeys(password);
            //And librarian click sign in button
            driver.findElement(By.cssSelector("#login-form > button")).click();

    }

    public static void getPage(){
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    public static void logout(){
        driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();

    }


}
