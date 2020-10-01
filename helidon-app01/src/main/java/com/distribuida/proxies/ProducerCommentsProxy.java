package com.distribuida.proxies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class ProducerCommentsProxy {
	public static final String URL = "https://jsonplaceholder.typicode.com/comments";
	public static final String URL1 = "http://localhost:8080/posts";
	@ApplicationScoped
	@Produces
	public CommentsProxy produceProxy() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL);
		return target.proxy(CommentsProxy.class);
	}
	@ApplicationScoped
	@Produces
	public PostsProxy produceProxy1() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL1);
		return target.proxy(PostsProxy.class);
	}
}
