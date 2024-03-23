package delivery.dto;

import delivery.utils.RandomDataGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter

public class OrderDto {

    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    private long id;


    public static OrderDto createRandomOrderAndFixedOrderStatusOpen() {
        return OrderDto.builder()
                .customerName(RandomDataGenerator.generateName())
                .customerPhone(RandomDataGenerator.generatePhoneNumber())
                .comment(RandomDataGenerator.generateComment())
                .courierId(RandomDataGenerator.generateCourierId())
                .id(RandomDataGenerator.generateOrderId())
                .status("OPEN")
                .build();
    }
    public static OrderDto createRandomOrderWithRandomStatus() {
        return OrderDto.builder()
                .customerName("Alex")
                .customerPhone("123456789")
                .comment("Hello All")
                .courierId(4)
                .id(6)
                .status(RandomDataGenerator.generateRandomOrderStatus())
                .build();
    }
}

