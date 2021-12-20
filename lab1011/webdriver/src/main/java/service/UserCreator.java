package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PHONE = "testdata.user.phone";
    public static final String TESTDATA_USER_SECOND_PHONE = "testdata.user.otherPhone";

    public static final String TESTDATA_NOT_REGISTERED_PHONE = "testdata.order.notRegisteredPhone";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PHONE));
    }

    public static User notRegisteredWithCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_NOT_REGISTERED_PHONE));
    }

    public static User withSecondPhoneWithCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_SECOND_PHONE));
    }

    public static User withEmptyUsername() {
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PHONE));
    }

    public static User withEmptyPhone() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
