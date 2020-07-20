package com.edsf.aerospike.domain;
import java.util.Map;
import com.aerospike.client.Record;


public class RestClientRecord {

    public RestClientRecord() {};

    public RestClientRecord(Record rec) {
        generation = rec.generation;
        ttl = rec.getTimeToLive();
        bins = rec.bins;
    }

   //name="generation", value="The generation of the record.", example="2"
    public int generation;

    //name="ttl", value="The time to live for the record, in seconds from now.", example="1000"
    public int ttl;

    //name="bins", value="A mapping from binName to binValue",  example="{\"bin1\": \"val1\", \"pi\": \"3.14\"}"
    public Map<String, Object> bins;
}
