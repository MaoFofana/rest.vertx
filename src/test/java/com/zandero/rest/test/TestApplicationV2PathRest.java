package com.zandero.rest.test;

import com.zandero.rest.data.RouteDefinition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

/**
 *
 */
@Path("/application")
public class TestApplicationV2PathRest extends RestApplicationV2 {

	@Path("/echo/{param}")
	@GET
	public String echo(
		@Context RouteDefinition definition,
		@PathParam("param") String param) {

		return "2" + param;
	}
}
