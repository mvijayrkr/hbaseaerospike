package com.edsf.aerospike.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeBasedBatchReadBody {

    @JsonProperty(required=true)
    public String mineventtime;
    @JsonProperty(required=true)
    public String maxeventtime;
    @JsonProperty(required=true)
    public String service;



    public String getMineventtime() {
        return mineventtime;
    }

    public void setMineventtime(String mineventtime) {
        this.mineventtime = mineventtime;
    }

    public String getMaxeventtime() {
        return maxeventtime;
    }

    public void setMaxeventtime(String maxeventtime) {
        this.maxeventtime = maxeventtime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }









}
