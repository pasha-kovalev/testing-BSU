import org.testng.annotations.Test;
import page.AvtoslavaContactsPage;
import page.AvtoslavaHomePage;
import service.TestDataReader;
import test.CommonConditions;
import static org.assertj.core.api.Assertions.*;

public class AvtoslavaContactsPageTest extends CommonConditions {
    @Test
    public void sendMessage_whenInputNotValid() {
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver);
        AvtoslavaContactsPage contactsPage = homePage
                .openHomePage()
                .clickOnContacts();
        contactsPage.enterMessage(TestDataReader.getOrderSuccessMsg());

        assertThat(contactsPage.isValidInput()).isFalse();
    }
}
