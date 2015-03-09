#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${appNameLC}.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.findby.FindBy;
import ${package}.webtest.common.util.NZQAPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

@At(urls = { "${symbol_pound}HOST/contacts/organisation/addressList.do" })
public class AddressDetailsPage extends NZQAPageObject {

    @FindBy(id = "type")
    private WebElement type;

    @FindBy(id = "addrLine1")
    private WebElement addrLine1;

    @FindBy(id = "addrLine2")
    private WebElement addrLine2;

    @FindBy(id = "addrLine3")
    private WebElement addrLine3;

    @FindBy(id = "addrLine4")
    private WebElement addrLine4;

    @FindBy(id = "postCode")
    private WebElement postCode;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "addressPreferred")
    private WebElement addressPreferred;

    @FindBy(id = "abstractItemDetailsForm.reasonCode")
    private WebElement abstractItemDetailsFormReasonCode;

    @FindBy(css = "input[value='Save']")
    private WebElement saveButton;

    @FindBy(css = "input[value='Deactivate']")
    private WebElement deactivateButton;

    @FindBy(css = "input[value='Cancel']")
    private WebElement cancelButton;

    public AddressDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void selectType(String option) {
        element(type).selectByVisibleText(option);
    }

    public void setAddrLine1(String text) {
        element(addrLine1).type(text);
    }

    public void setAddrLine2(String text) {
        element(addrLine2).type(text);
    }

    public void setAddrLine3(String text) {
        element(addrLine3).type(text);
    }

    public void setAddrLine4(String text) {
        element(addrLine4).type(text);
    }

    public void setPostCode(String text) {
        element(postCode).type(text);
    }

    public void selectCountry(String option) {
        element(country).selectByVisibleText(option);
    }

    public void setAddressPreferred(boolean checked) {
        setCheckbox(addressPreferred, checked);
    }

    public void selectReasonCode(String option) {
        element(abstractItemDetailsFormReasonCode).selectByVisibleText(option);
    }

    public void save() {
        element(saveButton).click();
    }

    public void deactivate() {
        element(deactivateButton).click();
    }

    public void cancel() {
        element(cancelButton).click();
    }
}
