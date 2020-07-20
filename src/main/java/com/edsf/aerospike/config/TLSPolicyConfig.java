package com.edsf.aerospike.config;

import com.edsf.aerospike.utils.TLSPolicyBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TLSPolicyConfig {
    @Value("${aerospike.edsf.ssl.enabled:#{false}}") private Boolean enabled;
    @Value("${aerospike.edsf.ssl.keystorepath:#{null}}") private String keystorePath;
    @Value("${aerospike.edsf.ssl.keystorepassword:#{null}}") private String keystorePassword;
    @Value("${aerospike.edsf.ssl.keypassword:#{null}}") private String keyPassword;

    @Value("${aerospike.edsf.ssl.truststorepath:#{null}}") private String truststorePath;
    @Value("${aerospike.edsf.ssl.truststorepassword:#{null}}") private String truststorePassword;

    @Value("${aerospike.edsf.ssl.forloginonly:#{false}}") private Boolean forLoginOnly;

    @Value("${aerospike.edsf.ssl.allowedciphers:#{null}}") private List<String> allowedCiphers;
    @Value("${aerospike.edsf.ssl.allowedprotocols:#{null}}") private List<String> allowedProtocols;

    @Bean
    public TLSPolicyBuilder ConfigTLSPolicyBuilder() {
        return new TLSPolicyBuilder(
                enabled,
                keystorePath,
                keystorePassword == null ? null : keystorePassword.toCharArray(),
                keyPassword == null ? null : keyPassword.toCharArray(),
                truststorePath,
                truststorePassword == null ? null : truststorePassword.toCharArray(),
                allowedCiphers,
                allowedProtocols,
                forLoginOnly);
    }
}

