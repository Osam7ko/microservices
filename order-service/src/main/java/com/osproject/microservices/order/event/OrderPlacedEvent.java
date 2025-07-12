package com.osproject.microservices.order.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent{
    private String orderNumber;
    private String email;
    private String firstName;
    private String lastName;
}

//@Getter
//@Setter
//public class OrderPlacedEvent extends ApplicationEvent {
//    private String orderNumber;
//
//    public OrderPlacedEvent(Object source, String orderNumber) {
//        super(source);
//        this.orderNumber = orderNumber;
//    }
//
//    public OrderPlacedEvent(String orderNumber) {
//        super(orderNumber);
//        this.orderNumber = orderNumber;
//    }
//}