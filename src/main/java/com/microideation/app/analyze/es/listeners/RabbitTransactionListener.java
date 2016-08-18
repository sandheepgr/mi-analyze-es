package com.microideation.app.analyze.es.listeners;

import com.microideation.app.analyze.es.domain.TransactionEvent;
import com.microideation.app.analyze.es.listeners.resources.TransactionResource;
import com.microideation.app.analyze.es.repository.TransactionEventRepository;
import com.microideation.app.dialogue.annotations.DialogueEventListener;
import com.microideation.app.dialogue.annotations.SubscribeEvent;
import com.microideation.app.dialogue.event.DialogueEvent;
import com.microideation.app.dialogue.event.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sandheepgr on 26/7/16.
 */
@Slf4j
@Component
@DialogueEventListener
public class RabbitTransactionListener {

    @Autowired
    private TransactionEventRepository transactionEventRepository;

    @Value("${analyze.transaction.parentid}")
    private String defaultParentId;


    @SubscribeEvent(channelName = "${analyze.transaction.queue}",eventStore = EventStore.RABBITMQ)
    public void receiveTransaction(DialogueEvent dialogueEvent) {

        // Get the object
        TransactionResource transactionResource = dialogueEvent.getPayload(TransactionResource.class);

        // Log the information
        log.info("Transaction Resource : " + transactionResource);

        // Call the method to save
        addToElasticsearch(transactionResource);

    }


    /**
     * Method to add the TransactionResource to the elasticsearch
     * This method also maps the TransactionResource to TransactionEvent
     *
     * @param transactionResource : The object to be mapped
     */
    protected void addToElasticsearch(TransactionResource transactionResource) {

        // Create the Transaction Event
        TransactionEvent transactionEvent = new TransactionEvent();

        // Set the fields
        transactionEvent.setTxnDate(transactionResource.getTxnDate());
        transactionEvent.setAmount(transactionResource.getTxnAmount());
        transactionEvent.setActor(transactionResource.getTxnLoyaltyId());

        // Check if the default parent id is specified
        if ( defaultParentId == null || defaultParentId.equals("") || defaultParentId.equals("0")) {

            transactionEvent.setParentId(transactionResource.getTxnMerchantNo().toString());

        } else {

            transactionEvent.setParentId(defaultParentId);

        }

        transactionEvent.setEventType(getEventTypeForTransaction(transactionResource.getTxnType()));
        transactionEvent.setEventLocation(Long.toString(transactionResource.getTxnLocation()==null?0:transactionResource.getTxnLocation()));
        transactionEvent.setRewardCurrencyId(transactionResource.getTxnRewardCurrencyId());
        transactionEvent.setRewardCurrencyQty((long)transactionResource.getTxnRewardQty());
        transactionEvent.setProgramId(transactionResource.getTxnProgramId());
        transactionEvent.setExternalRef(transactionResource.getTxnExternalRef());
        transactionEvent.setInternalRef(transactionResource.getTxnInternalRef());
        transactionEvent.setEventLocationName(transactionResource.getLocationName());
        transactionEvent.setTimestamp(transactionResource.getCreatedAt());

        // Add to the repository
        transactionEventRepository.save(transactionEvent);

    }

    /**
     * Method to return strng event type for the int txn type
     *
     * @param txnType : The transaction type
     * @return        : The string representation of the transaction type
     */
    protected String getEventTypeForTransaction(int txnType) {

        switch (txnType) {

            case 1:
                    return "SALES";
            case 2:
                    return "REDEEM";
            case 3:
                return "EXPIRY";
            case 4:
                return "CASHBACK";
            case 5:
                return "LINKING_TRANSFER_TO";
            case 6:
                return "LINKING_TRANSFER_FROM";
            case 7:
                return "TRANSFER_POINT_TO";
            case 8:
                return "TRANSFER_POINT_FROM";
            case 9:
                return "BUY_POINTS";
            case 10:
                return "REWARD_ADJUSTMENT_AWARDING";
            case 11:
                return "REWARD_ADJUSTMENT_DEDUCTING";
            case 12:
                return "TRANSFER_ACCOUNT_TO";
            case 13:
                return "TRANSFER_ACCOUNT_FROM";
            case 14:
                return "ACCOUNT_DEACTIVATION";
            case 15:
                return "POINT_REVERSAL";
            case 16:
                return "CHARGE_CARD_DEBIT";
            case 17:
                return "CHARGE_CARD_TOPUP";
        }

        return Integer.toString(txnType);

    }

}
