package es.art83.ticTacToe.controllers.ws.server;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;

@Path("/players")
public class PlayerResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(PlayerEntity playerEntity){
        Response result = Response.status(Response.Status.CONFLICT).build();
        PlayerEntity playerBD = DAOFactory.getFactory().getPlayerDAO().read(playerEntity.getUser());
        if (playerBD == null) {
            DAOFactory.getFactory().getPlayerDAO().create(playerEntity);
            result = Response.created(URI.create("/players/"+playerEntity.getUser())).entity(playerEntity).build();;
            LogManager.getLogger(PlayerResource.class).info("POST/ player_id: " + playerEntity.getUser());
        }
        return result;
    }
}
