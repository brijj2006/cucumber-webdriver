package org.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        glue = {"classpath:org.example.glue"},
        features = {"classpath:features"},
        tags = {"@smoke_test"},
        plugin = {
                "pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class RunTest {
}