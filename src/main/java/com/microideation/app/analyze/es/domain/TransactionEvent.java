package com.microideation.app.analyze.es.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by sandheepgr on 25/7/16.
 */
@Setter
@Getter
@ToString
@Document(indexName = "transactionevent",type = "TransactionEvent")
public class TransactionEvent extends Event {


    // The amount
    public double amount;

    // Date of the transaction
    public Date txnDate;

    // Location
    private String location;

    // reward currency
    private Long rewardCurrencyId;

    // reward currency qty
    private Long rewardCurrencyQty;

    // program id
    private Long programId;

    // External ref
    private String externalRef;

    // Internal Ref
    private String internalRef;

    // transaction location name
    private String locationName;



}
