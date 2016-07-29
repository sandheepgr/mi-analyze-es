package com.microideation.app.analyze.es.dictionary;

import java.io.Serializable;

/**
 * Created by sandheepgr on 25/7/16.
 */
public class KeyValue implements Serializable {

    // Key for the entry
    private String key;

    // Value for the entry
    private String value;

    public KeyValue() {}

    // Constructor
    public KeyValue(String key, String value) {

        this.key = key;
        this.value = value;

    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
