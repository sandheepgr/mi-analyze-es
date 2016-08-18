package com.microideation.app.analyze.es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microideation.app.analyze.es.dictionary.KeyValue;
import com.microideation.app.analyze.es.domain.TransactionEvent;
import com.microideation.app.analyze.es.listeners.resources.CardTransactionResource;
import com.microideation.app.analyze.es.repository.TransactionEventRepository;
import com.microideation.app.dialogue.event.DialogueEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MiAnalyzeEsApplication.class)
@WebAppConfiguration
public class MiAnalyzeEsApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() {
    }
/*


    @Test
    public void pushCardTransactionToRMQ() throws JsonProcessingException {

        CardTransactionResource cardTransactionResource = new CardTransactionResource();
        cardTransactionResource.setCtxTxnTerminal(20l);
        cardTransactionResource.setCtxTxnTimestamp(new Timestamp(new Date().getTime()));


        DialogueEvent dialogueEvent =new DialogueEvent();
        dialogueEvent.setPayload(objectMapper.writeValueAsString(cardTransactionResource));

        // ADd to rabbitmq
        rabbitTemplate.convertAndSend("analyze.channel.cardtransaction",dialogueEvent);


    }


    @Test
    public void pushTransactionToRMQ() throws JsonProcessingException {

        TransactionEvent transactionEvent = new TransactionEvent();
        transactionEvent.setAmount(Math.random());
        transactionEvent.setTxnDate(new Date());
        transactionEvent.setActor("9538828853");
        transactionEvent.setEventType("EARNING");
        transactionEvent.setParentId("2");

        // Create the params
        transactionEvent.setRefIntValue1(100l);
        transactionEvent.setRefIntValue2(1000l);

        DialogueEvent dialogueEvent =new DialogueEvent();
        dialogueEvent.setPayload(objectMapper.writeValueAsString(transactionEvent));

        // ADd to rabbitmq
        rabbitTemplate.convertAndSend("analyze.channel.transaction",dialogueEvent);
    }
*/


    /*@Test
    public void addTransactionEvents() {

        Random rand= new Random();


        for (int i = 0; i < 100 ; i++) {

            TransactionEvent transactionEvent = new TransactionEvent();
            transactionEvent.setAmount(Math.random());
            transactionEvent.setTxnDate(new Date());
            transactionEvent.setActor("9538828853");
            transactionEvent.setEventType("EARNING");
            transactionEvent.setParentId("2");

            // Create the params
            transactionEvent.setRefIntValue1((long)rand.nextInt(1000));
            transactionEvent.setRefIntValue2((long)rand.nextInt(1000));

            // save the event
            transactionEventRepository.save(transactionEvent);

            // log the data
            log.info("added the transaction event" + transactionEvent);
        }



    }*/
    /*


    @Test
    public void findByParentIdAndActor() {

        List<TransactionEvent> transactionEvents = transactionEventRepository.findByParentIdAndActor("2","9538828853");
        transactionEventRepository.delete(transactionEvents);
        System.out.println("Received data " + transactionEvents);

    }
*/
}
