package service;

import java.util.ResourceBundle;

public class TestDataReader {
    public static final String TESTDATA_ORDER_SUCCESS_MSG = "testdata.order.successMsg";
    public static final String TESTDATA_ROUTE = "testdata.main.route";
    public static final String TESTDATA_DAYS = "testdata.main.days";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    public static String getOrderSuccessMsg() {
        return getTestData(TESTDATA_ORDER_SUCCESS_MSG);
    }

    public static String getRoute() {
        return getTestData(TESTDATA_ROUTE);
    }

    public static long getDays() {
        return Long.parseLong(getTestData(TESTDATA_DAYS));
    }
}
