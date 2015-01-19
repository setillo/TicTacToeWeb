package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class ShowGameControllerWSClient extends ControllerWSClient implements ShowGameController {

    public ShowGameControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public String getNameGame() {
        WebTarget target = this.webTargetContext().path("game").path("name");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(String.class); // response.close()
    }

    @Override
    public ColorModel[][] completeBoard() {
        WebTarget target = this.webTargetContext().path("game").path("allPieces");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        List<PieceEntity> allPieces= response.readEntity(new GenericType<List<PieceEntity>>() {
        });
        
        ColorModel[][] matriz = new ColorModel[3][3];
        for (PieceEntity ficha : allPieces) {
            matriz[ficha.getCoordinate().getRow()][ficha.getCoordinate().getColumn()] = ficha
                    .getColor();
        }
        return matriz;
    }

    @Override
    public boolean isGameOver() {
        WebTarget target = this.webTargetContext().path("gameOver");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return Boolean.valueOf(response.readEntity(String.class)); // response.close()
    }

    @Override
    public ColorModel winner() {
        WebTarget target = this.webTargetContext().path("game").path("winner");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(ColorModel.class); // response.close()
    }

    @Override
    public boolean isSavedGame() {
        WebTarget target = this.webTargetContext().path("savedGame");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return Boolean.valueOf(response.readEntity(String.class)); // response.close()
    }

    @Override
    public ColorModel turnColor() {
        WebTarget target = this.webTargetContext().path("game").path("turnColor");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(ColorModel.class); // response.close()
    }

    @Override
    public boolean isFullBoard() {
        WebTarget target = this.webTargetContext().path("fullBoard");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return Boolean.valueOf(response.readEntity(String.class)); // response.close()
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        WebTarget target = this.webTargetContext().path("game").path("validSourceCoordinates");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(new GenericType<List<CoordinateEntity>>() {
        });
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        WebTarget target = this.webTargetContext().path("game").path("validDestinationCoordinates");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(new GenericType<List<CoordinateEntity>>() {
        });
    }

    @Override
    public boolean createdGame() {
        WebTarget target = this.webTargetContext().path("createdGame");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return Boolean.valueOf(response.readEntity(String.class)); // response.close()
    }

}
