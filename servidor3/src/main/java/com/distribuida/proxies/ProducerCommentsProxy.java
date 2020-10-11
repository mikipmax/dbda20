package com.distribuida.proxies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class ProducerCommentsProxy {
	public static  String URL = "https://jsonplaceholder.typicode.com/comments";
	public static  String URL2 = "https://jsonplaceholder.typicode.com/posts";
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
		ResteasyWebTarget target = cliente.target(URL2);
		return target.proxy(PostsProxy.class);
	}
}
