package es.art83.ticTacToe.models.entities;

import es.art83.ticTacToe.models.utils.ColorModel;


public class TurnEntity {
    private int id;

    private ColorModel color;

    public TurnEntity(int id, ColorModel color) {
        this.id = id;
        this.color = color;
    }

    public TurnEntity(int id) {
        this(id, ColorModel.X);
    }

    public TurnEntity() {
        this(-1);
    }

    public int getId() {
        return this.id;
    }

    public ColorModel getColor() {
        return color;
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

}
