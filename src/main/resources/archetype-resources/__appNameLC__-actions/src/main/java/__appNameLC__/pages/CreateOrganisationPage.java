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

@At(urls = { "${symbol_pound}HOST/contacts/organisation/executeSearch.do" })
public class CreateOrganisationPage extends NZQAPageObject {

    @FindBy(id = "preferredName.name")
    private WebElement preferredNameName;

    @FindBy(id = "locationCountryCode")
    private WebElement locationCountryCode;

    @FindBy(id = "locationCode")
    private WebElement locationCode;

    @FindBy(id = "resmanId")
    private WebElement resmanId;

    @FindBy(id = "fileNumber")
    private WebElement fileNumber;

    @FindBy(id = "preferredAddress.addrLine1")
    private WebElement preferredAddressAddrLine1;

    @FindBy(id = "preferredAddress.addrLine2")
    private WebElement preferredAddressAddrLine2;

    @FindBy(id = "preferredAddress.addrLine3")
    private WebElement preferredAddressAddrLine3;

    @FindBy(id = "preferredAddress.addrLine4")
    private WebElement preferredAddressAddrLine4;

    @FindBy(id = "preferredAddress.country")
    private WebElement preferredAddressCountry;

    @FindBy(id = "preferredAddress.postCode")
    private WebElement preferredAddressPostCode;

    @FindBy(id = "preferredPhone.type")
    private WebElement preferredPhoneType;

    @FindBy(id = "preferredPhone.countryCode")
    private WebElement preferredPhoneCountryCode;

    @FindBy(id = "preferredPhone.areaCode")
    private WebElement preferredPhoneAreaCode;

    @FindBy(id = "preferredPhone.phoneNumber")
    private WebElement preferredPhonePhoneNumber;

    @FindBy(id = "preferredPhone.phoneExtension")
    private WebElement preferredPhonePhoneExtension;

    @FindBy(id = "preferredFax.type")
    private WebElement preferredFaxType;

    @FindBy(id = "preferredFax.countryCode")
    private WebElement preferredFaxCountryCode;

    @FindBy(id = "preferredFax.areaCode")
    private WebElement preferredFaxAreaCode;

    @FindBy(id = "preferredFax.phoneNumber")
    private WebElement preferredFaxPhoneNumber;

    @FindBy(id = "preferredFax.phoneExtension")
    private WebElement preferredFaxPhoneExtension;

    @FindBy(id = "preferredEmail.type")
    private WebElement preferredEmailType;

    @FindBy(id = "preferredEmail.emailAddress")
    private WebElement preferredEmailEmailAddress;

    @FindBy(id = "preferredWwwAddress.type")
    private WebElement preferredWwwAddressType;

    @FindBy(id = "preferredWwwAddress.wwwAddress")
    private WebElement preferredWwwAddressWwwAddress;

    @FindBy(css = "input[value='Save']")
    private WebElement saveButton;

    @FindBy(css = "input[value='Cancel']")
    private WebElement cancelButton;

    public CreateOrganisationPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String text) {
        element(preferredNameName).type(text);
    }

    public void selectLocationCountryCode(String option) {
        element(locationCountryCode).selectByVisibleText(option);
    }

    public void setLocationCode(String text) {
        element(locationCode).type(text);
    }

    public void setResmanId(String text) {
        element(resmanId).type(text);
    }

    public void setFileNumber(String text) {
        element(fileNumber).type(text);
    }

    public void setPreferredAddressAddrLine1(String text) {
        element(preferredAddressAddrLine1).type(text);
    }

    public void setPreferredAddressAddrLine2(String text) {
        element(preferredAddressAddrLine2).type(text);
    }

    public void setPreferredAddressAddrLine3(String text) {
        element(preferredAddressAddrLine3).type(text);
    }

    public void setPreferredAddressAddrLine4(String text) {
        element(preferredAddressAddrLine4).type(text);
    }

    public void selectPreferredAddressCountry(String option) {
        element(preferredAddressCountry).selectByVisibleText(option);
    }

    public void setPreferredAddressPostCode(String text) {
        element(preferredAddressPostCode).type(text);
    }

    public void selectPreferredPhoneType(String option) {
        element(preferredPhoneType).selectByVisibleText(option);
    }

    public void setPreferredPhoneCountryCode(String text) {
        element(preferredPhoneCountryCode).type(text);
    }

    public void setPreferredPhoneAreaCode(String text) {
        element(preferredPhoneAreaCode).type(text);
    }

    public void setPreferredPhonePhoneNumber(String text) {
        element(preferredPhonePhoneNumber).type(text);
    }

    public void setPreferredPhonePhoneExtension(String text) {
        element(preferredPhonePhoneExtension).type(text);
    }

    public void selectPreferredFaxType(String option) {
        element(preferredFaxType).selectByVisibleText(option);
    }

    public void setPreferredFaxCountryCode(String text) {
        element(preferredFaxCountryCode).type(text);
    }

    public void setPreferredFaxAreaCode(String text) {
        element(preferredFaxAreaCode).type(text);
    }

    public void setPreferredFaxPhoneNumber(String text) {
        element(preferredFaxPhoneNumber).type(text);
    }

    public void setPreferredFaxPhoneExtension(String text) {
        element(preferredFaxPhoneExtension).type(text);
    }

    public void selectPreferredEmailType(String option) {
        element(preferredEmailType).selectByVisibleText(option);
    }

    public void setPreferredEmailEmailAddress(String text) {
        element(preferredEmailEmailAddress).type(text);
    }

    public void selectPreferredWwwAddressType(String option) {
        element(preferredWwwAddressType).selectByVisibleText(option);
    }

    public void setPreferredWwwAddressWwwAddress(String text) {
        element(preferredWwwAddressWwwAddress).type(text);
    }

    public void save() {
        element(saveButton).click();
    }

    public void cancel() {
        element(cancelButton).click();
    }
}
