package Runner;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@regression"},
        features={"C:\\Users\\ridha\\Documents\\BDDFreeCrm\\src\\main\\java\\feature\\login.feature"}//these are run alphabetically
        ,glue={"stepDef"},
        dryRun = false,

        strict = true
//C:\Users\ridha\Documents\BDDFreeCrm\src\main\java\feature\login.feature
)

public class TestRunner {
}
