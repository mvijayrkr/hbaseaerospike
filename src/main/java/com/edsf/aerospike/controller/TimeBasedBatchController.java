package com.edsf.aerospike.controller;

import com.aerospike.client.AerospikeClient;
import com.edsf.aerospike.domain.TimeBasedBatchReadBody;
import com.edsf.aerospike.domain.TimeBasedBatchReadResponse;
import com.edsf.aerospike.service.AerospikeBatchService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeBasedBatchController {
    @Autowired
    private AerospikeBatchService service;
    @Autowired
    private AerospikeClient client;
    @RequestMapping(value = "/edsf/aerospike/v1/timebasedevents", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<TimeBasedBatchReadResponse> getLatestPolicies(@RequestBody TimeBasedBatchReadBody postbody){

        //TODO : CURRENTTIME - 5 MINS NEED TO BE IMPLEMENTED. A Spring Scheduler should be implemented to trigger the job for every 5 mins
        System.out.println("/n Min: " + postbody.mineventtime +"/n Max: "+ postbody.maxeventtime +"/n service: "+ postbody.service);
        System.out.println( "___________________"+ client);

        return service.getpoliciesbasedontimeinterval(client,postbody.mineventtime,postbody.maxeventtime,postbody.service);
    }




}
