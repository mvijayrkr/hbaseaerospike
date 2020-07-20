package com.edsf.aerospike.utils;

import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.Policy;

import java.util.Map;

public class BatchPolicyConverter {

    public static BatchPolicy batchPolicyFromMap(Map<String, String> policyMap) {
        Policy basePolicy = PolicyConverter.policyFromMap(policyMap);
        BatchPolicy batchPolicy = new BatchPolicy(basePolicy);

        if (policyMap.containsKey(AerospikeAPIConstants.ALLOW_INLINE)) {
            batchPolicy.allowInline = PolicyValueConverter.getBoolValue(
                    policyMap.get(AerospikeAPIConstants.ALLOW_INLINE));
        }

        if (policyMap.containsKey(AerospikeAPIConstants.MAX_CONCURRENT_THREADS)) {
            batchPolicy.maxConcurrentThreads = PolicyValueConverter.getIntValue(
                    policyMap.get(AerospikeAPIConstants.MAX_CONCURRENT_THREADS));
        }

        if (policyMap.containsKey(AerospikeAPIConstants.SEND_SET_NAME)) {
            batchPolicy.sendSetName = PolicyValueConverter.getBoolValue(
                    policyMap.get(AerospikeAPIConstants.SEND_SET_NAME));
        }

        return batchPolicy;
    }
}
