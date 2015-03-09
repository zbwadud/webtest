#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${appNameLC}.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import ${package}.webtest.common.util.NZQAPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

@At(urls = { "${symbol_pound}HOST/contacts/mainMenu.do" })
@DefaultUrl("http://localhost:8680/contacts/mainMenu.do")
public class MainMenuPage extends NZQAPageObject {

    @FindBy(linkText = "Quick Search")
    private WebElement quickSearch;

    @FindBy(linkText = "Search Person")
    private WebElement searchPerson;

    @FindBy(linkText = "Search Organisation")
    private WebElement searchOrganisation;

    @FindBy(linkText = "Usage Report")
    private WebElement usageReport;

    @FindBy(linkText = "Logout")
    private WebElement logout;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    public void gotoQuickSearch() {
        element(quickSearch).click();
    }

    public void gotoSearchPerson() {
        element(searchPerson).click();
    }

    public void gotoSearchOrganisation() {
        element(searchOrganisation).click();
    }

    public void gotoUsageReport() {
        element(usageReport).click();
    }

    public void gotoLogout() {
        element(logout).click();
    }
}
