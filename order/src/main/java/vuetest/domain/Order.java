package vuetest.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import vuetest.OrderApplication;
import vuetest.domain.OrderCanceled;
import vuetest.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer qty;

    private String userId;

    private Date orderDate;

    @Embedded
    private InventoryId inventoryId;

    @Embedded
    private Address address;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void modifyOrderinfo(ModifyOrderinfoCommand modifyOrderinfoCommand) {
        //implement business logic here:

        OrderInfoModified orderInfoModified = new OrderInfoModified(this);
        orderInfoModified.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void soldOut(StockDecreased stockDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderCanceled orderCanceled = new OrderCanceled(order);
        orderCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(stockDecreased.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderCanceled orderCanceled = new OrderCanceled(order);
            orderCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
