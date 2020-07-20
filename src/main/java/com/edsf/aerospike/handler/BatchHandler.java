package com.edsf.aerospike.handler;
import java.util.List;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.BatchRead;
import com.aerospike.client.policy.BatchPolicy;
import org.springframework.stereotype.Service;

@Service
public class BatchHandler {
    private AerospikeClient client;

    public BatchHandler(AerospikeClient client) {
        this.client = client;
    }

    public void batchRead(BatchPolicy policy, List<BatchRead>records) {
        client.get(policy, records);
    }
}
