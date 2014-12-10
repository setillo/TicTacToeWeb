package es.art83.ticTacToe.models.entities;

import es.art83.ticTacToe.models.utils.ColorModel;

public class TurnEntity {
    private int id;

    private ColorModel color;

    public TurnEntity() {
        this.color = ColorModel.X;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    public ColorModel colorContrario() {
        if (this.color == ColorModel.X) {
            return ColorModel.O;
        } else {
            return ColorModel.X;
        }
    }

    public void cambiar() {
        if (this.color == ColorModel.X) {
            this.color = ColorModel.O;
        } else {
            this.color = ColorModel.X;
        }
    }

    @Override
    public String toString() {
        return "TurnEntity[" + id + ":" + color + "]";
    }

}
