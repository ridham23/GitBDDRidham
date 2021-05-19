package stepDef;

import Base.BaseClass;
import com.google.common.collect.Sets;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import cucumber.api.java.gl.E;
import net.bytebuddy.pool.TypePool;
import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StepsDef extends BaseClass {

    public static int size;
   public static Set<String> windowhandles;
   public static WebDriverWait wait ;
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='first_name']")));

    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page()  {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ridha\\Documents\\BDDNaveen\\chromedriver.exe");
BaseClass.setUp();
        driver.get("https://www.freecrm.com");
System.out.println("nothing");

    }

    @When("^title of login page is freecrm$")
    public void title_of_login_page_is_freecrm() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(10000);
      /*  JavascriptExecutor scr=new JavascriptExecutor() {
            @Override
            public Object executeScript(String script, Object... args) {
                //executeScript()
                return null;
            }

            @Override
            public Object executeAsyncScript(String script, Object... args) {
                return null;
            }
        }*/


    }

    @Then("^User Enters Username \"(.*)\"$")
    public void user_Enters_Username(String username)  {
        driver.findElement(By.name("email")).sendKeys(username);

    }

    @Then("^User Enters Password \"(.*)\"$")
    public void user_Enters_Password(String password)  {
        driver.findElement(By.name("password")).sendKeys(password);
    }
    @Then("^User Clicks Login Button$")
    public void user_Clicks_login_Button()  {
        WebElement BtnLogin = driver.findElement(By.xpath(".//span[text()='Log In']"));
        BtnLogin.click();

    }
    @Then("^User Authenticates with Login Button$")
    public void user_Clicks_Authentication_Button()  {
        WebElement BtnLogin = driver.findElement(By.xpath(".//div[text()='Login']"));
        BtnLogin.click();

    }
    @Then("^User navigates to Contacts Page$")
    public void User_navigates_to_Contacts_Page()
    {
        try {
            Thread.sleep(10000);
            CommonMethods.Navigate("Contacts");
             windowhandles = driver.getWindowHandles();
          size = windowhandles.size();
            System.out.println(size);
            String CurrentHandle = driver.getWindowHandle();
            if (size > 1) {
                for (String handle : windowhandles) {
                    if (!(handle.equals(CurrentHandle))) {

                        System.out.println(handle);
                        WebDriverWait wait = new WebDriverWait(driver, 20);
                        driver.switchTo().window(handle);
                        System.out.println(handle);
                        System.out.println("new window new button");
                        WebElement NewButton = wait.until(webDriver -> ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='New']")).apply(webDriver));
                        //ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='New']"))
                        //WebElement NewButton = driver.findElement(By.xpath(".//button[text()='New']"));
                        System.out.println("Clicked on New Button");
                        NewButton.click();


                    }
                }
            } else {
                System.out.println("old window new btn");
                //WebElement NewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='New']")));
                WebElement NewButton = driver.findElement(By.xpath(".//button[text()='New']"));
                System.out.println("Clicked on New Button");
                NewButton.click();
            }
        }
        catch(Exception e)
        {
            System.out.println("exception is "+e.getMessage() );
        }

    }
    public void GetWindowHandle(WebDriver driverN,int sizenew,Set<String> windowhandlesN)
    {
        Set<String> windowhandled = driverN.getWindowHandles();
        int sizeN = windowhandled.size();
        if(sizeN>sizenew)
        {
            Set<String> DiffVal=Sets.difference(windowhandled,windowhandlesN);
            for(String val:DiffVal)
            {
                driverN.switchTo().window(val);
                System.out.println("switched to latest window");
            }

        }
    }
    @Then("^User Enters FirstName \"(.*)\"$")
    public void User_Enters_Firstname(String FirstName)
                {
                    // WebDriverWait wait = new WebDriverWait(driver, 20);
                    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='first_name']")));
                    try {
                        Thread.sleep(5000);
                        GetWindowHandle(driver,size,windowhandles);
                        System.out.println("Existing Window");
wait = new WebDriverWait(driver, 20);
                         wait.until(webDriver ->  ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='first_name']")).apply(webDriver));
                         //ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='first_name']"))
WebElement FirstNameElement= driver.findElement(By.cssSelector("input[name*='first_name']"));
                        System.out.println("first name found");
                        Boolean exists=driver.findElements(By.cssSelector("input[name*='first_name']")).size()==0;
                        System.out.println(exists.toString());
                        Assert.assertFalse(exists);
                        Thread.sleep(5000);
FirstNameElement.click();
                        System.out.println("entering fname as "+FirstName);
                        FirstNameElement.sendKeys(FirstName);
                        System.out.println("dentered fname as "+FirstName);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
    @Then("^User Enters LastName \"(.*)\"$")
    public void User_Enters_LastName(String lastname) throws InterruptedException {
        driver.findElement(By.cssSelector("input[name*='last_name']")).sendKeys(lastname);
        WebElement FirstNameElement= driver.findElement(By.cssSelector("input[name*='first_name']"));
        FirstNameElement.sendKeys("rid");

    }
    @Then("^User Enters Category \"(.*)\"$")
    public void User_Enters_Category(String category)
    {
        try {
            System.out.println("Clicking category button");
            WebElement DrpDwnCategory = driver.findElement(By.cssSelector("div[name='category']"));
            DrpDwnCategory.click();
            System.out.println("Selecting drop down value as "+category);
            CommonMethods.SelectDropdwn(category);

        }
        catch (Exception e)
        {
            System.out.println("Exception is "+e.getMessage());
        }
    }
    @Then("^User Clicks Save$")
    public void User_Clicks_Save()
    {
        WebElement BtnSave=driver.findElement(By.cssSelector("button[class*='ui linkedin']"));
       BtnSave.click();
    }

    @Given("^Browser is closed$")
    public void Browser_is_closed()
    {
        driver.quit();
    }
    @Given("^User Launch and click Login$")
    public void User_Launch_and_click_Login() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ridha\\Documents\\BDDNaveen\\chromedriver.exe");
        BaseClass.setUp();
        driver.get("https://www.freecrm.com");
        driver.getPageSource();
        System.out.println("title is "+driver.getTitle());

        System.out.println("nothing");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        WebElement BtnLogin = driver.findElement(By.xpath(".//span[text()='Log In']"));
      // File file= BtnLogin.getScreenshotAs(OutputType.FILE);
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Users\\ridha\\snap.png");
        FileUtils.copyFile(file,DestFile);
        BtnLogin.click();
    }
    @Then("^User enters username and password$")
    public void User_enters_username_and_password(DataTable Cred)
    {
    List<List<String>> data = Cred.raw();
        System.out.println("Entering Cred");
        driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
        driver.findElement(By.name("password")).sendKeys(data.get(0).get(0));
    }

}
