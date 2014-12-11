package es.art83.ticTacToe.models.entities;

import es.art83.ticTacToe.models.utils.ColorModel;

public class PieceEntity {

    private ColorModel color;

    private CoordinateEntity coordinate;

    public PieceEntity(ColorModel color, CoordinateEntity coordinate) {
        this.setColor(color);
        this.setCoordinate(coordinate);
    }

    public PieceEntity() {
        this(null, null);
    }

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    public CoordinateEntity getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinateEntity coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Piece[" + color + "-" + coordinate + "]";
    }

}
