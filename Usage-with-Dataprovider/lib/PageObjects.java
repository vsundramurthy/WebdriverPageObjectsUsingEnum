package lib;
import lib.EnumDataProvider.IDataProvider;
import org.openqa.selenium.By;
/**
*
* @author Vineet Kothari
*/
public class PageObjects {
  public static enum Links implements IDataProvider {
    HOME(By.id, "home-link-id", "Home"),
    ABOUT_US(By.id, "about-us-id", "About Us"),
    CONTACT_US(By.id, "contact-us-id", "Contact"),
    TERMS(By.xpath, "\\div[text() = '/terms']", "Terms");;
  }

  private By by;
  private String locator;
  private String text;

  private Links(By by, String locator, String text) {
    this.by = by;
    this.locator = locator;
    this.text = text;
  }

  public void click(driver) {
   driver.findElement(by, locator).click();
  }

  public void getLinkText(driver) {
   driver.findElement(by, locator).getText();
  }

  public getText(driver) {
    return text;
  }
}
