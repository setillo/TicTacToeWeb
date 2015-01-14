package es.art83.ticTacToe.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import es.art83.ticTacToe.models.utils.ColorModel;

@Entity
public class PieceEntity {
    
    @Id
    @GeneratedValue
    private int id;
    
    private ColorModel color;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "piece")
    private CoordinateEntity coordinate;
    
    @OneToOne
    @JoinColumn
    private BoardEntity board;

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

    //JPA
    public BoardEntity getBoard() {
        return board;
    }

    public void setBoard(BoardEntity board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Piece[" + color + "-" + coordinate + "]";
    }

}
