package com.microideation.app.analyze.es.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microideation.app.analyze.es.dictionary.KeyValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sandheepgr on 25/7/16.
 */
@Setter
@Getter
@ToString
public class Event implements Serializable {

    @Id
    public String id;

    // Parent id for the event ( tenant)
    public String parentId;

    // The actor for the event
    public String actor;

    // The type of the vent
    public String eventType;

    // The vent location
    public String eventLocation;

    // The event location name
    public String eventLocationName;

    // timestamp field
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    public Date timestamp = new Date();

    // Ref value 1
    public String refStrValue1;

    // Ref value 2
    public String refStrValue2;

    // Ref value 3
    public String refStrValue3;

    // Ref value 4
    public String refStrValue4;

    // Ref value 5
    public String refStrValue5;



    // Ref value int 1
    public Long refIntValue1;

    // Ref value int 2
    public Long refIntValue2;

    // Ref value int 3
    public Long refIntValue3;

    // Ref value int 4
    public Long refIntValue4;

    // Ref value int 5
    public Long refIntValue5;



    // Ref value double 1
    public double refFloatValue1;

    // Ref value double 2
    public double refFloatValue2;

    // Ref value double 3
    public double refFloatValue3;

    // Ref value double 4
    public double refFloatValue4;

    // Ref value double 5
    public double refFloatValue5;


}
