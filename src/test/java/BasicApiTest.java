import org.testng.annotations.Test;

public class BasicApiTest extends BaseTest {

    @Test
    public void T01_StatusCodeAndCoresListVerification() {
        res = utils.RestAssuredUtil.getResponse("/launches/latest");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println(testUtil.getCores(jp));
    }

    @Test
    public void T02_verifyResponseObject() {
        res = utils.RestAssuredUtil.getResponse("/launches/latest");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("name: " + jp.get("name"));
        System.out.println("Launchpad: " + jp.get("launchpad"));
        System.out.println("Autoupdate:" + jp.get("autoupdate"));
    }

    @Test
    public void T02_verifyShipping() {
        res = utils.RestAssuredUtil.getResponse("/launches/latest");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Ships{0} " + jp.get("Ships[0]"));
        System.out.println("Ships{1} " + jp.get("Ships[1]"));
        System.out.println("Ships{2} " + jp.get("Ships[2]"));

    }
}
