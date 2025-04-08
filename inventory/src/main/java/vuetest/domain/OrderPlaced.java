package vuetest.domain;

import java.util.*;
import lombok.*;
import vuetest.domain.*;
import vuetest.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String userId;
    private Date orderDate;
    private Object inventoryId;
    private Object address;
}
