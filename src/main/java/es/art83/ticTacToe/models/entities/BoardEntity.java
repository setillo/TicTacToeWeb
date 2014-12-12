package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.DirectionModel;

@Entity
public class BoardEntity {
    private static final int FULL_BOARD = 6;
    private static final int TIC_TAC_TOE = FULL_BOARD / 2;
    
    @Id
    @GeneratedValue
    private int id;
    
    @OneToOne
    @JoinColumn
    private GameEntity game;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board")
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

    public List<CoordinateEntity> validDestinationCoordinates() {
        List<CoordinateEntity> coordinates = CoordinateEntity.allCoordinates();
        for (PieceEntity ficha : pieces) {
            coordinates.remove(ficha.getCoordinate());
        }
        return coordinates;
    }

    public List<CoordinateEntity> coordinatesColor(ColorModel color) {
        List<CoordinateEntity> coordenadas = new ArrayList<>();
        for (PieceEntity ficha : this.pieces) {
            if (ficha.getColor().equals(color))
                coordenadas.add(ficha.getCoordinate());
        }
        return coordenadas;
    }

    public void put(PieceEntity ficha) {
        this.pieces.add(ficha);
    }

    public boolean existTicTacToe(ColorModel color) {
        List<CoordinateEntity> posiciones = this.coordinatesColor(color);
        if (posiciones.size() < TIC_TAC_TOE) {
            return false;
        } else {
            CoordinateEntity primera = posiciones.get(0);
            posiciones.remove(primera);
            return DirectionModel.SIN_DIRECION != primera.direction(posiciones
                    .toArray(new CoordinateEntity[0]));
        }
    }

    public boolean existTicTacToe() {
        for (ColorModel color : ColorModel.values()) {
            if (existTicTacToe(color))
                return true;
        }
        return false;
    }

    public boolean fullBoard() {
        return this.pieces.size() == FULL_BOARD;
    }

    public void remove(CoordinateEntity coordenada) {
        for (PieceEntity ficha : pieces) {
            if (ficha.getCoordinate().equals(coordenada)) {
                this.pieces.remove(ficha);
                break;
            }
        }
    }

    public List<CoordinateEntity> coordinates(ColorModel color) {
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
    public BoardEntity clone() {
        List<PieceEntity> pieces = new ArrayList<>(this.pieces);
        return new BoardEntity(pieces);
    }

}
