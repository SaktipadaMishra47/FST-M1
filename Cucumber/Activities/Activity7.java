package testRunner;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")  // Path to your feature files
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "stepDefinitions")  // Path to your step definitions
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@activity6")  // Run scenarios with @activity6 tag
@ConfigurationParameter(
    key = Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, html:Reports/HTML_Report.html, junit:Reports/XML_Report.xml, json:Reports/JSON_Report.json"  // Generate reports
)
@ConfigurationParameter(key = "cucumber.monochrome", value = "true")  // Correct key for monochrome option
public class Activity7 {}
