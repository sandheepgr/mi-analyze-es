package com.microideation.app.analyze.es.listeners.resources;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandheepgr on 4/7/14.
 */
@Getter
@Setter
@ToString
public class TransactionResource  {


    private Long txnId;

    private int txnType;

    private Long txnMerchantNo;

    private String txnLoyaltyId;

    private int txnStatus;

    private Date txnDate;

    private Long txnLocation;

    private String txnInternalRef;

    private String txnExternalRef;

    private Long txnRewardCurrencyId;

    private int txnCrDbInd;

    private double txnRewardQty;

    private double txnAmount;

    private Long txnProgramId;

    private double txnRewardPreBal;

    private double txnRewardPostBal;

    private Date txnRewardExpDt;

    private String rwdCurrencyName;

    private String merchantName;

    private String locationName;

    private java.util.Date createdAt;

}
