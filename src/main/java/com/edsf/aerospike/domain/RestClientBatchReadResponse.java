package com.edsf.aerospike.domain;

import com.aerospike.client.BatchRead;

public class RestClientBatchReadResponse {

    public RestClientBatchReadResponse() {}

    public RestClientBatchReadResponse(BatchRead batchRead) {
        readAllBins = batchRead.readAllBins;
        record = batchRead.record != null ? new RestClientRecord(batchRead.record) : null;
        key = new RestClientKey(batchRead.key);
        binNames = batchRead.binNames;
    }

   //"Record associated with the key. Null if the record was not found"
    public RestClientRecord record;

    //Key to retrieve a record
    public RestClientKey key;

    //Whether all bins should be returned with this record
    public boolean readAllBins;

    //List of bins to limit the record response to.
    public String[] binNames;
}
