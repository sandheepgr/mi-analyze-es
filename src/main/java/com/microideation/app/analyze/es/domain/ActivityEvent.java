package com.microideation.app.analyze.es.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by sandheepgr on 25/7/16.
 */
@Document(indexName = "activityevent",type = "ActivityEvent")
public class ActivityEvent extends Event {

    // The date of even
    private Date activityDate;

    // The remarks.
    private String remarks;


    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public String toString() {
        return "ActivityEvent{" +
                "activityDate=" + activityDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
