package com.ijayakantha.springeurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaClientApplication.class, args);
    }
}

@RestController
class EurekaClientRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/clients/{applicationName}")
    public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName).get(0).getUri().toString();
    }
}
