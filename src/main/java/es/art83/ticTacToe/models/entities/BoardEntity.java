package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.DirectionModel;

public class BoardEntity {
    private List<PieceEntity> pieces;

    public BoardEntity() {
        this(new ArrayList<>());
    }

    public BoardEntity(List<PieceEntity> list) {
        this.setPieces(list);
    }

    public List<PieceEntity> getPieces() {
        return this.pieces;
    }

    public void setPieces(List<PieceEntity> pieces) {
        this.pieces = pieces;
    }

    public List<CoordinateEntity> coordenadasDestinosValidas() {
        List<CoordinateEntity> vacias = CoordinateEntity.allCoordinates();
        for (PieceEntity ficha : pieces) {
            vacias.remove(ficha.getCoordinate());
        }
        return vacias;
    }

    public List<CoordinateEntity> coordenadasColor(ColorModel color) {
        List<CoordinateEntity> coordenadas = new ArrayList<>();
        for (PieceEntity ficha : this.pieces) {
            if (ficha.getColor().equals(color))
                coordenadas.add(ficha.getCoordinate());
        }
        return coordenadas;
    }

    public void poner(PieceEntity ficha) {
        this.pieces.add(ficha);
    }

    public boolean hayTER(ColorModel color) {
        List<CoordinateEntity> posiciones = this.coordenadasColor(color);
        if (posiciones.size() < 3) {
            return false;
        } else {
            CoordinateEntity primera = posiciones.get(0);
            posiciones.remove(primera);
            return DirectionModel.SIN_DIRECION != primera.direccion(posiciones
                    .toArray(new CoordinateEntity[0]));
        }
    }

    public boolean hayTER() {
        for (ColorModel color : ColorModel.values()) {
            if (hayTER(color))
                return true;
        }
        return false;
    }

    public boolean tableroCompleto() {
        return this.pieces.size() == 6;
    }

    public void quitar(CoordinateEntity coordenada) {
        for (PieceEntity ficha : pieces) {
            if (ficha.getCoordinate().equals(coordenada)) {
                this.pieces.remove(ficha);
                break;
            }
        }
    }

    public List<CoordinateEntity> coordenadas(ColorModel color) {
        List<CoordinateEntity> corrdenadasColor = new ArrayList<>();
        for (PieceEntity ficha : pieces) {
            if (ficha.getColor() == color)
                corrdenadasColor.add(ficha.getCoordinate());
        }
        return corrdenadasColor;
    }

    public void clear() {
        this.pieces.clear();
    }

    public ColorModel[][] completeBoard() {
        ColorModel[][] matriz = new ColorModel[3][3];
        for (PieceEntity ficha : pieces) {
            matriz[ficha.getCoordinate().getRow()][ficha.getCoordinate().getColumn()] = ficha
                    .getColor();
        }
        return matriz;
    }

    public void update(BoardEntity board) {
        List<PieceEntity> pieces = new ArrayList<>(board.pieces);
        this.setPieces(pieces);
    }

    @Override
    public String toString() {
        return "BoardEntity[" + pieces + "]";
    }

    @Override
    protected BoardEntity clone() {
        List<PieceEntity> pieces = new ArrayList<>(this.pieces);
        return new BoardEntity(pieces);
    }

}
