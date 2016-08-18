package com.microideation.app.analyze.es.listeners;

import com.microideation.app.analyze.es.domain.CardTransactionEvent;
import com.microideation.app.analyze.es.listeners.resources.CardTransactionResource;
import com.microideation.app.analyze.es.repository.CardTransactionEventRepository;
import com.microideation.app.dialogue.annotations.DialogueEventListener;
import com.microideation.app.dialogue.annotations.SubscribeEvent;
import com.microideation.app.dialogue.event.DialogueEvent;
import com.microideation.app.dialogue.event.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 * Created by sandheepgr on 27/7/16.
 */
@Slf4j
@Component
@DialogueEventListener
public class RabbitCardTransactionListener {

    @Autowired
    private CardTransactionEventRepository cardTransactionEventRepository;

    @SubscribeEvent(channelName = "${analyze.cardtransaction.queue}",eventStore = EventStore.RABBITMQ)
    public void receiveCardTransaction(DialogueEvent dialogueEvent) {

        // Get the object
        CardTransactionResource cardTransactionResource = dialogueEvent.getPayload(CardTransactionResource.class);

        // Log the information
        log.info("Card Transaction Resource : " + cardTransactionResource );

        // Call the method to save
        addToElasticSearch(cardTransactionResource);

    }


    /**
     * Method to add the CardTransactionResource to the elastic store
     *
     * @param cardTransactionResource   : The resource received from the source
     */
    protected void addToElasticSearch(CardTransactionResource cardTransactionResource) {

        // Create the object
        CardTransactionEvent cardTransactionEvent = new CardTransactionEvent();

        // Set the fields
        cardTransactionEvent.setActor(cardTransactionResource.getCtxCardNumber());
        cardTransactionEvent.setTimestamp(new Date(cardTransactionResource.getCtxTxnTimestamp().getTime()));
        cardTransactionEvent.setParentId(Long.toString(cardTransactionResource.getCtxTxnTerminal()));
        cardTransactionEvent.setCrmId(Long.toString(cardTransactionResource.getCtxCrmId()));
        cardTransactionEvent.setCtxAmount(cardTransactionResource.getCtxTxnAmount());
        cardTransactionEvent.setCtxReference(cardTransactionResource.getCtxReference());
        cardTransactionEvent.setCtxCardBalance(cardTransactionResource.getCtxCardBalance());
        cardTransactionEvent.setEventLocation(cardTransactionResource.getLocation());
        cardTransactionEvent.setEventType(getCtxTxnType(cardTransactionResource.getCtxTxnType()));
        cardTransactionEvent.setEventLocationName(cardTransactionResource.getLocation());

        // Add to the store
        cardTransactionEventRepository.save(cardTransactionEvent);

    }


    /**
     * Function to get the string value for the transaction type
     *
     * @param ctxType   : The int value for the ctxType
     * @return          : Return the string value corresponding to the txn type
     */
    protected String getCtxTxnType(int ctxType) {

        switch (ctxType) {

            case 1: return "ISSUE";
            case 2: return "TOPUP";
            case 3: return "DEBIT";
            case 4: return "REFUND";
            case 5: return "LOCK";
            case 6: return "UNLOCK";
            case 7: return "TRANSFER_TO";
            case 8: return "TRANSFER_FROM";
            case 9: return "PIN_CHANGE";
            case 10: return "BALANCE_EXPIRED";
            case 11: return "CARD_EXPIRED";
            case 12: return "AMOUNT_TRANSFER_TO";
            case 13: return "AMOUNT_TRANSFER_FROM";
            case 14: return "RETURN";
            case 15: return "PROMO_TOPUP";
            case 16: return "PROMO_DEBIT";

        }

        // return the string value of same
        return Integer.toString(ctxType);

    }

}
