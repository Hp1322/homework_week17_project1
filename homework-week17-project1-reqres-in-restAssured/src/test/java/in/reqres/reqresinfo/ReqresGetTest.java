package in.reqres.reqresinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresGetTest extends TestBase {

    @Test
    public void getAllUsers() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

        int page = response.then().extract().path("page");
        System.out.println("1.page         = "+page);

        int perPage = response.then().extract().path("per_page");
        System.out.println("2.per_page     = "+perPage);

        int totalID = response.then().extract().path("data[1].id");
        System.out.println("3.totalID      = "+totalID);

        String firstName = response.then().extract().path("data[3].first_name");
        System.out.println("4.firstName    = "+firstName);

        List<?> listOfTotalData = response.then().extract().path("data");
        System.out.println("5.list         = "+listOfTotalData.size());

        String avatar = response.then().extract().path("data[5].avatar");
        System.out.println("6.avatar       = "+avatar);

        String supportUrl = response.then().extract().path("support.url");
        System.out.println("7.supportUrl   = "+supportUrl);

        String supportText = response.then().extract().path("support.text");
        System.out.println("8.supportText  = "+supportText);

    }
}
