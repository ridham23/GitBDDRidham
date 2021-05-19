package Base;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
   public static WebDriver driver;
    /*public BaseClass()
    {


    }*/
    public static void setUp()
    {
        driver=new ChromeDriver();
    }

}
