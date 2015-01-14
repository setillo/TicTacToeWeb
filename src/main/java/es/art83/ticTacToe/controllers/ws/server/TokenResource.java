package es.art83.ticTacToe.controllers.ws.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;

@Path("/tokens")
public class TokenResource {
    
    //LoginController.login
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(PlayerEntity playerEntity){
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO().read(playerEntity.getUser());
        if (playerEntityBD != null && playerEntityBD.getPassword().equals(playerEntity.getPassword())) {
            
        }

        return null;
    }

}
