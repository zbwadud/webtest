#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2013 New Zealand Qualifications Authority.
 * All rights reserved.
 */
package ${package}.${appNameLC}.steps;

import java.util.List;

import ${package}.${appNameLC}.domain.OrganisationDetails;
import ${package}.${appNameLC}.pages.AddressDetailsPage;
import ${package}.${appNameLC}.pages.CreateOrganisationPage;
import ${package}.${appNameLC}.pages.OrganisationDetailsPage;
import ${package}.${appNameLC}.pages.RoleDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

public class ${appName}UserActions extends ${appName}PageActions {

    private static final long serialVersionUID = 1L;

    public ${appName}UserActions(Pages pages) {
        super(pages, "${appNameLC}");
    }

    @Override
    public void clickLogoutLink() {
        throw new UnsupportedOperationException();
    }

    @Step
    public void createOrganisation(OrganisationDetails parameterObject) {
        CreateOrganisationPage onCreateOrganisationPage = onCreateOrganisationPage();
        onCreateOrganisationPage.setName(parameterObject.getName());
        onCreateOrganisationPage.setLocationCode(parameterObject.getLocationCode());
        onCreateOrganisationPage.setPreferredAddressAddrLine1(parameterObject.getAddressLine1());
        onCreateOrganisationPage.save();
    }

    @Step
    public void verifyOrganisationDetails(OrganisationDetails organisationDetails) {
        OrganisationDetailsPage onSubmitCreateOrganisationPage = onOrganisationDetailsPage();
        assertThat(onSubmitCreateOrganisationPage.getFormalName(), equalTo(organisationDetails.getName()));
        assertThat(onSubmitCreateOrganisationPage.getCountryLocationCode(),
                equalTo(organisationDetails.getLocationCode()));

        String expectedPostalAddress = organisationDetails.getAddressLine1();
        if (organisationDetails.getAddressLine2() != null) {
            expectedPostalAddress += "${symbol_escape}n" + organisationDetails.getAddressLine2();
        }
        expectedPostalAddress += "${symbol_escape}n" + organisationDetails.getCountry();
        assertThat(onSubmitCreateOrganisationPage.getPostalAddress(), equalTo(expectedPostalAddress));
    }

    @Step
    public void addRoleTypeToOrganisation(String roleType, String locationCode, int contactIdIndex,
            String applicationId, String registrationStatus) {
        OrganisationDetailsPage onOrganisationDetailsPage = onOrganisationDetailsPage();
        onOrganisationDetailsPage.addRole(roleType);

        RoleDetailsPage onRoleDetailsPage = onRoleDetailsPage();
        onRoleDetailsPage.selectHeadOfficeRegistrationStatus(registrationStatus);
        onRoleDetailsPage.getMOENumber();
        onRoleDetailsPage.setLocationCode(locationCode);
        onRoleDetailsPage.selectPrimaryContactIdByIndex(contactIdIndex);
        onRoleDetailsPage.setApplicationId(applicationId);
        saveRoleDetails(onRoleDetailsPage);
    }

    @Step
    public void saveRoleDetails(RoleDetailsPage onRoleDetailsPage) {
        onRoleDetailsPage.save();
    }

    @Step
    public void saveAddressDetails(AddressDetailsPage onAddressDetailsPage) {
        onAddressDetailsPage.save();
    }

    @Step
    public List<String> getRoleTypes() {
        return onOrganisationDetailsPage().getRoleTypes();
    }
}
