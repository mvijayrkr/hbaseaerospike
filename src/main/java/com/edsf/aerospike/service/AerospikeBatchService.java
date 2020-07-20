package com.edsf.aerospike.service;

import java.util.List;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.BatchPolicy;
import com.edsf.aerospike.domain.RestClientBatchReadBody;
import com.edsf.aerospike.domain.RestClientBatchReadResponse;
import com.edsf.aerospike.domain.TimeBasedBatchReadResponse;

public interface AerospikeBatchService {

    public List<RestClientBatchReadResponse> batchGet(List<RestClientBatchReadBody> batchKeys, BatchPolicy policy);

    public List<TimeBasedBatchReadResponse> getpoliciesbasedontimeinterval(AerospikeClient client, String minevnttime, String maxevnttime, String service);
}
