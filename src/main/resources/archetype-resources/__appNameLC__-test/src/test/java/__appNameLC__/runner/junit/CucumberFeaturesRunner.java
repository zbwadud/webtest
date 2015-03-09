#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${appNameLC}.runner.junit;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;


/*
 * Copyright (c) 2014 New Zealand Qualifications Authority.
 * All rights reserved.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        /* The tags option will and should be overridden at runtime to execute a subset of feature files */
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"},
        features = "classpath:features",
        glue = {"${package}.${appNameLC}.stepdefs", "${package}.${appNameLC}.hooks"})
public class CucumberFeaturesRunner {
}
