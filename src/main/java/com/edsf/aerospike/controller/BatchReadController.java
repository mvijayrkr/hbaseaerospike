package com.edsf.aerospike.controller;
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.Policy;
import com.edsf.aerospike.service.AerospikeBatchService;
import com.edsf.aerospike.utils.AerospikeAPIConstants;
import com.edsf.aerospike.utils.PolicyConverter;
import com.edsf.aerospike.utils.RestClientErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerospike.client.policy.BatchPolicy;
import com.edsf.aerospike.domain.RestClientBatchReadBody;
import com.edsf.aerospike.domain.RestClientBatchReadResponse;
import com.edsf.aerospike.domain.RestClientError;
import com.edsf.aerospike.service.AerospikeBatchService;
import com.edsf.aerospike.utils.RequestParamHandler;
import com.aerospike.client.policy.InfoPolicy;

import java.util.List;
import java.util.Map;

import static com.edsf.aerospike.utils.PolicyValueConverter.getBoolValue;
import static com.edsf.aerospike.utils.PolicyValueConverter.getIntValue;

/*
Batch Read Operations ==> description="Retrieve multiple records from the server."

 */
@RestController
@RequestMapping("/v1/batch")
public class BatchReadController {

    @Autowired
    private AerospikeBatchService service;
    @Autowired
    private RequestParamHandler reqParam;

   @RequestMapping(method=RequestMethod.POST, consumes={"application/json", "application/msgpack"}, produces={"application/json", "application/msgpack"})
    public List<RestClientBatchReadResponse> performBatchGet(@RequestBody List<RestClientBatchReadBody> batchKeys,
                                                             @RequestParam Map<String, String> requestParams) {

        BatchPolicy policy = RequestParamHandler.getBatchPolicy(requestParams);

        return service.batchGet(batchKeys, policy);
    }
}
