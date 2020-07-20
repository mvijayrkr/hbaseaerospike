package com.edsf.aerospike.domain;



import com.aerospike.client.AerospikeException;
import com.edsf.aerospike.utils.RestClientErrors.AerospikeRestClientError;

public class RestClientError {


        //value="A message describing the cause of the error.", example="Error Message"
        private String message;

        //value="A boolean specifying whether it was possible that the operation succeeded. This is only included if true.",required=false, example="false")

        private Boolean inDoubt;

       //value="An internal error code for diagnostic purposes. This may be null", example="-3")
        private Integer internalErrorCode;

        public String getMessage() {
            return message;
        }

        public Boolean getInDoubt() {
            return inDoubt;
        }

        public Integer getInternalErrorCode() {
            return internalErrorCode;
        }

        public RestClientError(AerospikeException ex) {
            this.message = ex.getMessage();
            this.inDoubt = ex.getInDoubt();
            this.internalErrorCode = ex.getResultCode();
        }

        public RestClientError(AerospikeRestClientError ex) {
            this.message = ex.getErrorMessage();
            this.inDoubt = false;
            this.internalErrorCode = null;
        }

        public RestClientError(String message) {
            this.message = message;
            this.inDoubt = false;
            this.internalErrorCode = null;
        }
}
