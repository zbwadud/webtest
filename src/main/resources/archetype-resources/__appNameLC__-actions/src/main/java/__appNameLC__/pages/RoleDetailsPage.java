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

@At(urls = { "${symbol_pound}HOST/contacts/organisation/roleList.do" })
public class RoleDetailsPage extends NZQAPageObject {

    @FindBy(id = "roleSubtypeCode")
    private WebElement roleSubtypeCode;

    @FindBy(id = "headOfficeCB")
    private WebElement headOfficeCB;

    @FindBy(id = "headOfficeRegistrationStatus")
    private WebElement headOfficeRegistrationStatus;

    @FindBy(id = "dayRegistered")
    private WebElement dayRegistered;

    @FindBy(id = "monthRegistered")
    private WebElement monthRegistered;

    @FindBy(id = "yearRegistered")
    private WebElement yearRegistered;

    @FindBy(id = "headOfficeRecognitionBody")
    private WebElement headOfficeRecognitionBody;

    @FindBy(id = "roleKey1")
    private WebElement roleKey1;

    @FindBy(id = "roleKey2")
    private WebElement roleKey2;

    @FindBy(id = "locationName")
    private WebElement locationName;

    @FindBy(id = "roleRegionSubtypeCode")
    private WebElement roleRegionSubtypeCode;

    @FindBy(id = "primaryContactId")
    private WebElement primaryContactId;

    @FindBy(id = "primaryNzqaContactDept")
    private WebElement primaryNzqaContactDept;

    @FindBy(id = "primaryNzqaContactPhoneExtn")
    private WebElement primaryNzqaContactPhoneExtn;

    @FindBy(id = "startDate")
    private WebElement startDate;

    @FindBy(id = "endDate")
    private WebElement endDate;

    @FindBy(id = "providerCaseApplicationId")
    private WebElement providerCaseApplicationId;

    @FindBy(css = "input[value='Get MOE Number']")
    private WebElement getMOENumberButton;

    @FindBy(css = "input[value='Save']")
    private WebElement saveButton;

    @FindBy(css = "input[value='Cancel']")
    private WebElement cancelButton;

    public RoleDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void selectRoleSubtypeCode(String option) {
        element(roleSubtypeCode).selectByVisibleText(option);
    }

    public void setHeadOfficeCB(boolean checked) {
        setCheckbox(headOfficeCB, checked);
    }

    public void selectHeadOfficeRegistrationStatus(String option) {
        element(headOfficeRegistrationStatus).selectByVisibleText(option);
    }

    public void selectDayRegistered(String option) {
        element(dayRegistered).selectByVisibleText(option);
    }

    public void selectMonthRegistered(String option) {
        element(monthRegistered).selectByVisibleText(option);
    }

    public void selectYearRegistered(String option) {
        element(yearRegistered).selectByVisibleText(option);
    }

    public void selectHeadOfficeRecognitionBody(String option) {
        element(headOfficeRecognitionBody).selectByVisibleText(option);
    }

    public void setRoleKey1(String text) {
        element(roleKey1).type(text);
    }

    public void setLocationCode(String text) {
        element(roleKey2).type(text);
    }

    public void setLocationName(String text) {
        element(locationName).type(text);
    }

    public void selectRoleRegionSubtypeCode(String option) {
        element(roleRegionSubtypeCode).selectByVisibleText(option);
    }

    public void selectPrimaryContactIdByIndex(int index) {
        element(primaryContactId).selectByIndex(index);
    }

    public void setPrimaryNzqaContactDept(String text) {
        element(primaryNzqaContactDept).type(text);
    }

    public void setPrimaryNzqaContactPhoneExtn(String text) {
        element(primaryNzqaContactPhoneExtn).type(text);
    }

    public void selectStartDate(String option) {
        element(startDate).selectByVisibleText(option);
    }

    public void selectEndDate(String option) {
        element(endDate).selectByVisibleText(option);
    }

    public void setApplicationId(String text) {
        element(providerCaseApplicationId).type(text);
    }

    public void getMOENumber() {
        element(getMOENumberButton).click();
    }

    public void save() {
        element(saveButton).click();
    }

    public void cancel() {
        element(cancelButton).click();
    }
}
