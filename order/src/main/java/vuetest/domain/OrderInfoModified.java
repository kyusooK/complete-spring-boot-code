package vuetest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import vuetest.domain.*;
import vuetest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderInfoModified extends AbstractEvent {

    private Long id;
    private Integer qty;

    public OrderInfoModified(Order aggregate) {
        super(aggregate);
    }

    public OrderInfoModified() {
        super();
    }
}
//>>> DDD / Domain Event
