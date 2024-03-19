package delivery.dto;

import delivery.utils.RandomDataGenerator;
import lombok.Builder;


@Builder

public class OrderDto {

    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    private long id;


    public static OrderDto createRandomOrderAndFixedOrderStatus() {
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
                .customerName(RandomDataGenerator.generateName())
                .customerPhone(RandomDataGenerator.generatePhoneNumber())
                .comment(RandomDataGenerator.generateComment())
                .courierId(RandomDataGenerator.generateCourierId())
                .id(RandomDataGenerator.generateOrderId())
                .status(RandomDataGenerator.generateRandomOrderStatus())
                .build();
    }
}

