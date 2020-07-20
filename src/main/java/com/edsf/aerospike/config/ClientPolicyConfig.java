package com.edsf.aerospike.config;
import com.edsf.aerospike.utils.TLSPolicyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aerospike.client.policy.ClientPolicy;
import com.edsf.aerospike.config.TLSPolicyConfig;

@Configuration
public class ClientPolicyConfig {


    /* Client policies */
    @Value("${aerospike.restclient.clientpolicy.user:#{null}}") String username;
    @Value("${aerospike.restclient.clientpolicy.password:#{null}}") String password;
    @Value("${aerospike.restclient.clientpolicy.clusterName:#{null}}") String clusterName;

    @Value("${aerospike.restclient.clientpolicy.connPoolsPerNode:#{null}}")Integer connPoolsPerNode;
    @Value("${aerospike.restclient.clientpolicy.maxConnsPerNode:#{null}}")Integer maxConnsPerNode;
    @Value("${aerospike.restclient.clientpolicy.maxSocketIdle:#{null}}")Integer maxSocketIdle;
    @Value("${aerospike.restclient.clientpolicy.tendInterval:#{null}}")Integer tendInterval;
    @Value("${aerospike.restclient.clientpolicy.timeout:#{null}}")Integer timeout;

    @Value("${aerospike.restclient.clientpolicy.failIfNotConnected:#{null}}")Boolean failIfNotConnected;
    @Value("${aerospike.restclient.clientpolicy.sharedThreadPool:#{null}}")Boolean sharedThreadPool;
    @Value("${aerospike.restclient.clientpolicy.useServicesAlternate:#{null}}")Boolean useServicesAlternate;
    @Value("${aerospike.restclient.clientpolicy.requestProleReplicas:#{null}}")Boolean requestProleReplicas;

    /* Read policies */

    @Bean
   // public ClientPolicy ConfigClientPolicy(@Autowired TLSPolicyBuilder builder) {
    public ClientPolicy ConfigClientPolicy() {
        ClientPolicy clientPolicy = new ClientPolicy();

        if (username != null) {
            clientPolicy.user = username;
        }

        if (password != null) {
            clientPolicy.password = password;
        }

        if (clusterName != null) {
            clientPolicy.clusterName = clusterName;
        }

        if (connPoolsPerNode != null) {
            clientPolicy.connPoolsPerNode = connPoolsPerNode;
        }

        if (maxConnsPerNode != null) {
            clientPolicy.maxConnsPerNode = maxConnsPerNode;
        }

        if (maxSocketIdle != null) {
            clientPolicy.maxSocketIdle = maxSocketIdle;
        }

        if (tendInterval != null) {
            clientPolicy.tendInterval = tendInterval;
        }

        if (timeout != null) {
            clientPolicy.timeout = timeout;
        }

        if (failIfNotConnected != null) {
            clientPolicy.failIfNotConnected = failIfNotConnected;
        }

        if (sharedThreadPool != null) {
            clientPolicy.sharedThreadPool = sharedThreadPool;
        }

        if (useServicesAlternate != null) {
            clientPolicy.useServicesAlternate = useServicesAlternate;
        }
        //Note: for enabling TLS
       // clientPolicy.tlsPolicy = builder.build();

        return clientPolicy;
    }
}
