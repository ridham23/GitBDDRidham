package stepDef;

import Base.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Base.BaseClass;
import java.util.List;
import java.util.Map;

public class StepDef_Two extends BaseClass {


    @Given("^User Launch and click Login again$")
    public void User_Launch_and_click_Login_again() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ridha\\Documents\\BDDNaveen\\chromedriver.exe");
        BaseClass.setUp();
        System.out.println("Launched");
        driver.get("https://www.freecrm.com");
        System.out.println("method called again");
        driver.getPageSource();
        System.out.println("title is "+driver.getTitle());
        Thread.sleep(10000);
        System.out.println("nothing");
        WebElement BtnLogin = driver.findElement(By.xpath(".//span[text()='Log In']"));
        BtnLogin.click();
    }
    @Then("^User enters username and password again$")
    public void User_enters_username_and_password_again(DataTable Cred)
    {
        for(Map<String, String> data : Cred.asMaps(String.class,String.class))
        {
            System.out.println("Entering Cred");
        driver.findElement(By.name("email")).sendKeys(data.get("username"));
        driver.findElement(By.name("password")).sendKeys(data.get("password"));
    }
    }

}
