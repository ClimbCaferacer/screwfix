package com.screwfix;

import com.screwfix.data.MainPageData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class MainPageTest {

    public static String MAIN_PAGE_TITLE = "Screwfix.com | The UK’s number 1 trade catalogue | Screwfix Website";

    public WebElement element;
    public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:/develop/screwfix/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("http://www.screwfix.com/");
        Assert.assertEquals(driver.getTitle(), MAIN_PAGE_TITLE);

    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }

    @Test(dataProvider = "main page elements", dataProviderClass = MainPageData.class)
    public void isElementPresent(final String elementName, final String elementId) {
        try {
            this.element = driver.findElement(By.id(elementId.toString()));
            System.out.println("Element '" + elementName + "' found by id: " + elementId.toString());
        } catch (NoSuchElementException e) {
            System.out.println("Element '" + elementName + "' not found by id: " + elementId.toString());
        }
    }

}
