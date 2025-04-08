package vuetest.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import vuetest.config.kafka.KafkaProcessor;
import vuetest.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockDecreased'"
    )
    public void wheneverStockDecreased_SoldOut(
        @Payload StockDecreased stockDecreased
    ) {
        StockDecreased event = stockDecreased;
        System.out.println(
            "\n\n##### listener SoldOut : " + stockDecreased + "\n\n"
        );

        // Sample Logic //
        Order.soldOut(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
