package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/testLogin.feature",
        glue = {"StepDefinitions"}
)
public class Run {
}
