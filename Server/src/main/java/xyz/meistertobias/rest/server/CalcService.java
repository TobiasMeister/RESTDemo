package xyz.meistertobias.rest.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("calc")
public class CalcService {
	
	@GET
	@Path("add/{x}/{y}")
	public int add(@PathParam("x") int x, @PathParam("y") int y) {
		return x + y;
	}
	
	@GET
	@Path("subtract/{x}/{y}")
	public int subtract(@PathParam("x") int x, @PathParam("y") int y) {
		return x - y;
	}
	
	@GET
	@Path("multiply/{x}/{y}")
	public int multiply(@PathParam("x") int x, @PathParam("y") int y) {
		return x * y;
	}
	
	@GET
	@Path("divide/{x}/{y}")
	public int divide(@PathParam("x") int x, @PathParam("y") int y) {
		return x / y;
	}
}
