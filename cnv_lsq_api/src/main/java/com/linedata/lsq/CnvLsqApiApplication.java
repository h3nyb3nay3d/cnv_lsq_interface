package com.linedata.lsq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootConfiguration
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class CnvLsqApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CnvLsqApiApplication.class, args);
    }
}
