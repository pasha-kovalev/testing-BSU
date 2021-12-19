import org.testng.annotations.Test;
import page.AvtoslavaHomePage;
import service.TestDataReader;
import test.CommonConditions;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.*;

public class AvtoslavaHomePageTest extends CommonConditions {
    @Test
    public void routeFilterTest() {
        String route = TestDataReader.getRoute();
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver)
                .openHomePage()
                .selectRoute();

        assertThat(homePage.findElementsInPanelBy(route)).isEmpty();
    }

    @Test
    public void calendarTest() {
        int testDay = LocalDate.now().plusDays(TestDataReader.getDays()).getDayOfMonth();
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver)
                .openHomePage()
                .clickOnCalendar().clickOnCalendarDay(testDay);

        assertThat(homePage.findElementsInPanelBy(String.valueOf(testDay))).isNotEmpty();
    }
}
