package com.libraryCt;

import com.github.javafaker.Faker;
import com.utility.BrowserUtil;
import com.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.utility.Login.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory5 extends TestBase {


    @Test
    public void LibrarianSelectUserGroups() {
        getPage();
        login("librarian43@library", "Sdet2022*");
BrowserUtil.waitFor(3);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Users']")));
        WebElement usersBtn = driver.findElement(By.xpath("//li[@class='nav-item'][2]"));
        usersBtn.click();
        BrowserUtil.waitFor(2);
        WebElement userGroups = driver.findElement(By.id("user_groups"));
        Select select = new Select(userGroups);
        select.selectByIndex(1);
        BrowserUtil.waitFor(2);
        select.selectByValue("3");
        BrowserUtil.waitFor(2);
        select.selectByVisibleText("ALL");
        BrowserUtil.waitFor(2);

    }
    /*Given librarian is on the homePage
When librarian click Users module
And librarian click user group dropdown
Then verify librarian have 3 options

 */

    @Test
    public void checkUserStatus() {

        WebElement userStatus = driver.findElement(By.xpath("//select[@id='user_status']"));
        Select checkStatus = new Select(userStatus);
        checkStatus.selectByVisibleText("INACTIVE");
        BrowserUtil.waitFor(2);
        checkStatus.selectByIndex(0);

    }


/*
Given librarian is on the homePage
When librarian click Users module
And librarian click Status dropdown
Then verify there are 2 status options
 */

    @Test
    public void filterBookCategories(){
        WebElement goDashboard = driver.findElement(By.xpath("//li[@class='nav-item'][1]"));
        goDashboard.click();
        BrowserUtil.waitFor(2);

        WebElement books = driver.findElement(By.xpath("//li[@class='nav-item'][3]"));
        books.click();
        BrowserUtil.waitFor(2);

        WebElement categories = driver.findElement(By.xpath("//select[@id='book_categories']"));
        Select checkCategories = new Select(categories);
        List<WebElement> check = checkCategories.getOptions();
        System.out.println("check.size() = " + check.size());
        assertTrue(check.size()==21);

        checkCategories.selectByVisibleText("Drama");
      BrowserUtil.waitFor(2);
        System.out.println("categories.getText() = " + categories.getText());

    }
    /*
    As a user, I want to filter book categories.
      AC #1:
      Given user is on the homePage
      When user click Books module
      And user click book category dropdown
      Then verify there are 21 options
      AC #2:
      Given user is on the homePage
      When user click Books module
      And user click book category dropdown
      Then verify user is able to selected the “Drama” option

     */

}