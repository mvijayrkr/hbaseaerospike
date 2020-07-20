package com.edsf.aerospike.domain;

public class TimeBasedBatchReadResponse {
    public String policyid ;
    public String service ;
    public String eventtime ;
    public String eventupdatetime ;
    public String requesteduser ;
    public String tablename ;
    public String accessresource ;
    public String accessperm ;
    public String accesstype ;
    public String accessenforcer ;
    public String cntrycode ;
    public String bu ;
    public String profile ;
    public String eventts;

    public String getPolicyid() {
        return policyid;
    }

    public void setPolicyid(String policyid) {
        this.policyid = policyid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getEventupdatetime() {
        return eventupdatetime;
    }

    public void setEventupdatetime(String eventupdatetime) {
        this.eventupdatetime = eventupdatetime;
    }

    public String getRequesteduser() {
        return requesteduser;
    }

    public void setRequesteduser(String requesteduser) {
        this.requesteduser = requesteduser;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getAccessresource() {
        return accessresource;
    }

    public void setAccessresource(String accessresource) {
        this.accessresource = accessresource;
    }

    public String getAccessperm() {
        return accessperm;
    }

    public void setAccessperm(String accessperm) {
        this.accessperm = accessperm;
    }

    public String getAccesstype() {
        return accesstype;
    }

    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype;
    }

    public String getAccessenforcer() {
        return accessenforcer;
    }

    public void setAccessenforcer(String accessenforcer) {
        this.accessenforcer = accessenforcer;
    }
    public String getCntrycode() {
        return cntrycode;
    }

    public void setCntrycode(String cntrycode) {
        this.cntrycode = cntrycode;
    }


    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEventts() {
        return eventts;
    }

    public void setEventts(String eventts) {
        this.eventts = eventts;
    }


}
