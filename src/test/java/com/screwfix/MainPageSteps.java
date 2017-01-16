package com.screwfix;

import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/resources/cucumber/feature/MainPageFeature.feature"
)
public class MainPageSteps {
    public static String MAIN_PAGE_TITLE = "Screwfix.com | The UK’s number 1 trade catalogue | Screwfix Website";

    public WebElement element;
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:/develop/screwfix/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("http://www.screwfix.com/");
    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Given("^User on Screwfix main page$")
    public void openScrewfixPage() {
        Assert.assertEquals(driver.getTitle(), MAIN_PAGE_TITLE);
    }



    //    @Test(dataProvider = "main page elements", dataProviderClass = MainPageData.class)
    @Then("^Element ([^\"]*) found by css selector ([^\"]*)$")
//    @Then("^Element found by css selector$")
    public void isElementPresent(final String elementName, final String elementId) {
        try {
            this.element = driver.findElement(By.cssSelector(elementId.toString()));
            System.out.println("Element '" + elementName + "' found by css selector: " + elementId.toString());
        } catch (NoSuchElementException e) {
            Assert.fail("Element '" + elementName + "' not found by css selector: " + elementId.toString());
        }
    }

}
