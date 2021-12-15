import org.testng.annotations.Test;
import page.AvtoslavaHomePage;
import service.TestDataReader;
import test.CommonConditions;
import static org.assertj.core.api.Assertions.assertThat;

public class AvtoslavaHomePageTest extends CommonConditions {
    @Test
    public void routeFilterTest() {
        String route = TestDataReader.getRoute();
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver)
                .openHomePage()
                .selectRoute();

        assertThat(homePage.findElementsInPanelBy(route)).isEmpty();
    }
}
