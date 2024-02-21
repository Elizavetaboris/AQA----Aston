import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SampleTest {
    @Test
    public void testGetRequest() {
        given()
                .param("foo", "bar")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"));
    }
    @Test
    public void testPostRequestWithRawText() {
        String requestBody = "This is a sample raw text for POST request testing";

        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is a sample request body for testing PUT request";

        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

        @Test
        public void testPatchMethod() {
            String requestBody = "{\"name\": \"New Name\", \"age\": 30}";

            given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .patch("https://postman-echo.com/patch")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("json.name", equalTo("New Name"))
                    .body("json.age", equalTo(30));
        }
    }







