package com.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class TestBase {

protected static WebDriver driver;
protected static WebDriverWait wait ;

@BeforeAll
    public static void setupDriver(){
    driver =Driver.getDriver();
    new WebDriverWait(driver, 10);
}

@AfterAll
    public static void tearDown(){
    driver.quit();
}
}
