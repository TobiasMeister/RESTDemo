package xyz.meistertobias.rest.server;

import xyz.meistertobias.rest.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("user")
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return users;
	}
	
	@GET
	@Path("get/{nickname}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("nickname") String nickname) {
		return findUser(nickname).orElse(null);
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addUser(User user) {
		String response;
		if (users.contains(user)) {
			response = "Duplicate";
		} else {
			users.add(user);
			response = "Created";
		}
		return Response.ok(response, MediaType.TEXT_PLAIN).build();
	}
	
	@DELETE
	@Path("delete/{nickname}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteUser(@PathParam("nickname") String nickname) {
		var user = findUser(nickname);
		String response;
		if (user.isPresent()) {
			users.remove(user.get());
			response = "Removed";
		} else {
			response = "Not present";
		}
		return Response.ok(response, MediaType.TEXT_PLAIN).build();
	}
	
	private Optional<User> findUser(String nickname) {
		return users.stream().filter(user -> user.getNickname().equals(nickname)).findFirst();
	}
}
