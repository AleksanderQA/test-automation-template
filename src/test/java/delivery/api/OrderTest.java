package delivery.api;


import delivery.dto.OrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void createRandomOrderAndCheckResponse() {

        Response response = ApiClient.createRandomOrder(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrderAndFixedOrderStatusOpen());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertNotNull(response.getBody().path("id", "Order id is not null")),
                () -> Assertions.assertEquals(response.getBody().path("status"), "OPEN")
        );
    }

    @Test
    void createRandomOrderStatusAndCheckResponse() {

        Response response = ApiClient.createRandomOrderStatus(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrderWithRandomStatus());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertNotNull(response.getBody().path("id", "Order id is not null"))


        );
    }

    @Test
    void deleteOrderById() {
        Response response = ApiClient.createRandomOrder(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrderWithRandomStatus());
        int orderId = response.getBody().path("id");
        Response responseOrderDeletion = ApiClient.deleteOrderById(getAuthenticatedRequestSpecification(), orderId);
    }
}


