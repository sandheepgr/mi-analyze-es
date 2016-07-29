package com.microideation.app.analyze.es.listeners.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Created by sandheepgr on 22/7/14.
 */
@Setter
@Getter
@ToString
public class CardTransactionResource  {


    private Long ctxTxnNo;

    private String ctxCardNumber = "";

    private Long ctxCrmId = 0L;

    private Integer ctxTxnType ;

    private Double ctxTxnAmount = 0.0;

    private String ctxReference =  "";

    private Long ctxTxnTerminal = 0L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Timestamp ctxTxnTimestamp;

    private Double ctxCardBalance = 0.0;

    private Long ctxLocation = 0l;

    private Long ctxUserNo = 0l;

    private String merchantName = "";

    private String location = "";


}
