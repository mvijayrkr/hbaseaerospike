package com.edsf.aerospike.domain;
import java.util.Base64;
import java.util.Base64.Encoder;

import com.aerospike.client.Key;
import com.aerospike.client.Value.BytesValue;
import com.aerospike.client.Value.IntegerValue;
import com.aerospike.client.Value.LongValue;
import com.aerospike.client.Value.StringValue;
import com.edsf.aerospike.utils.AerospikeAPIConstants.RecordKeyType;
import com.edsf.aerospike.utils.KeyBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
public class RestClientKey {

       //required=true, example="testNS")
        public String namespace;

        @JsonProperty(value="setName")
       //example="testSet")
        public String setName;

        @JsonProperty(required=false, value="digest")
       //value="URL safe base64 encoded key digest. Returned by the server on batch responses. May be provided by client.",                example="AAAAAAAAAAAAAAAAAAAAAAAAAAA=")
        public String digest;

        @JsonProperty(value="keytype")
       //value="Enum describing the type of the userKey. This field is omitted in MessagePack responses.", example="STRING")
        public RecordKeyType keytype;

       //value="The user key, it may be a string, integer, or URL safe Base64 encoded bytes.", example="userKey")
        public Object userKey;

        public RestClientKey() {}

        public RestClientKey(Key realKey) {
            Encoder encoder = Base64.getUrlEncoder();
            namespace = realKey.namespace;
            setName = realKey.setName;
            digest = encoder.encodeToString(realKey.digest);

            if (realKey.userKey != null) {
                if (realKey.userKey instanceof StringValue) {
                    userKey = realKey.userKey.toString();
                    keytype = RecordKeyType.STRING;
                } else if (realKey.userKey instanceof IntegerValue || realKey.userKey instanceof LongValue) {
                    userKey = (long)realKey.userKey.getObject();
                    keytype = RecordKeyType.INTEGER;
                } else if(realKey.userKey instanceof BytesValue) {
                    userKey = encoder.encodeToString((byte[])realKey.userKey.getObject());
                    keytype = RecordKeyType.BYTES;
                }
            } else {
                userKey = encoder.encodeToString(realKey.digest);
                keytype = RecordKeyType.DIGEST;
            }
            digest = encoder.encodeToString(realKey.digest);
        }

        public Key toKey() {
            return KeyBuilder.buildKey(namespace, setName, userKey.toString(), keytype);
        }
}
