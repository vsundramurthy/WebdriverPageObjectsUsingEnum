package lib;

import lib.PageObjects.Links;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
*
* @author Vineet Kothari
*/
public class DataproviderTest {

@Test(dataProvider = "LINKS", description = "Test all links")
  public void testAllLinksText(Links keyword) {
    driver.get("http://www.example.com");
    keyword.click();
    assertTrue (keyword.getLinkText(), keyword.getText(), "Text did not match");
  }

@DataProvider(name = "LINKS")
  protected Object[][] urlActionDataProviderForLinks(final ITestContext context) {
     return EnumDataProvider.getDataProviderFromEnum(Links.values(), context);
 }
}
