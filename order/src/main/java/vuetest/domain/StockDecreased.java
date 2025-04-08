package vuetest.domain;

import java.util.*;
import lombok.*;
import vuetest.domain.*;
import vuetest.infra.AbstractEvent;

@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
}
