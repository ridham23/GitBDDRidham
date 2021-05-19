package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import Base.BaseClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class CommonMethods extends BaseClass {
    public static void Navigate(String Element)
    {
        WebElement TabElement =driver.findElement(By.xpath(".//span[text()='"+Element+"']"));
        TabElement.click();
    }
    public static void SelectDropdwn(String value)
    {
WebElement drpdwn =driver.findElement((By.xpath(".//span[text()='"+value+"']")));
        Actions action= new Actions(driver);
action.keyDown(Keys.CONTROL).click(drpdwn).build().perform();

    }
    public static void GetCurrentWindow()
    {

    }
}
