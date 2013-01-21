Using it with DataProvider
DataProvider's are part of TestNG annotation and they are very useful when there is a need to inject different kind of data to the test. You can read more about DataProvider at http://testng.org/javadoc/org/testng/annotations/DataProvider.html
Please refer to the example code provided.
 
Interface can be used to get dataprovider from enum.

```java
  public static interface IDataProvider { }
  public static Object[][] getDataProviderFromEnum(IDataProvider dataProvider[], int driverCount,
      ITestContext context) {
    Object[][] testData = (Object[][]) new Object[dataProvider.length][1];
    int index = 0;
    for (IDataProvider dp : dataProvider) {
      testData[index++][0] = dp;
    }
    return getWebdriverFriendlyData(testData, driverCount, context);
  }
```
 
Now this can be inherited in your page objects similar to the above example.
```java
  public static enum Link implements IDataProvider {
  HOME(By.id, "home-link-id"),
  ..
  ..
    }
  }
```
In your TestNG annotated test
```java
  @DataProvider(name = "LINKS", parallel = true)
 protected Object[][] urlActionDataProviderForLinks(final ITestContext context) {
    return BaseDataProvider.getDataProviderFromEnum(Link.values(), context);
  }
 
  @Test(dataProvider = "LINK", retryAnalyzer = BaseTestRetryAnalyzer.class,
      description = "Webpage Links Test")
  public void testLinksOnPage(Link keyword) {
      driver.get('http://example.com');
      keyword.click;
      assertNonEmpty(keyword.getLinkText());
    }
```
