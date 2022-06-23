package com.sandbox.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
//@ContextConfiguration(locations =  {"classpath*:/spring/applicationContext*.xml"})
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"com/sandbox/bdd/stepDefs","src/test/resources"},
        dryRun = false,
        tags = {"@add_customer","@add_paymentMethod","@charge_transaction"})
public class RunnerIT {

}
