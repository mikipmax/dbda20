package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.camel.component.consul.ConsulClientConfiguration;

@ApplicationScoped
@ApplicationPath("/")
public class RestApplication extends Application {
	
}
