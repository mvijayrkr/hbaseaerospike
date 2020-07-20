package com.edsf.aerospike.utils;

import com.aerospike.client.policy.*;
import com.aerospike.client.query.PredExp;

public class PolicyValueConverter {

    public static boolean getCompress(String compress) {
        return getBoolValue(compress);
    }

    public static Priority getPriority(String priority) {
        try {
            return Priority.valueOf(priority);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError("Invalid priority: " + priority);
        }
    }

    public static Replica getReplica(String replica) {
        try {
            return Replica.valueOf(replica);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError("Invalid replica: " + replica);
        }
    }

    public static CommitLevel getCommitLevel(String commitLevel) {
        try {
            return CommitLevel.valueOf(commitLevel);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError("Invalid CommitLevel: " + commitLevel);
        }
    }

    public static GenerationPolicy getGenerationPolicy(String generationPolicy) {
        try {
            return GenerationPolicy.valueOf(generationPolicy);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError("Invalid GenerationPolicy: " + generationPolicy);
        }
    }

    public static RecordExistsAction getRecordExistsAction(String recordExistsAction) {
        try {
            return RecordExistsAction.valueOf(recordExistsAction);
        } catch (IllegalArgumentException e) {
            throw new RestClientErrors.InvalidPolicyValueError("Invalid recordExistsAction: " + recordExistsAction);
        }
    }
    public static boolean getBoolValue(String testValue) {
        return testValue.toLowerCase().equals("true");
    }

    public static int getIntValue(String intString) {
        try {
            return Integer.parseInt(intString, 10);
        } catch (NumberFormatException nfe) {
            throw new RestClientErrors.InvalidPolicyValueError(String.format("Invalid integer value: %s", intString));
        }
    }
}
