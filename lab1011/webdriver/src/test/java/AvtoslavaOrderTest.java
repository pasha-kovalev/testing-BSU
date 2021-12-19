import model.User;
import org.testng.annotations.Test;
import page.AvtoslavaHomePage;
import page.AvtoslavaOrderPage;
import page.AvtoslavaOrderResultPage;
import service.TestDataReader;
import service.UserCreator;
import test.CommonConditions;
import static org.assertj.core.api.Assertions.assertThat;


public class AvtoslavaOrderTest extends CommonConditions {
    @Test
    public void placingAnOrder_withCorrectlyFilledOutFormAndAPhoneNumber() {
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
