package com.edsf.aerospike.utils;
import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.edsf.aerospike.utils.AerospikeAPIConstants.RecordKeyType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Service
public class RequestParamHandler {
    public static BatchPolicy getBatchPolicy(Map<String, String> requestParams) {
        return BatchPolicyConverter.batchPolicyFromMap(requestParams);
    }
    public static String[] getBinsFromMap(MultiValueMap<String, String>requestParams) {
        List<String> binStr = requestParams.get("bins");
        if (binStr == null) {
            return new String[0];
        }
        return binStr.toArray(new String[0]);
    }

    public static RecordKeyType getKeyTypeFromMap(MultiValueMap<String, String> requestParams) {
        String keyTypeStr = requestParams.getFirst(AerospikeAPIConstants.KEY_TYPE);
        if (keyTypeStr == null) {
            return null;
        }
        try {
            return RecordKeyType.valueOf(keyTypeStr);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError(String.format("Invalid keytype: %s , valid choices are STRING, INTEGER, BYTES, DIGEST", keyTypeStr));
        }
    }

    public static RecordKeyType getKeyTypeFromMap(Map<String, String> requestParams) {
        String keyTypeStr = requestParams.get(AerospikeAPIConstants.KEY_TYPE);
        if (keyTypeStr == null) {
            return null;
        }
        try {
            return RecordKeyType.valueOf(keyTypeStr);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError(String.format("Invalid keytype: %s , valid choices are STRING, INTEGER, BYTES, DIGEST", keyTypeStr));
        }
    }
}
