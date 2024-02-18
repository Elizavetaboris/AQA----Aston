import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class SampleTest {

    @Test
    public void testGetRequest() {
        // Отправляем GET-запрос и проверяем код ответа и тело ответа
        RestAssured
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200) // Проверка кода ответа
                .body("args.foo", equalTo("bar")); // Проверка тела ответа
    }
}

