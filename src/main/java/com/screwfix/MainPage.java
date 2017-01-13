package com.screwfix;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class MainPage {

    public static String MAIN_PAGE_TITLE = "Screwfix.com";

    public WebElement element;

    @FindBy(id = "search_submit_button")
    private Button searchButton;

    @FindBy(id = "header_link_sign_in")
    private WebElement signInLink;

    @FindBy(id = "branding-logo")
    private WebElement homePageLink;

    @FindBy(id = "firstLevelCat_0")
    private WebElement toolsCategory;

    public void setElement(final WebElement element) {
        this.element = element;
    }

    public boolean isElementPresent(final WebElement element) {
        this.element = element;
        return element.isDisplayed();
    }


}
