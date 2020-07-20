package com.edsf.aerospike.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Host;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
public class AerospikeConfig {

   @Value("${aerospike.edsf.hostname:192.168.110.128}")
   String hostname="192.168.110.128";

   @Value("${aerospike.edsf.port:3000}")
    int port=3000;

   // @Value("${aerospike.edsf.hostlist}")
  // String hostList=null;

    //TODO : need to update with ClienPolicyConfig
    @Autowired
    ClientPolicy policy;

    @Bean
    public AerospikeClient aerospikeClient() {
    AerospikeClient client;
    policy = new ClientPolicy();
    policy.failIfNotConnected = true;
  /*  if (hostList != null) {
        client = new AerospikeClient(policy, Host.parseHosts(hostList, port));

    } else {*/
        /* No list of hosts provided, try with a single host name */
        client = new AerospikeClient(policy, hostname, port);
  /*  }*/
    return client;
    }

}
