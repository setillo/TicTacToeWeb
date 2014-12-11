package es.art83.ticTacToe.models.entities;

import es.art83.ticTacToe.models.utils.ColorModel;

public class TurnEntity {
    private ColorModel color;

    public TurnEntity(ColorModel color) {
        this.setColor(color);
    }

    public TurnEntity() {
        this(ColorModel.X);
    }

    public ColorModel getColor() {
        return color;
    }

    public ColorModel getColorChanged() {
        if (this.color == ColorModel.X) {
            return ColorModel.O;
        } else {
            return ColorModel.X;
        }
    }

    public void setColor(ColorModel color) {
        this.color = color;
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
