package com.edsf.aerospike.utils;

import com.aerospike.client.policy.Policy;

import java.util.Map;

public class PolicyConverter {
    public static Policy policyFromMap(Map<String, String> policyMap) {
        Policy policy = new Policy();

        if (policyMap.containsKey(AerospikeAPIConstants.TOTAL_TIMEOUT)) {
            policy.totalTimeout = PolicyValueConverter.getIntValue(
                    policyMap.get(AerospikeAPIConstants.TOTAL_TIMEOUT));
        }
        if (policyMap.containsKey(AerospikeAPIConstants.SOCKET_TIMEOUT)) {
            policy.socketTimeout = PolicyValueConverter.getIntValue(
                    policyMap.get(AerospikeAPIConstants.SOCKET_TIMEOUT));
        }
        if (policyMap.containsKey(AerospikeAPIConstants.SLEEP_BETWEEN_RETRIES)) {
            policy.sleepBetweenRetries = PolicyValueConverter.getIntValue(
                    policyMap.get(AerospikeAPIConstants.SLEEP_BETWEEN_RETRIES));
        }
        if (policyMap.containsKey(AerospikeAPIConstants.MAX_RETRIES)) {
            policy.maxRetries = PolicyValueConverter.getIntValue(
                    policyMap.get(AerospikeAPIConstants.MAX_RETRIES));
        }
        if (policyMap.containsKey(AerospikeAPIConstants.SEND_KEY)) {
            policy.sendKey = PolicyValueConverter.getBoolValue(
                    policyMap.get(AerospikeAPIConstants.SEND_KEY));
        }
        if (policyMap.containsKey(AerospikeAPIConstants.PRIORITY)) {
            policy.priority = PolicyValueConverter.getPriority(
                    policyMap.get(AerospikeAPIConstants.PRIORITY));
        }
        if (policyMap.containsKey(AerospikeAPIConstants.REPLICA)) {
            policy.replica = PolicyValueConverter.getReplica(
                    policyMap.get(AerospikeAPIConstants.REPLICA));
        }
        return policy;
    }
}
