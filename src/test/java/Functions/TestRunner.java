package Functions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
//@ExtendWith(Cucumber.class)
//@DisplayName("Cucumber Test Runner")

@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions", // Update with your actual step definitions package
        tags = "not (@ApiTest and @JunitTest and @MobileTest)",
        //plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

)
public class TestRunner {
    // This class doesn't need any code. It just acts as a runner for Cucumber tests.

}