package com.edsf.aerospike.utils;

import java.util.Base64;

import com.aerospike.client.Key;
import com.edsf.aerospike.utils.AerospikeAPIConstants.RecordKeyType;

public class KeyBuilder {
    public static Key buildKey(String namespace, String set, String strKey, RecordKeyType keyType) {
        if (keyType == null) {
            return new Key(namespace, set, strKey);
        }
        switch(keyType) {
            case STRING:
                return new Key(namespace, set, strKey);
            case INTEGER:
                return new Key(namespace, set, getLongFromstring(strKey));
            case BYTES: {
                return new Key(namespace, set, getByteArrayFromstring(strKey));
            }
            case DIGEST: {
                byte[] digestBytes = getByteArrayFromstring(strKey);
                if (digestBytes.length != 20) {
                    throw new RestClientErrors.InvalidKeyError(String.format("Digest must be 20 bytes long", strKey));
                }
                return new Key(namespace, digestBytes, set, null);
            }
            default:
                throw new RestClientErrors.InvalidKeyError(String.format("Invalid keytype value: %s", keyType.toString()));

        }
    }

    private static int getIntegerFromstring(String strKey) {
        try {
            return Integer.parseInt(strKey, 10);
        } catch (NumberFormatException nfe) {
            throw new RestClientErrors.InvalidKeyError(String.format("Invalid integer value: %s", strKey));
        }
    }

    private static long getLongFromstring(String strKey) {
        try {
            return Long.parseLong(strKey, 10);
        } catch (NumberFormatException nfe) {
            throw new RestClientErrors.InvalidKeyError(String.format("Invalid integer value: %s", strKey));
        }
    }

    private static byte[] getByteArrayFromstring(String strKey) {
        try {
            return Base64.getUrlDecoder().decode(strKey);
        } catch (IllegalArgumentException nfe) {
            throw new RestClientErrors.InvalidKeyError(String.format("Unable to decode bytes", strKey));
        }
    }
}
