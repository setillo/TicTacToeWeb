package es.art83.ticTacToe.controllers.ws.server;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
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
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
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

    private ContextEntity readContextEntity(Integer id) {
        ContextEntity contextEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (contextEntity != null) {
            return contextEntity;
        } else {
            throw new NotFoundException("Context (" + id + ") no existe");
        }
    }

    // FactoryController ---------- ---------- ---------- ---------- ----------
    @POST
    public Response create() {
        ContextEntity contextEntity = new ContextEntity();
        DAOFactory.getFactory().getContextDAO().create(contextEntity);
        LogManager.getLogger(ContextResource.class).info(
                "POST/ context_id: " + contextEntity.getId());
        return Response.created(URI.create("/contexts/" + contextEntity.getId()))
                .entity(contextEntity.getId()).build();
    }

    // LoginController ---------- ---------- ---------- ---------- ----------
    @Path("/{id}/player")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPlayer(@PathParam("id") Integer id, PlayerEntity playerEntity) {
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO()
                .read(playerEntity.getUser());
        if (playerEntityBD != null
                && playerEntityBD.getPassword().equals(playerEntity.getPassword())) {
            ContextEntity contextEntity = this.readContextEntity(id);
            contextEntity.setPlayer(playerEntityBD);
            contextEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
            DAOFactory.getFactory().getContextDAO().update(contextEntity);
            LogManager.getLogger(ContextResource.class).info(
                    "POST/" + contextEntity.getId() + "/player");
            return Response.created(URI.create("/contexts/" + contextEntity.getId() + "/player"))
                    .build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @Path("/{id}/logged")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String logged(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        Boolean result = contextEntity.getPlayer() != null;
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/logged: " + result);
        return Boolean.toString(result);
    }

    // LogoutController ---------- ---------- ---------- ---------- ----------
    @Path("/{id}/player")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePlayer(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        contextEntity.setPlayer(null);
        contextEntity.setGame(null);
        contextEntity.setSaved(true);
        contextEntity.setTicTacToeStateModel(TicTacToeStateModel.FINAL);
        DAOFactory.getFactory().getContextDAO().update(contextEntity);
        LogManager.getLogger(PlayerResource.class).info(
                "DELETE/" + contextEntity.getId() + "/player...");
    }

    @Path("/{id}/isBye")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isBye(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        Boolean result = contextEntity.getTicTacToeStateModel().equals(TicTacToeStateModel.FINAL);
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/isBye: " + result);
        return Boolean.toString(result);
    }

    // +++ CreateGameController
    @Path("/{id}/savedGame")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String savedGame(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        Boolean result = contextEntity.isSavedGame();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/savedGame " + result);
        return Boolean.toString(result);
    }

    // CreateGameController ---------- ---------- ---------- ----------
    // ++ OpenController
    @Path("/{id}/game")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createGame(@PathParam("id") Integer id, String gameNameSelected) {
        ContextEntity contextEntity = this.readContextEntity(id);
        if (contextEntity.getPlayer() != null) {
            GameEntity gameEntity;
            if (gameNameSelected != null) {
                gameEntity = DAOFactory.getFactory().getGameDAO()
                        .findGame(contextEntity.getPlayer(), gameNameSelected);
            } else {
                gameEntity = new GameEntity(contextEntity.getPlayer());
            }
            contextEntity.setGame(gameEntity);
            contextEntity.setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
            contextEntity.setSaved(true);
            DAOFactory.getFactory().getContextDAO().update(contextEntity);
            LogManager.getLogger(ContextResource.class).info(
                    "POST/" + contextEntity.getId() + "/game");
            return Response.created(URI.create("/contexts/" + contextEntity.getId() + "/game"))
                    .build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    // CreateGameController ---------- ---------- ---------- ----------
    @Path("/{id}/game/name")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String gameName(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        String result = contextEntity.getGame().getName();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/game/name " + result);
        return result;
    }

    @Path("/{id}/game/allPieces")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<PieceEntity> allPieces(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        List<PieceEntity> result = contextEntity.getGame().allPieces();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/game/allPieces " + result);
        return result;
    }

    @Path("/{id}/gameOver")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isGameOver(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        Boolean result = contextEntity.getGame().isGameOver();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/gameOver " + result);
        return Boolean.toString(result);
    }

    @Path("/{id}/game/winner")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel gameWinner(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        ColorModel result = contextEntity.getGame().winner();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/game/name " + result);
        return result;
    }

    @Path("/{id}/game/turnColor")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel turnColor(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        ColorModel result = contextEntity.getGame().turnColor();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/game/turnColor " + result);
        return result;
    }

    @Path("/{id}/fullBoard")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isFullBoard(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        Boolean result = contextEntity.getGame().isFullBoard();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/fullBoard " + result);
        return Boolean.toString(result);
    }

    @Path("/{id}/game/validSourceCoordinates")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validSourceCoordinates(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        List<CoordinateEntity> result = contextEntity.getGame().validSourceCoordinates();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/game/validSourceCoordinates " + result);
        return result;
    }

    @Path("/{id}/game/validDestinationCoordinates")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validDestinationCoordinates(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        List<CoordinateEntity> result = contextEntity.getGame().validDestinationCoordinates();
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/game/validDestinationCoordinates " + result);
        return result;
    }

    @Path("/{id}/createdGame")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String createdGame(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        Boolean result = contextEntity.getTicTacToeStateModel().equals(
                TicTacToeStateModel.OPENED_GAME)
                || contextEntity.getGame() != null;
        LogManager.getLogger(ContextResource.class).info(
                "GET/" + contextEntity.getId() + "/createdGame " + result);
        return Boolean.toString(result);
    }

    // NameController ---------- ---------- ---------- ----------
    @Path("/{id}/nameGames")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<String> nameGames(@PathParam("id") Integer id) {
        ContextEntity contextEntity = this.readContextEntity(id);
        return DAOFactory.getFactory().getGameDAO().findPlayerGameNames(contextEntity.getPlayer());
    }

    // PlaceController ---------- ---------- ---------- ----------
    @Path("/{id}/piece")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPiece(@PathParam("id") Integer id, CoordinateEntity coordinateEntity) {
        ContextEntity contextEntity = this.readContextEntity(id);
        contextEntity.getGame().placeCard(coordinateEntity);
        if (contextEntity.getGame().isGameOver()) {
            contextEntity.setSaved(true);
            contextEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
        } else {
            contextEntity.setSaved(false);
        }
        DAOFactory.getFactory().getContextDAO().update(contextEntity);
        LogManager.getLogger(ContextResource.class)
                .info("POST/" + contextEntity.getId() + "/piece");
        return Response.created(
                URI.create("/contexts/" + contextEntity.getId() + "/piece/"
                        + coordinateEntity.getId())).build();
    }

    @Path("/{id}/piece")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePiece(@PathParam("id") Integer id, @MatrixParam("description") int row,
            @MatrixParam("atributo") int column) {
        ContextEntity contextEntity = this.readContextEntity(id);
        contextEntity.getGame().deleteCard(new CoordinateEntity(row, column));
    }

    // SaveController ---------- ---------- ---------- ----------
    @Path("/{id}/game/id")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Integer gameId(@PathParam("id") Integer id){
        ContextEntity contextEntity = this.readContextEntity(id);
        return contextEntity.getGame().getId();
    }
    

    
}
