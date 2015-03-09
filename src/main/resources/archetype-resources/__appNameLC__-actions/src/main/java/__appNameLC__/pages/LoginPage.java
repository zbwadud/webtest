#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${appNameLC}.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import ${package}.webtest.common.util.NZQALoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

@At(urls = { "${symbol_pound}HOST/contacts/mainMenu.do" })
@DefaultUrl("http://localhost:8680/contacts/mainMenu.do")
public class LoginPage extends NZQALoginPage {

    @FindBy(id = "j_username")
    private WebElement usernameField;

    @FindBy(id = "j_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void logsInAs(String username, String password) {
        element(usernameField).type(username);
        element(passwordField).type(password);
        clickLoginButton();
    }

    public String getErrorText() {
        return getDriver().findElement(By.className("err")).getText();
    }

    @Override
    public void clickLoginButton() {
        clickOn(loginButton);
    }
}
