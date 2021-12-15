package service;

import model.User;

public class UserCreator {
    public static final  String TESTDATA_USER_NAME = "testdata.user.name";
    public static final  String TESTDATA_USER_PHONE = "testdata.user.phone";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PHONE));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PHONE));
    }

    public static User withEmptyPhone(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
