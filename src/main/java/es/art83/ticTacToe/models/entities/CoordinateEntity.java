package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.utils.DirectionModel;

public class CoordinateEntity {
    public static final int MIN = 0;

    public static final int MAX = 2;

    private int row, column;

    public CoordinateEntity(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
    }

    public CoordinateEntity(String coordenada) {
        String[] campos = coordenada.split("-");
        this.row = Integer.valueOf(campos[0]);
        this.column = Integer.valueOf(campos[1]);
    }

    public CoordinateEntity() {
        this(0, 0);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public static List<CoordinateEntity> allCoordinates() {
        List<CoordinateEntity> coordenadas = new ArrayList<>();
        for (int i = MIN; i < MAX + 1; i++) {
            for (int j = MIN; j < MAX + 1; j++) {
                coordenadas.add(new CoordinateEntity(i, j));
            }
        }
        return coordenadas;
    }

    public DirectionModel direccion(CoordinateEntity otra) {
        if (this.getRow() == otra.getRow()) {
            return DirectionModel.EN_FILA;
        } else if (this.getColumn() == otra.getColumn()) {
            return DirectionModel.EN_COLUMNA;
        } else if (this.getColumn() == this.getRow() && otra.getColumn() == otra.getColumn()) {
            return DirectionModel.EN_DIAGONAL_PRINCIPAL;
        } else if (this.getColumn() + this.getRow() == MAX
                && otra.getColumn() + otra.getRow() == MAX) {
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
        return this.column == other.column && this.row == other.row;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getColumn();
        result = prime * result + this.getRow();
        return result;
    }

    @Override
    public String toString() {
        return row + "-" + column ;
    }

}
