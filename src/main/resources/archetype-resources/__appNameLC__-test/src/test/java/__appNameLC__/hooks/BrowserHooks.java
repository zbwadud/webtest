#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

package ${package}.${appNameLC}.hooks;

import nz.govt.nzqa.webtest.common.util.WebTestsUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

/**
 * Example of a Hook that uses Cucumber @Before annotation. This will be
 * executed before each scenario in a feature file but has been hacked to
 * only execute the implementation when a new feature file is executed.
 * i.e. when the name of the feature file changes.
 *
 * @author ${symbol_dollar}Author${symbol_dollar}
 * @version ${symbol_dollar}Revision${symbol_dollar}
 */
public class BrowserHooks {

    private static final ThreadLocal scenarioIdentifier = new ThreadLocal();

    private static final Logger LOG = LoggerFactory.getLogger(BrowserHooks.class);

    @Autowired
    EventFiringWebDriver webDriver;


    /**
     * <p> This Cucumber Hook will be executed before each Scenario. </p> <p> It will delete all cookies that are
     * associated with the browser only when the Feature name has changed. </p> <p> The Feature ID is a combination of
     * the feature name and scenario name. The scenario name is stripped off so we only have the feature name as an
     * identifier, which is stored in a {@code ThreadLocal} so that it is associated with the currently executing
     * thread. </p> <p> When it is determined that the feature name has changed, the cookies are deleted. </p>
     *
     * @param scenario
     */
    @Before(order = 1)
    public void resetAcrossFeatureFiles(Scenario scenario) {

        if (hasFeatureChanged(scenario)) {
            if (!webDriver.manage().getCookies().isEmpty()) {
                webDriver.manage().deleteAllCookies();
            }
        }
    }


    public void setFeatureIdentifier(String identifier) {
        scenarioIdentifier.set(identifier);
    }


    public String getFeatureIdentifier() {
        return (String) scenarioIdentifier.get();
    }


    private boolean hasFeatureChanged(Scenario scenario) {

        // Store the Scenario for later use when taking screenshots.
        WebTestsUtil.setScenario(scenario);
        String id = scenario.getId();
        String featureName = id.split(";")[0];
        String featureIdentifier = getFeatureIdentifier();
        boolean featureIdChanged = featureIdentifier == null || !featureIdentifier.equals(featureName);
        if (featureIdChanged) {
            setFeatureIdentifier(featureName);
        }
        return featureIdChanged;
    }

}
