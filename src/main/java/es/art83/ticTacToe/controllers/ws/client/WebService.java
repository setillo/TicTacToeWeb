package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;


public class WebService {
    private static final String URI = "http://localhost:8080/TicTacToe/rest";

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public boolean post(String resource, Object entity) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URI);
        webTarget = webTarget.path("{resource}").resolveTemplate("resource", resource);

        if (this.token != null) {
            webTarget = webTarget.queryParam("token", this.token);
        }
        
        Response response = webTarget.request().post(Entity.json(entity));

        LogManager.getLogger(LoginControllerWSClient.class).info("POST/" + response.getStatus());
        
        boolean result = response.getStatus() == 201;

        client.close();
        return result;
    }

    public Object get(String resource, Class<?> ResponseClass) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URI);
        webTarget = webTarget.path("{resource}").resolveTemplate("resource", resource);

        if (this.token != null) {
            webTarget = webTarget.queryParam("token", this.token);
        }

        Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
        
        Object result = invocation.get(ResponseClass);
        
        LogManager.getLogger(LoginControllerWSClient.class).info(
                "GET/" + result);
        
        client.close();
        return result;
    }

    public List<?> gets(String resource) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URI);
        webTarget = webTarget.path("{resource}").resolveTemplate("resource", resource);

        if (this.token != null) {
            webTarget = webTarget.queryParam("token", this.token);
        }

        Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
        
        List<?> result = invocation.get(new GenericType<List<?>>() {});
        
        LogManager.getLogger(LoginControllerWSClient.class).info(
                "GET/" + result);
        
        client.close();
        return result;
    }

    public void delete(String resource) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URI);
        webTarget = webTarget.path("{resource}").resolveTemplate("resource", resource);

        if (this.token != null) {
            webTarget = webTarget.queryParam("token", this.token);
        }
        
        Response response = webTarget.request().delete();

        LogManager.getLogger(LoginControllerWSClient.class).info("DELETE/" + response.getStatus());
    }

    public Boolean put(String resource, Object entity) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URI);
        webTarget = webTarget.path("{resource}").resolveTemplate("resource", resource);

        if (this.token != null) {
            webTarget = webTarget.queryParam("token", this.token);
        }
        
        Response response = webTarget.request().put(Entity.json(entity));

        LogManager.getLogger(LoginControllerWSClient.class).info("POST/" + response.getStatus());
        
        boolean result = response.getStatus() == 201;

        client.close();
        return result;
    }

}
