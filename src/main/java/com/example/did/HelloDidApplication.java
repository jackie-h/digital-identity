package com.example.did;

import com.example.did.resources.HelloDidResource;
import com.example.did.resources.IssuerResource;
import com.example.did.resources.VerifierResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloDidApplication extends Application<HelloDidConfig> {
    public static void main(String[] args) throws Exception {
        new HelloDidApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-did";
    }

    @Override
    public void initialize(Bootstrap<HelloDidConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloDidConfig configuration,
                    Environment environment) {
        final HelloDidResource resource = new HelloDidResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final IssuerResource issuerResource = new IssuerResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final VerifierResource verifierResource = new VerifierResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        environment.jersey().register(issuerResource);
        environment.jersey().register(verifierResource);
    }

}