
module xyz.meistertobias.rest.server {
	
	requires xyz.meistertobias.rest;
	requires jersey.server;
	requires jersey.container.jdk.http;
	requires jdk.httpserver;
	requires java.activation;
	requires java.xml.bind;
	requires javax.ws.rs.api;
	
	exports xyz.meistertobias.rest.server;
}
