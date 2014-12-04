package es.art83.ticTacToe.models.entities;

import es.art83.ticTacToe.models.utils.ColorModel;


public class PieceEntity {

    private int id;

    private ColorModel color;

    private CoordinateEntity coordenada;

    public PieceEntity(ColorModel color, CoordinateEntity coordenada) {
        super();
        this.color = color;
        this.coordenada = coordenada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ColorModel getColor() {
        return color;
    }

    public CoordinateEntity getCoordenada() {
        return coordenada;
    }

    @Override
    public String toString() {
        return "Ficha[" + color + "-" + coordenada + "]";
    }

}
