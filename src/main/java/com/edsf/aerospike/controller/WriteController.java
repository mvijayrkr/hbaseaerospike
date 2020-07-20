package com.edsf.aerospike.controller;

import com.aerospike.client.AerospikeClient;
import com.edsf.aerospike.domain.TimeBasedBatchReadBody;
import com.edsf.aerospike.service.AerospikeBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteController {

    @Autowired
    private AerospikeBatchService service;
    @Autowired
    private AerospikeClient client;
    @RequestMapping(value = "/edsf/aerospike/v1/insertpolicy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public void getLatestPolicies(@RequestBody TimeBasedBatchReadBody postbody){

        //TODO : CURRENTTIME - 5 MINS NEED TO BE IMPLEMENTED. A Spring Scheduler should be implemented to trigger the job for every 5 mins
        System.out.println("/n Min: " + postbody.mineventtime +"/n Max: "+ postbody.maxeventtime +"/n service: "+ postbody.service);
        System.out.println( "___________________"+ client);
        service.getpoliciesbasedontimeinterval(client,postbody.mineventtime,postbody.maxeventtime,postbody.service);


    }
}
