import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AvtoslavaHomePage;
import page.AvtoslavaOrderPage;
import page.AvtoslavaOrderResultPage;
import service.InfoReader;
import service.UserCreator;
import test.CommonConditions;

public class AvtoslavaOrderTest extends CommonConditions {
    @Test
    public void placingAnOrder_withCorrectlyFilledOutFormAndAPhoneNumber() {
        User user = UserCreator.withCredentialsFromProperty();
        String orderSuccessMsg = InfoReader.getOrderSuccessMsg();
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

        Assert.assertEquals(
                resultPage.getTextFromReserveResponse(),
                orderSuccessMsg
        );
    }
}
