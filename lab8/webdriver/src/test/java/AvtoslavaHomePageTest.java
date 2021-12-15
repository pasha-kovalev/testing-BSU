import org.testng.Assert;
import org.testng.annotations.Test;
import page.AvtoslavaHomePage;
import test.CommonConditions;

public class AvtoslavaHomePageTest extends CommonConditions {
    @Test
    public void routeFilterTest() {
        String route = "Минск -> Могилев"/*InfoReader.getRoute()*/;
        AvtoslavaHomePage homePage = new AvtoslavaHomePage(driver)
                .openHomePage()
                .selectRoute();
        Assert.assertTrue(homePage.findElementsBy(route).isEmpty());
    }
}
