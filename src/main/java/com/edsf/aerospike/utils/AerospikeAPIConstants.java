package com.edsf.aerospike.utils;

public class AerospikeAPIConstants {
    private AerospikeAPIConstants() {}

    //Entries in the JSON representation of a record;
    public static final String RECORD_KEY = "key";
    public static final String RECORD_BINS = "bins";
    public static final String RECORD_GENERATION = "generation";
    public static final String RECORD_EXPIRATION = "expiration";
    public static final String RECORD_TTL = "ttl";

    // Entries in a JSON representation of a key
    public static final String PRIMARY_KEY = "pk";
    public static final String USER_KEY = "userKey";
    public static final String NAMESPACE = "namespace";
    public static final String SET = "set";
    public static final String SETNAME = "setName";
    public static final String DIGEST = "digest";
    public static final String TYPE = "type";

    // Key types
    public static final String STRING_KEY = "string";
    public static final String INT_KEY = "integer";
    public static final String BYTES_KEY = "bytes";
    public static final String DIGEST_KEY = "digest";
    public static final String KEY_TYPE = "keytype";

    //Index Types
    public static final String NUMERIC_INDEX = "numeric";
    public static final String STRING_INDEX = "string";
    public static final String GEO2DSPHERE = "geo";

    //Collection Types
    public static final String MAPKEYS_INDEX = "mapkeys";
    public static final String MAPVALUES_INDEX = "mapvalues";
    public static final String LIST_INDEX = "list";

    //POLICY KEYS
    public static final String TOTAL_TIMEOUT = "totalTimeout";
    public static final String SOCKET_TIMEOUT = "socketTimeout";
    public static final String SLEEP_BETWEEN_RETRIES = "sleepBetweenRetries";
    public static final String SEND_KEY = "sendKey";
    public static final String REPLICA = "replica";
    public static final String PRIORITY = "priority";
    public static final String MAX_RETRIES = "maxRetries";
    public static final String LINEARIZE_READ = "linearizeRead";
    public static final String CONSISTENCY_LEVEL = "consistencyLevel";
    public static final String READ_MODE_AP = "readModeAP";
    public static final String READ_MODE_SC = "readModeSC";
    public static final String PRED_EXP = "predexp";
    public static final String COMPRESS = "compress";

    //WRITE POLICY KEYS
    public static final String COMMIT_LEVEL = "commitLevel";
    public static final String DURABLE_DELETE = "durableDelete";
    public static final String EXPIRATION = "expiration";
    public static final String GENERATION = "generation";
    public static final String GENERATION_POLICY = "generationPolicy";
    public static final String RECORD_EXISTS_ACTION = "recordExistsAction";
    public static final String RESPOND_ALL_OPS = "respondAllOps";

    //BATCH POLICY KEYS
    public static final String ALLOW_INLINE = "allowInline";
    public static final String MAX_CONCURRENT_THREADS = "maxConcurrentThreads";
    public static final String SEND_SET_NAME = "sendSetName";
    public static final String USE_BATCH_DIRECT = "useBatchDirect";

    //INFO POLICY KEYS
    public static final String TIMEOUT = "timeout";

    //Operation Fields
    public static final String OPERATION_FIELD = "operation";
    public static final String OPERATION_VALUES_FIELD = "opValues";

    public enum RecordKeyType {
        STRING, INTEGER, BYTES, DIGEST
    }
}
