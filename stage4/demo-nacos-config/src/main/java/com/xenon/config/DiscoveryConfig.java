package com.xenon.config;

import jdk.jfr.DataAmount;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@DataAmount
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.nacos.discovery")
public class DiscoveryConfig {
    private String username;
    private String password;
    private String serverAddr;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }
}
