package service;

import model.User;

public class InfoReader {
    public static final  String TESTDATA_ORDER_SUCCESS_MSG = "testdata.order.successMsg";
    public static final  String TESTDATA_ROUTE = "testdata.main.route";

    public static String getOrderSuccessMsg(){
        return TestDataReader.getTestData(TESTDATA_ORDER_SUCCESS_MSG);
    }

    public static String getRoute(){
        return TestDataReader.getTestData(TESTDATA_ROUTE);
    }
}
