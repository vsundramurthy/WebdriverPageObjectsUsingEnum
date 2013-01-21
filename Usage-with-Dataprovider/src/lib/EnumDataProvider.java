package lib;

/**
 *
 * @author Vineet Kothari
 */

public class IDataProvider {
  public static interface IDataProvider { }
  public static Object[][] getDataProviderFromEnum(IDataProvider dataProvider[], int driverCount,
      ITestContext context) {
    Object[][] testData = (Object[][]) new Object[dataProvider.length][1];
    int index = 0;
    for (IDataProvider dp : dataProvider) {
      testData[index++][0] = dp;
    }
    return getWebdriverFriendlyData(testData, driverCount, context);
  
