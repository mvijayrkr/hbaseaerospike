package com.edsf.aerospike.service;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Record;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.IndexTask;
import com.edsf.aerospike.config.AerospikeConfig;
import com.edsf.aerospike.domain.RestClientBatchReadBody;
import com.edsf.aerospike.domain.RestClientBatchReadResponse;
import com.edsf.aerospike.domain.TimeBasedBatchReadResponse;
import com.edsf.aerospike.handler.BatchHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.aerospike.client.BatchRead;
import com.aerospike.client.policy.BatchPolicy;

@Service
public class AerospikeBatchServiceImp implements AerospikeBatchService {
    private BatchHandler handler;
    public AerospikeConfig aerospikeconf;
    TimeBasedBatchReadResponse timeBasedBatchReadResponse;
    List<TimeBasedBatchReadResponse> resObject = new ArrayList<TimeBasedBatchReadResponse>();
    @Autowired
    public AerospikeBatchServiceImp(BatchHandler handler) {
        this.handler = handler;
    }

    @Override
    public List<RestClientBatchReadResponse> batchGet(List<RestClientBatchReadBody> batchKeys, BatchPolicy policy) {
        List<BatchRead> batchReads = batchKeys.stream().map(bk -> bk.toBatchRead()).collect(Collectors.toList());
        handler.batchRead(policy, batchReads);

        return batchReads.stream().map(br -> new RestClientBatchReadResponse(br)).collect(Collectors.toList());
    }

    @Override
    public List<TimeBasedBatchReadResponse> getpoliciesbasedontimeinterval(AerospikeClient client, String minevnttime, String maxevnttime, String service) {
        RecordSet rs = null;
        try {
          /*  IndexTask task = client.createIndex(null, "test", "edsf",
                    "eventts_index", "eventts", IndexType.NUMERIC);
            task.waitTillComplete(100);

            IndexTask task1 = client.createIndex(null, "test", "edsf",
                    "service_index", "service", IndexType.STRING);
            task1.waitTillComplete(100);*/

            // Get min and max

            System.out.println("\nList of records " +  Long.parseLong(minevnttime) + "-" +  Long.parseLong(maxevnttime) +"\n");

            String[] bins = {"pk","policyid","service","eventtime","eventupdatetime","requesteduser","tablename","accessresource","accessperm","accesstype","accessenforcer","cntrycode","bu","profile","eventts"};
            Statement stmt = new Statement();
            stmt.setNamespace("test");
            stmt.setSetName("edsf");
            stmt.setBinNames(bins);
            stmt.setFilters(Filter.range("eventts", Long.parseLong(minevnttime), Long.parseLong(maxevnttime)));
            stmt.setFilters(Filter.equal("service","hive"));
            rs = client.query(null, stmt);
            while (rs.next()) {
                Record r = rs.getRecord();
                for (Map.Entry<String, Object> entry : r.bins.entrySet())
                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
             //   System.out.println(r.bins.getClass().getName());
            /*    System.out.println(r.getValue("pk")  + " "+r.getValue("bin1") + "  "
                        + r.getValue("bin2") +  "  " +r.getValue("startTime") +  "  " +r.getValue("service")  +"\n");*/
              /*  Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(r.bins);
                timeBasedBatchReadResponse = gson.fromJson(jsonElement, TimeBasedBatchReadResponse.class);*/
                final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
                timeBasedBatchReadResponse = mapper.convertValue(r.bins, TimeBasedBatchReadResponse.class);
                resObject.add(timeBasedBatchReadResponse);
            }
        } finally {
            if (rs != null) {
                // Close record set
                rs.close();
            }
        }
        return resObject;
    }



}
