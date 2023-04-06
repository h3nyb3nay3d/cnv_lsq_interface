package com.linedata.lsq.model.events;

import java.time.LocalDateTime;

public class DealRequest {

    private static Long id_counter = 0L;

    private String id;
    private String externalId;
    private LocalDateTime localDateTime;
    private Boolean byDealExternalId;
    private int level;

    public DealRequest(String externalId, Boolean byDealExternalId, int level) {
        id_counter=id_counter+1;
        this.id = id_counter+"";
        this.localDateTime=LocalDateTime.now();
        this.externalId = externalId;
        this.byDealExternalId=byDealExternalId;
        this.level=level;
    }

    public DealRequest() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public Boolean isByDealExternalId() {
        return byDealExternalId;
    }

    public void setByDealExternalId(Boolean byDealExternalId) {
        this.byDealExternalId = byDealExternalId;
    }

}
