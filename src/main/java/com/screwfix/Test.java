package com.screwfix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import fit.ColumnFixture;

public class Test extends ColumnFixture{

    public static String MAIN_PAGE_TITLE = "Screwfix.com";

    public String element;
    public WebDriver driver;

    public void setElement(final String element) {
        System.setProperty("webdriver.chrome.driver","D:/develop/screwfix/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.screwfix.com/");
        this.element = element;
    }

    public boolean isElementPresent() {
        return driver.findElement(By.id(element)).isDisplayed();
    }

    public static void main(String[] args) {
/*        System.setProperty("webdriver.chrome.driver","D:/develop/screwfix/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.screwfix.com/");
*/
    }
}
