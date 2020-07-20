package com.edsf.aerospike.domain;

public class ColumnSensitivityLookup {

    public String nstableid;
    public String namespace;
    public String tablename;
    public String nscolumns;
    public String nspiicolumns;
    public String allcolumns;


    public String getNstableid() {
        return nstableid;
    }

    public void setNstableid(String nstableid) {
        this.nstableid = nstableid;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getNscolumns() {
        return nscolumns;
    }

    public void setNscolumns(String nscolumns) {
        this.nscolumns = nscolumns;
    }

    public String getNspiicolumns() {
        return nspiicolumns;
    }

    public void setNspiicolumns(String nspiicolumns) {
        this.nspiicolumns = nspiicolumns;
    }

    public String getAllcolumns() {
        return allcolumns;
    }

    public void setAllcolumns(String allcolumns) {
        this.allcolumns = allcolumns;
    }


}
