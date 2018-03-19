package xyz.meistertobias.rest.server;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import xyz.meistertobias.rest.Config;

import java.net.URI;
import java.net.URISyntaxException;

public class ServerUI {
	
	public static void main(String[] args) {
		try {
			var uri = new URI("http://127.0.0.1:" + Config.DEFAULT_PORT + "/rest");
			var resourceConfig = new ResourceConfig(CalcService.class, UserService.class);
			JdkHttpServerFactory.createHttpServer(uri, resourceConfig);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
