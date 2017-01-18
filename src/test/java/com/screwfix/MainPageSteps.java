package com.screwfix;

import com.screwfix.data.ContactInfoDataProvider;
import com.screwfix.objects.RegistrationPage;
import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/resources/cucumber/feature/MainPageFeature.feature"
)
public class MainPageSteps {
    public static String MAIN_PAGE_TITLE = "Screwfix.com | The UK’s number 1 trade catalogue | Screwfix Website";

    public static String SEARCH_FIELD = "#mainSearch-input";

   public static String SINGIN_PAGE_TITLE = "Sign In | Screwfix";

    public WebElement element;
    public WebDriver driver;
    public String productCode;
    public Map<String,String> registrationTable;
    public ContactInfoDataProvider contactInfo = new ContactInfoDataProvider().setContactInfo();
    RegistrationPage registrationPage;
//    public WebDriverWait wait = new WebDriverWait(driver, 500L);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:/develop/screwfix/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("http://www.screwfix.com/");
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
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

    @When("^User search for \"([^\"]*)\"$")
    public void search(final String searchItem){
        WebElement searchField = driver.findElement(By.cssSelector(SEARCH_FIELD));
        searchField.clear();
        searchField.sendKeys(searchItem);
        driver.findElement(By.cssSelector("#search_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^\"([^\"]*)\" found in product table$")
    public void isProductPresentInProductTable(final String productItem) {
        try {
            this.productCode = driver.findElement(By
                    .cssSelector("a[id*='product_description'][title = '" + productItem + "']"))
                    .getAttribute("descriptionproductid");
            System.out.println("ProductCode: "+ productCode);
        }catch (NoSuchElementException e){
            Assert.fail("Product '" + productItem + "' not found");
        }
    }

    @Then("^\"([^\"]*)\" found by product code$")
    public void isProductPresentByProductCode(final String productItem) {
        try {
           Assert.assertTrue("Product not find by product code",
                   driver.findElement(By.cssSelector("#product_description>span"))
                           .getText()
                           .equals(productItem));
        }catch (NoSuchElementException e) {
        Assert.fail("Product '" + productItem + "' not found");
        }
    }


    @When("^User click on \"([^\"]*)\" button$")
    public void clickOnButtonByProductCode(final String button) {
        if(productCode!=null) {
            switch (button) {
                case "Deliver":
                    try {
                        driver.findElement(By.cssSelector("#product_add_button_" + productCode + ", #product_add_to_trolley_image")).click();
                    }catch(NoSuchElementException e) {
                        Assert.fail("Button '" + button + "' not found");
                    }
                    break;
            }
        } else {
            Assert.fail("ProductCode is " + productCode);
        }
    }

    @Then("^\"([^\"]*)\" added to basket for delivery$")
    public void tpi_K_Type_Digital_Thermometer_added_to_basket_for_delivery(final String descriptionPopUp) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue("PopUp is not displayed", driver.findElement(By.cssSelector(".wrp.wrp__modal.atb__top")).isDisplayed());
    }


    @Then("^Click on \"([^\"]*)\" button$")
    public void click_on_button(final String buttonName) {
        switch (buttonName) {
            case "Continue shopping":
                driver.findElement(By.cssSelector("#continue_button > a")).click();
                break;
            case "Checkout now":
                driver.findElement(By.cssSelector("#checkout_now > a")).click();
                break;
            case "Continue payment":
                driver.findElement(By.cssSelector("#topCheckoutButton")).click();
                break;
            case "Register now":
                driver.findElement(By.cssSelector(".btn.btn--primary.fill.btn--xl.id-register-button")).click();
                break;
            case "Continue":
                driver.findElement(By.cssSelector("#continueRegistrationButton")).click();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                break;
            default:
                Assert.fail("Button '"+ buttonName + "' not found");
        }
    }

    @When("^User on the trolley page with (\\d+) items in it$")
    public void onTrolleyWithItems(final String itemsCount) {
        driver.getCurrentUrl().contains("/trolleyPage.jsp");
        driver.findElement(By.cssSelector(".icon-qty")).getText().equals(itemsCount);
    }

    @When("^User on sign in page$")
    public void userOnSignInPage() {
        driver.getTitle().equals(SINGIN_PAGE_TITLE);
    }

    @When("^User on registration page$")
    public void userOnRegistrationPage() {
        driver.getCurrentUrl().contains("/registration");
    }

    @Then("^User enter email$")
    public void user_enter_email() {
        System.out.println(contactInfo.email);
        driver.findElement(By.cssSelector("#email-input")).sendKeys(contactInfo.email);
    }

 /*   public boolean isRegistrationPageLoaded() {
        driver.findElement(By.cssSelector("#registrationFormHeadText"));
    }
*/
    @When("^User on registration page after adding email$")
    public void user_on_registration_page_after_adding_email() {

        Assert.assertTrue("Not on registration page!", driver.getCurrentUrl().contains("/registration"));
        Assert.assertTrue("Not on registration form!", registrationPage.isRegistrationPageDisplayed());
    }

    @Then("^User fills registration info$")
    public void fillRegistrationInfo(Map<String,String> table){
        Assert.assertTrue("NOT DISPLAYED", registrationPage.isRegistrationPageDisplayed());
        this.registrationTable = table;
        System.out.println(contactInfo.lastName);
        System.out.println(contactInfo.firstName);

        if(!"ANY".equals(registrationTable.get("LastName"))) {
            contactInfo.lastName = registrationTable.get("LastName");
        }
        if(!"ANY".equals(registrationTable.get("FirstName"))) {
            contactInfo.firstName = registrationTable.get("FirstName");
        }

        System.out.println(contactInfo.lastName);
        System.out.println(contactInfo.firstName);

        registrationPage.fillRegistrationInfo(registrationTable.get("Title"),
                contactInfo.firstName, contactInfo.lastName,
                registrationTable.get("Profession"),
                registrationTable.get("PostalCode"),
                registrationTable.get("Address"),
                registrationTable.get("Password"));

    }

}
