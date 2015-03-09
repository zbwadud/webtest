#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2013 New Zealand Qualifications Authority.
 * All rights reserved.
 */
package ${package}.${appNameLC}.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import ${package}.${appNameLC}.pages.AddressDetailsPage;
import ${package}.${appNameLC}.pages.CreateOrganisationPage;
import ${package}.${appNameLC}.pages.LoginPage;
import ${package}.${appNameLC}.pages.MainMenuPage;
import ${package}.${appNameLC}.pages.OrganisationDetailsPage;
import ${package}.${appNameLC}.pages.RoleDetailsPage;
import ${package}.${appNameLC}.pages.SearchOrganisationPage;
import ${package}.webtest.common.util.AbstractNZQAScenarioSteps;

/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

public abstract class ${appName}PageActions extends AbstractNZQAScenarioSteps {

    private static final long serialVersionUID = -9086377359969564293L;

    public ${appName}PageActions(Pages pages) {
        super(pages);
    }

    public ${appName}PageActions(Pages pages, String applicationName) {
        super(pages, applicationName);
    }

    @Step
    public LoginPage openLoginPage() {
        return openPage(LoginPage.class);
    }

    @Override
    public LoginPage onLoginPage() {
        return switchCurrentPage(LoginPage.class);
    }

    public MainMenuPage onMainMenuPage() {
        return switchCurrentPage(MainMenuPage.class);
    }

    public MainMenuPage gotoMainMenuPage() {
        return openPage(MainMenuPage.class);
    }

    public SearchOrganisationPage onSearchOrganisationPage() {
        return switchCurrentPage(SearchOrganisationPage.class);
    }

    public CreateOrganisationPage onCreateOrganisationPage() {
        return switchCurrentPage(CreateOrganisationPage.class);
    }

    public OrganisationDetailsPage onOrganisationDetailsPage() {
        return switchCurrentPage(OrganisationDetailsPage.class);
    }

    public AddressDetailsPage onAddressDetailsPage() {
        return switchCurrentPage(AddressDetailsPage.class);
    }

    public RoleDetailsPage onRoleDetailsPage() {
        return switchCurrentPage(RoleDetailsPage.class);
    }
}
