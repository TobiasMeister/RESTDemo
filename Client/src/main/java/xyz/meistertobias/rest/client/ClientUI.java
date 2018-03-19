package xyz.meistertobias.rest.client;

import xyz.meistertobias.rest.Config;
import xyz.meistertobias.rest.User;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.util.List;

public class ClientUI {
	
	public static void main(String[] args) {
		var client = ClientBuilder.newClient().target("http://127.0.0.1:" + Config.DEFAULT_PORT + "/rest");
		
		// REST: calc
		{
			// GET: calc/add
			var target = client.path("calc/add").path("5").path("9");
			System.out.println(target.request().get(Integer.class));
			
			// GET: calc/subtract
			target = client.path("calc/subtract").path("5").path("9");
			System.out.println(target.request().get(Integer.class));
			
			// GET: calc/multiply
			target = client.path("calc/multiply").path("5").path("9");
			System.out.println(target.request().get(Integer.class));
			
			// GET: calc/divide
			target = client.path("calc/divide").path("5").path("9");
			System.out.println(target.request().get(Integer.class));
		}
		
		System.out.println();
		
		// REST: user
		{
			// POST: user/add
			var target = client.path("user/add");
			var user = new User("Marcel", "Davis", "Leiter für Kundenzufriedenheit");
			System.out.println(target.request().post(Entity.json(user), String.class));
			
			// GET: user/all -> List<User>
			target = client.path("user/all");
			System.out.println(target.request().get(List.class));
			
			// GET: user/get/{nickname} -> User
			target = client.path("user/get").path("Leiter für Kundenzufriedenheit");
			System.out.println(target.request().get(User.class));
			
			// DELETE: user/delete/{nickname}
			target = client.path("user/delete").path("Leiter für Kundenzufriedenheit");
			System.out.println(target.request().delete(String.class));
		}
	}
}
