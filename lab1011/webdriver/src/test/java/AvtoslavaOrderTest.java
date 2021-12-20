import model.User;
import org.testng.annotations.Test;
import page.AvtoslavaHomePage;
import page.AvtoslavaOrderPage;
import page.AvtoslavaOrderResultPage;
import service.TestDataReader;
import service.UserCreator;
import test.CommonConditions;

import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class AvtoslavaOrderTest extends CommonConditions {
    @Test
    public void placingAnOrder_withValidForm() {
        User user = UserCreator.withCredentialsFromProperty();
        String orderSuccessMsg = TestDataReader.getOrderSuccessMsg();
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver);
        AvtoslavaOrderPage orderPage = homePage
                .openHomePage()
                .clickOnTomorrow()
                .clickOnSubmitDrive();
        AvtoslavaOrderResultPage resultPage = orderPage.enterName(user.getName())
                .enterPhone(user.getPhone())
                .selectStation()
                .selectNumOfSeats()
                .clickCheckBox()
                .clickOnReserve();

        assertThat(resultPage.getTextFromReserveResponse()).contains(orderSuccessMsg);
    }

    @Test
    public void placingAnOrder_byTwoUsersFail() {
        User user = UserCreator.withSecondPhoneWithCredentialsFromProperty();
        String orderErrorMsg = TestDataReader.getOrderErrorMsg();
        AvtoslavaHomePage homePage1 = new AvtoslavaHomePage(driver);
        homePage1.openHomePage();
        AvtoslavaHomePage homePage2 = homePage1.openNewWindowHomePage();
        Set<String> driverWindowHandles = driver.getWindowHandles();
        Iterator<String> handlesIterator = driverWindowHandles.iterator();
        String parentWindow = handlesIterator.next();
        String childWindow = handlesIterator.next();
        AvtoslavaOrderPage orderPage1 = homePage1
                .clickOnTomorrow()
                .clickOnSubmitDrive();
        orderPage1.enterName(user.getName())
                .enterPhone(user.getPhone())
                .selectStation()
                .selectLastPlace()
                .clickCheckBox();
        driver.switchTo().window(childWindow);
        AvtoslavaOrderPage orderPage2 = homePage2
                .openHomePage()
                .clickOnTomorrow()
                .clickOnSubmitDrive();
        orderPage2.selectStation()
                .selectLastPlace()
                .clickCheckBox()
                .clickOnReserve();
        driver.switchTo().window(parentWindow);
        AvtoslavaOrderResultPage resultPage = orderPage1.clickOnReserve();
        assertThat(resultPage.getTextFromReserveResponse()).contains(orderErrorMsg);
    }

    @Test
    public void placingAnOrder_withNotRegisteredPhone() {
        User user = UserCreator.notRegisteredWithCredentialsFromProperty();
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver);
        AvtoslavaOrderPage orderPage = homePage
                .openHomePage()
                .clickOnTomorrow()
                .clickOnSubmitDrive();
        AvtoslavaOrderResultPage resultPage = orderPage.enterName(user.getName())
                .enterPhone(user.getPhone())
                .selectStation()
                .selectNumOfSeats()
                .clickCheckBox()
                .clickOnReserve();

        assertThat(resultPage.findSmsText()).isNotEmpty();
    }

    @Test
    public void placingAnOrder_withRequiredNotFilled() {
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver);
        AvtoslavaOrderPage orderPage = homePage
                .openHomePage()
                .clickOnTomorrow()
                .clickOnSubmitDrive();
        orderPage.clickCheckBox();

        assertThat(orderPage.isReserveClickable()).isFalse();
    }


}
