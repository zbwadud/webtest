#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${appNameLC}.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.findby.FindBy;
import ${package}.webtest.common.util.NZQAPageObject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

@At(urls = { "${symbol_pound}HOST/contacts/organisation/submitCreateOrganisation.do",
        "${symbol_pound}HOST/contacts/organisation/submitAddressDetails.do", "${symbol_pound}HOST/contacts/organisation/submitRoleDetails.do",
        "${symbol_pound}HOST/contacts/organisation/organisationDetails.do" })
public class OrganisationDetailsPage extends NZQAPageObject {

    @FindBy(css = "input[value='Add Role']")
    private WebElement addRoleButton;

    @FindBy(xpath = "//tr[td[contains(text(),'Status')]]/td[2]")
    private WebElement statusField;

    @FindBy(xpath = "//tr[td[contains(text(),'Formal')]]/td[2]")
    private WebElement formalNameField;

    @FindBy(xpath = "//tr[td[contains(text(),'Country location code')]]/td[2]")
    private WebElement countryLocationCodeField;

    @FindBy(xpath = "//tr[td[contains(text(),'Postal')]]/td[2]")
    private WebElement postalAddressField;

    @FindBy(xpath = "//tr[td[contains(text(),'Postal')]]//a[.='Edit']")
    private WebElement postalAddressEdit;

    @FindBy(name = "roleToAdd")
    private WebElement roleToAddSelect;

    @FindBy(xpath = "//fieldset[legend[contains(text(), 'Role')]]//td[@class='viewdetail']")
    private List<WebElement> roleTypeRows;

    public OrganisationDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addRole(String roleType) {
        element(roleToAddSelect).selectByVisibleText(roleType);
        element(addRoleButton).click();
    }

    public String getStatus() {
        return StringUtils.substringBeforeLast(element(statusField).getText(), "Edit").trim();
    }

    public String getFormalName() {
        return StringUtils.substringBeforeLast(element(formalNameField).getText(), "Edit").trim();
    }

    public String getCountryLocationCode() {
        return element(countryLocationCodeField).getText();
    }

    public String getPostalAddress() {
        return StringUtils.substringBeforeLast(element(postalAddressField).getText(), "Edit").trim();
    }

    public void editPostalAddress() {
        element(postalAddressEdit).click();
    }

    public List<String> getRoleTypes() {
        List<String> roleTypes = new ArrayList<String>();
        for (WebElement roleType : roleTypeRows) {
            roleTypes.add(StringUtils.substringBefore(roleType.getText(), "Edit").trim());
        }
        return roleTypes;
    }
}
