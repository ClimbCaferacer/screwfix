package com.screwfix.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class RegistrationPage {


    @FindBy(css = "#registrationFormHeadText")
    private WebElement registrationFormHeadText;

    @FindBy(css = "#newTitle")
    private WebElement titleDropdown;

    @FindBy(css = "#firstName")
    private WebElement firstNameField;

    @FindBy(css = "#lastName")
    private WebElement lastNameField;

    @FindBy(css = "#profession")
    private WebElement professionDropdown;

    @FindBy(css = "#contact-search-postcode")
    private WebElement postCode;

    @FindBy(css = ".btn.fill.btn--lg.id-find-address-button")
    private WebElement findAddressButton;

    @FindBy(css = "#contact-address-result-select")
    private WebElement addressSearchResultsDropdown;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#retypePassword")
    private WebElement retypePasswordField;

    @FindBy(css = "#registerNowButton")
    private WebElement registerNowButton;

    public boolean isRegistrationPageDisplayed() {
        return registrationFormHeadText.isDisplayed();
    }

    public void setFirstNameField(final String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(final String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void chooseTitle(final String title) {
        Select pr = new Select(titleDropdown);
        pr.selectByVisibleText(title);
    }

    public void chooseProfession(final String profession) {
        Select pr = new Select(professionDropdown);
        pr.selectByVisibleText(profession);
    }

    public void setPostCode(final String postCode) {
        this.postCode.sendKeys(postCode);
    }

    public void clickFindAddressButton() {
        findAddressButton.click();
    }

    public void chooseAddressFromDropdown(final String address) {
        Select pr = new Select(addressSearchResultsDropdown);
        pr.selectByVisibleText(address);
    }

    public void setPassword(final String password) {
        this.passwordField.sendKeys(password);
    }

    public void setConfirmPassword(final String password) {
        this.retypePasswordField.sendKeys(password);
    }

    public void clickRegisterNowButton() {
        registerNowButton.click();
    }

    public void fillRegistrationInfo(final String title, final String firstName, final String lastName, final String profession,
                                     final String postalCode, final String address, final String password) {
        chooseTitle(title);
        setFirstNameField(firstName);
        setLastNameField(lastName);
        chooseProfession(profession);
        setPostCode(postalCode);
        clickFindAddressButton();
        chooseAddressFromDropdown(address);
        setPassword(password);
        setConfirmPassword(password);
        clickRegisterNowButton();
    }

}
