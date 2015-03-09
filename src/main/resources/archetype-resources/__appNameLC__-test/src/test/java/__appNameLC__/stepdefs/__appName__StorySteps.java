#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */
package ${package}.${appNameLC}.stepdefs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ${package}.${appNameLC}.domain.OrganisationDetails;
import ${package}.${appNameLC}.steps.${appName}UserActions;
import ${package}.${appNameLC}.pages.AddressDetailsPage;
import ${package}.${appNameLC}.pages.SearchOrganisationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;


/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

public class ${appName}StorySteps {


    @Autowired
    private ${appName}UserActions ${appNameLC}Steps;

    @Autowired
    private OrganisationDetails organisationDetails;


    @Given("^I am a logged on ${appName} user${symbol_dollar}")
    public void logInTo${appName}() {
        String userName = System.getProperty("${appNameLC}.username");
        String password = System.getProperty("${appNameLC}.password");
        if (userName == null || password == null) {
            throw new IllegalArgumentException(
                    "The system properties ${appNameLC}.username and ${appNameLC}.password must be set.");
        }
        ${appNameLC}Steps.openLoginPage();
        ${appNameLC}Steps.onLoginPage().logsInAs(userName, password);
    }


    @When("^I search for the organisation ${symbol_escape}'([^${symbol_escape}'].+)${symbol_escape}'${symbol_dollar}")
    public void searchForOrganisation(String organisation) {
        ${appNameLC}Steps.gotoMainMenuPage();
        ${appNameLC}Steps.onMainMenuPage().gotoSearchOrganisation();
        SearchOrganisationPage onSearchOrganisationPage = ${appNameLC}Steps.onSearchOrganisationPage();
        onSearchOrganisationPage.setOrganisationName(organisation);
        onSearchOrganisationPage.search();
    }


    @When("^I search for the new organisation${symbol_dollar}")
    public void searchForNewOrganisation() {
        searchForOrganisation(organisationDetails.getName());
    }


    @When("^I add a new organisation${symbol_dollar}")
    public void whenIAddANewOrganisation() {
        SearchOrganisationPage onSearchOrganisationPage = ${appNameLC}Steps.onSearchOrganisationPage();
        onSearchOrganisationPage.addNew();

        organisationDetails.setName("Automated Selenium Test " + new Date());
        organisationDetails.setLocationCode("01");
        organisationDetails.setAddressLine1("Test Street");
        organisationDetails.setCountry("NEW ZEALAND");

        ${appNameLC}Steps.createOrganisation(organisationDetails);
    }


    @When("^I change the Address Line 2 to '(.+)' with the Reason '(.+)'${symbol_dollar}")
    public void whenIChangeTheAddressLine2ToTestvilleWithTheReasonContactRequestedChange(String addressLine2,
            String reason) {
        ${appNameLC}Steps.onOrganisationDetailsPage().editPostalAddress();
        AddressDetailsPage onAddressDetailsPage = ${appNameLC}Steps.onAddressDetailsPage();
        organisationDetails.setAddressLine2(addressLine2);
        onAddressDetailsPage.setAddrLine2(addressLine2);
        onAddressDetailsPage.selectReasonCode(reason);
        ${appNameLC}Steps.saveAddressDetails(onAddressDetailsPage);
    }


    @When("^I add a role type of '(.+)'${symbol_dollar}")
    public void addRoleTypetoOrganisation(String roleType) {
        String locationCode = "01";
        int contactIdIndex = 3;
        String applicationId = "1234";
        String registrationStatus = "Registered";

        ${appNameLC}Steps.addRoleTypeToOrganisation(roleType, locationCode, contactIdIndex, applicationId,
                registrationStatus);
    }


    @Then("^the organisation status is '(.+)'${symbol_dollar}")
    public void thenOrganisationStatusIs(String status) {
        assertThat(${appNameLC}Steps.onOrganisationDetailsPage().getStatus(), equalTo(status));
    }


    @Then("^the (?:new|updated) organisation details are displayed${symbol_dollar}")
    public void thenTheNewOrganisationDetailsAreDisplayed() {
        ${appNameLC}Steps.verifyOrganisationDetails(organisationDetails);
    }


    @Given("^there is no role type${symbol_dollar}")
    public void thereIsNoRoleType() {
        assertThat(${appNameLC}Steps.getRoleTypes(), hasSize(0));
    }


    @Then("^there is a role type of '(.+)' from today's date${symbol_dollar}")
    public void hasRoleTypeFromTodaysDate(String roleType) {
        List<String> roleTypes = ${appNameLC}Steps.getRoleTypes();
        assertThat(roleTypes, hasSize(1));
        String today = new SimpleDateFormat("dd MMM yyyy").format(new Date());
        assertThat(roleTypes, hasItem(String.format("%s [from %s]", roleType, today)));
    }
}
