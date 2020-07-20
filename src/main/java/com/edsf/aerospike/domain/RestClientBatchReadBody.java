package com.edsf.aerospike.domain;

import com.aerospike.client.BatchRead;
import com.edsf.aerospike.utils.RestClientErrors;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestClientBatchReadBody {

    //value="Key to retrieve a record", required=true)
    @JsonProperty(required=true)
    public RestClientKey key;

    //value="Whether all bins should be returned with this record")
    public boolean readAllBins;

    //value="List of bins to limit the record response to.", required=false)
    public String[] binNames;

    public RestClientBatchReadBody() {}

    public BatchRead toBatchRead() {
        if (key == null) {
            throw new RestClientErrors.InvalidKeyError("Key for a batch read may not be null");
        }
        if (readAllBins) {
            return new BatchRead(key.toKey(), true);
        } else {
            return new BatchRead(key.toKey(), binNames);
        }
    }
}
