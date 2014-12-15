package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class WebService {
    private static final String URI = "http://localhost:8080/TicTacToe/rest";

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean post(String path, Object param) {
        Client client = Client.create(new DefaultClientConfig());
        WebResource webResource = client.resource(UriBuilder.fromUri(URI).build());
        webResource = webResource.path(path);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(
                ClientResponse.class, param);
        LogManager.getLogger(LoginControllerWSClient.class).info("POST/" + response.getStatus());
        return response.getStatus() == 201;
    }

    public Object get(String path, Class<?> clazz) {
        Client client = Client.create(new DefaultClientConfig());

        WebResource webResource = client.resource(UriBuilder.fromUri(URI).build());
        webResource = webResource.path(path); // para añadir path
        webResource = webResource.queryParam("token", this.token); // añade
                                                                   // parámetros

        Builder response = webResource.accept(MediaType.APPLICATION_JSON);
        LogManager.getLogger(LoginControllerWSClient.class).info(
                "GET/" + response.head().getStatus());
        return (Class<?>) response.get(clazz);
    }

    public boolean delete(String path) {
        Client client = Client.create(new DefaultClientConfig());
        WebResource webResource = client.resource(UriBuilder.fromUri(URI).build());
        webResource = webResource.path(path); // para añadir path

        int response = webResource.delete(ClientResponse.class).getStatus();
        LogManager.getLogger(LoginControllerWSClient.class).info("DELETE/" + response);
        return response == 201;
    }

}
