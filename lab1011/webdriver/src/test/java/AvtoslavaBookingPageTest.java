import model.User;
import org.testng.annotations.Test;
import page.AvtoslavaBookingPage;
import page.AvtoslavaHomePage;
import service.UserCreator;
import test.CommonConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AvtoslavaBookingPageTest extends CommonConditions {
    @Test
    public void viewBooking_whenSmsNotCorrect() {
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver);
        User user = UserCreator.notRegisteredWithCredentialsFromProperty();
        AvtoslavaBookingPage bookingPage = homePage
                .openHomePage()
                .clickOnMyBooking();
        bookingPage.enterPhone(user.getPhone())
                .clickOnComplete()
                .enterSms(user.getPhone())
                .clickOnComplete();

        assertThat(bookingPage.findSmsErrorText()).isNotEmpty();
    }
}
