package com.microideation.app.analyze.es.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by sandheepgr on 27/7/16.
 */
@Setter
@Getter
@ToString
@Document(indexName = "cardtransactionevent",type = "CardTransactionEvent")
public class CardTransactionEvent extends Event {

    // the crmId
    private String crmId;

    // txn type
    private String ctxType;

    // txn amount
    private double ctxAmount;

    // Reference
    private String ctxReference;

    // txn balance
    private Double ctxCardBalance;

    // txn location
    private String ctxLocation;

    // The location name
    private String ctxLocationName;



}
