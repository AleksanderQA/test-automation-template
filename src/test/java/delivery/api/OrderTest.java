package delivery.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import delivery.utils.ApiClient;

public class OrderTest extends BaseSetupApi {

    @Test
    void getOrderInformationAndCheckResponse() {

        Response response = ApiClient.getOrders(getAuthenticatedRequestSpecification());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );
    }
    @RepeatedTest(5)
    void createRandomOrderAndCheckResponse() {

        Response response = ApiClient.createRandomOrder(getAuthenticatedRequestSpecification());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );
    }
    @RepeatedTest(5)
    void createRandomOrderStatusAndCheckResponse() {

        Response response = ApiClient.createRandomOrderStatus(getAuthenticatedRequestSpecification());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );
    }
}

