package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.utils.DirectionModel;

public class CoordinateEntity {
    public static final int MIN = 0;

    public static final int MAX = 2;

    private int id;

    private int fila, columna;

    public CoordinateEntity(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public CoordinateEntity(String coordenada) {
        String[] campos = coordenada.split("-");
        this.fila = Integer.valueOf(campos[0]);
        this.columna = Integer.valueOf(campos[1]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public static List<CoordinateEntity> posibles() {
        List<CoordinateEntity> coordenadas = new ArrayList<>();
        for (int i = MIN; i < MAX + 1; i++) {
            for (int j = MIN; j < MAX + 1; j++) {
                coordenadas.add(new CoordinateEntity(i, j));
            }
        }
        return coordenadas;
    }

    public DirectionModel direccion(CoordinateEntity otra) {
        if (this.getFila() == otra.getFila()) {
            return DirectionModel.EN_FILA;
        } else if (this.getColumna() == otra.getColumna()) {
            return DirectionModel.EN_COLUMNA;
        } else if (this.getColumna() == this.getFila() && otra.getColumna() == otra.getColumna()) {
            return DirectionModel.EN_DIAGONAL_PRINCIPAL;
        } else if (this.getColumna() + this.getFila() == MAX
                && otra.getColumna() + otra.getFila() == MAX) {
            return DirectionModel.EN_DIAGONAL_SECUNDARIA;
        } else {
            return DirectionModel.SIN_DIRECION;
        }
    }

    public DirectionModel direccion(CoordinateEntity[] coordenadas) {
        DirectionModel dir = this.direccion(coordenadas[0]);
        for (CoordinateEntity coor : coordenadas) {
            if (dir != this.direccion(coor))
                return DirectionModel.SIN_DIRECION;
        }
        return dir;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        CoordinateEntity other = (CoordinateEntity) obj;
        return this.getColumna() == other.getColumna() && this.getFila() == other.getFila();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getColumna();
        result = prime * result + this.getFila();
        return result;
    }

    @Override
    public String toString() {
        return fila + "-" + columna;
    }

}
