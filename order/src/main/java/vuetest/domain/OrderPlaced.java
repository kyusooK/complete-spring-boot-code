package vuetest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import vuetest.domain.*;
import vuetest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String userId;
    private Date orderDate;
    private InventoryId inventoryId;
    private Address address;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
