package com.linedata.lsq.model.events;

import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;

import java.time.LocalDateTime;

public class DealEventNotification {

    private static Long id_counter = 0L;

    private String id;
    private String event;
    private LocalDateTime localDateTime;
    private DealWrapper dealWrapper;

    public DealEventNotification(String event, DealWrapper dealWrapper) {
        id_counter = id_counter + 1;
        this.id = id_counter + "";
        this.event = event;
        this.localDateTime = LocalDateTime.now();
        this.dealWrapper = dealWrapper;
    }

    public DealEventNotification() {
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getId() {
        return id;
    }

    public DealWrapper getDeal() {
        return dealWrapper;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "DealOperationEvent{" +
                "id='" + id + '\'' +
                ", event=" + event +
                ", deal=" + dealWrapper +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
