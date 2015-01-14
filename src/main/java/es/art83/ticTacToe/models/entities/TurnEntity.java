package es.art83.ticTacToe.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import es.art83.ticTacToe.models.utils.ColorModel;

@Entity
public class TurnEntity {
    @Id
    @GeneratedValue
    private int id;

    private ColorModel color;

    @OneToOne
    @JoinColumn
    private GameEntity game;

    public TurnEntity(ColorModel color) {
        this.setColor(color);
    }

    public TurnEntity() {
        this(ColorModel.X);
    }

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    // JPA
    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public ColorModel getColorChanged() {
        if (this.color == ColorModel.X) {
            return ColorModel.O;
        } else {
            return ColorModel.X;
        }
    }

    public void change() {
        if (this.color == ColorModel.X) {
            this.color = ColorModel.O;
        } else {
            this.color = ColorModel.X;
        }
    }

    public void update(TurnEntity turn) {
        this.setColor(turn.color);
    }

    @Override
    public String toString() {
        return "TurnEntity[" + color + "]";
    }

    @Override
    protected TurnEntity clone() {
        return new TurnEntity(this.color);
    }

}
