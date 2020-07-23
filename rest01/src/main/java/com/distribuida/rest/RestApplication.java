package com.distribuida.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//Esta clase sirve para registrar recursos Rest
@ApplicationPath("/")
//Toda aplicacion Rest debe extender de Application de jax.ws
public class RestApplication extends Application{

}
