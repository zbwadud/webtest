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

@At(urls = { "${symbol_pound}HOST/contacts/organisation/searchOrganisation.do", "${symbol_pound}HOST/contacts/organisation/executeSearch.do" })
public class SearchOrganisationPage extends NZQAPageObject {

    @FindBy(id = "criteria.organisationName")
    private WebElement organisationName;

    @FindBy(id = "organisationRoleTypeCode")
    private WebElement organisationRoleTypeCode;

    @FindBy(id = "providerRoleSubTypeCode")
    private WebElement providerRoleSubTypeCode;

    @FindBy(id = "ssbRoleSubTypeCode")
    private WebElement ssbRoleSubTypeCode;

    @FindBy(id = "criteria.roleKeyColumn1")
    private WebElement roleKeyColumn1;

    @FindBy(id = "criteria.roleKeyColumn2")
    private WebElement roleKeyColumn2;

    @FindBy(id = "criteria.includeExpiredRoles")
    private WebElement includeExpiredRoles;

    @FindBy(id = "criteria.activeStatus")
    private WebElement activeStatus;

    @FindBy(id = "criteria.addressLine4")
    private WebElement addressLine4;

    @FindBy(id = "criteria.alternateIdType")
    private WebElement alternateIdType;

    @FindBy(id = "criteria.alternateId")
    private WebElement alternateId;

    @FindBy(css = "input[value='Search']")
    private WebElement searchButton;

    @FindBy(css = "input[value='Clear']")
    private WebElement clearButton;

    @FindBy(css = "input[value='Add New']")
    private WebElement addNewButton;

    public SearchOrganisationPage(WebDriver driver) {
        super(driver);
    }

    public void setOrganisationName(String text) {
        element(organisationName).type(text);
    }

    public void selectOrganisationRoleTypeCode(String option) {
        element(organisationRoleTypeCode).selectByVisibleText(option);
    }

    public void selectProviderRoleSubTypeCode(String option) {
        element(providerRoleSubTypeCode).selectByVisibleText(option);
    }

    public void selectSsbRoleSubTypeCode(String option) {
        element(ssbRoleSubTypeCode).selectByVisibleText(option);
    }

    public void setRoleKeyColumn1(String text) {
        element(roleKeyColumn1).type(text);
    }

    public void setRoleKeyColumn2(String text) {
        element(roleKeyColumn2).type(text);
    }

    public void selectIncludeExpiredRoles(String option) {
        element(includeExpiredRoles).selectByVisibleText(option);
    }

    public void selectActiveStatus(String option) {
        element(activeStatus).selectByVisibleText(option);
    }

    public void setAddressLine4(String text) {
        element(addressLine4).type(text);
    }

    public void selectAlternateIdType(String option) {
        element(alternateIdType).selectByVisibleText(option);
    }

    public void setAlternateId(String text) {
        element(alternateId).type(text);
    }

    public void search() {
        element(searchButton).click();
    }

    public void clear() {
        element(clearButton).click();
    }

    public void addNew() {
        element(addNewButton).click();
    }
}
