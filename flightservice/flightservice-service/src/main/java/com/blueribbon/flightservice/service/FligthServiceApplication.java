package com.blueribbon.flightservice.service;

import com.blueribbon.commons.logging.SLF4JEnabler;
import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:application-context.xml"
        , "classpath:postgresql-context.xml"
        , "classpath:jwt-context.xml" })
@ComponentScan()
public class FligthServiceApplication {

    public static void main(String[] args) {
        SLF4JEnabler.enable();
        new SpringApplicationBuilder().environment(new StandardEncryptableEnvironment()).sources(FligthServiceApplication.class).run(args);
    }
}
