package io.turntabl.orderservice.models;

import io.turntabl.orderservice.enums.OrderStatus;
import io.turntabl.orderservice.enums.Side;
import io.turntabl.orderservice.dtos.OrderDto;
import io.turntabl.orderservice.dtos.OrderInformationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    @Id
    private String id;

    @Field("order_information")
    private List<OrderInformationDto> orderInformation = new ArrayList<>();

    @Field(name = "user_id")
    private String userId;

    private Side side;

    private Double price;

    private int quantity;

    private String ticker;

    private OrderStatus status;

    @Field(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Field(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Order fromDto(OrderDto dto){
        Order order = new Order();

        order.setSide(dto.getSide());
        order.setOrderInformation(dto.getOrderInformation());
        order.setPrice(dto.getPrice());
        order.setQuantity(dto.getQuantity());
        order.setTicker(dto.getTicker());
        order.setId(dto.getId());
        order.setUserId(dto.getUserId());
        order.setStatus(dto.getStatus());


        return order;
    }

}

