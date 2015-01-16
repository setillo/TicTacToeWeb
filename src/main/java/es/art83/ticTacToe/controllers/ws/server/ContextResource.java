package es.art83.ticTacToe.controllers.ws.server;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.ContextEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path("/contexts")
public class ContextResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String msg() {
        LogManager.getLogger(ContextResource.class).info("GET/ Hello");
        return ">>>Hola, desde RESTful";
    }

    //FactoryController ---------- ---------- ---------- ---------- ---------- ----------
    @POST
    public Response create() {
        ContextEntity contextEntity = new ContextEntity();
        DAOFactory.getFactory().getContextDAO().create(contextEntity);
        LogManager.getLogger(ContextResource.class).info(
                "POST/ context_id: " + contextEntity.getId());
        return Response.created(URI.create("/contexts/" + contextEntity.getId()))
                .entity(contextEntity.getId()).build();
    }

    //LoginController ---------- ---------- ---------- ---------- ---------- ----------
    @Path("/{id}/player")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPlayer(@PathParam("id") Integer id, PlayerEntity playerEntity) {
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO()
                .read(playerEntity.getUser());
        if (playerEntityBD != null
                && playerEntityBD.getPassword().equals(playerEntity.getPassword())) {
            ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
            if (contextEntity != null) {
                contextEntity.setPlayer(playerEntityBD);
                contextEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
                DAOFactory.getFactory().getContextDAO().update(contextEntity);
                LogManager.getLogger(ContextResource.class).info(
                        "POST/" + contextEntity.getId() + "/player");
                return Response.created(
                        URI.create("/contexts/" + contextEntity.getId() + "/player")).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @Path("/{id}/logged")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String logged(@PathParam("id") Integer id) {
        ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (contextEntity != null) {
            Boolean result = contextEntity.getPlayer() != null;
            LogManager.getLogger(ContextResource.class).info(
                    "GET/" + contextEntity.getId() + "/logged: " + result);
            return Boolean.toString(result);
        } else {
            throw new NotFoundException("Context (" + id + ") no existe");
        }
    }

    //LogoutController ---------- ---------- ---------- ---------- ---------- ----------
    @Path("/{id}/player")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePlayer(@PathParam("id") Integer id, PlayerEntity playerEntity) {
        ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (contextEntity != null) {
            contextEntity.setPlayer(null);
            contextEntity.setGame(null);
            contextEntity.setSaved(true);
            contextEntity.setTicTacToeStateModel(TicTacToeStateModel.FINAL);
            DAOFactory.getFactory().getContextDAO().update(contextEntity);
            LogManager.getLogger(PlayerResource.class).info(
                    "DELETE/" + contextEntity.getId() + "/player...");
        }
    }


    @Path("/{id}/isBye")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isBye(@PathParam("id") Integer id) {
        ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (contextEntity != null) {
            Boolean result = contextEntity.getTicTacToeStateModel().equals(
                    TicTacToeStateModel.FINAL);
            LogManager.getLogger(ContextResource.class).info(
                    "GET/" + contextEntity.getId() + "/isBye: " + result);
            return Boolean.toString(result);
        } else {
            throw new NotFoundException("Context (" + id + ") no existe");
        }
    }

    @Path("/{id}/savedGame")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String savedGame(@PathParam("id") Integer id) {
        ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (contextEntity != null) {
            Boolean result = contextEntity.isSavedGame();
            LogManager.getLogger(ContextResource.class).info(
                    "GET/" + contextEntity.getId() + "/savedGame " + result);
            return Boolean.toString(result);
        } else {
            throw new NotFoundException("Context (" + id + ") no existe");
        }
    }

    //CreateGameController ---------- ---------- ---------- ---------- ---------- ----------
    @Path("/{id}/game")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createGame(@PathParam("id") Integer id) {
        ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (contextEntity != null) {
            if (contextEntity.getPlayer() != null) {
                GameEntity gameEntity = new GameEntity(contextEntity.getPlayer());
                contextEntity.setGame(gameEntity);
                contextEntity.setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
                DAOFactory.getFactory().getContextDAO().update(contextEntity);
                LogManager.getLogger(ContextResource.class).info(
                        "POST/" + contextEntity.getId() + "/game");
                return Response.created(URI.create("/contexts/" + contextEntity.getId() + "/game"))
                        .build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
