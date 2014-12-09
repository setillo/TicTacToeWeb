package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.DirectionModel;

public class BoardEntity {
    private int id;

    private List<PieceEntity> fichas;

    public BoardEntity() {
        this.fichas = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public List<PieceEntity> getFichas() {
        return this.fichas;
    }

    public List<CoordinateEntity> coordenadasDestinosValidas() {
        List<CoordinateEntity> vacias = CoordinateEntity.posibles();
        for (PieceEntity ficha : fichas) {
            vacias.remove(ficha.getCoordenada());
        }
        return vacias;
    }

    public List<CoordinateEntity> coordenadasColor(ColorModel color) {
        List<CoordinateEntity> coordenadas = new ArrayList<>();
        for (PieceEntity ficha : this.fichas) {
            if (ficha.getColor().equals(color))
                coordenadas.add(ficha.getCoordenada());
        }
        return coordenadas;
    }

    public void poner(PieceEntity ficha) {
        this.fichas.add(ficha);
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
        return this.fichas.size() == 6;
    }

    public void quitar(CoordinateEntity coordenada) {
        for (PieceEntity ficha : fichas) {
            if (ficha.getCoordenada().equals(coordenada)) {
                this.fichas.remove(ficha);
                break;
            }
        }
    }

    public List<CoordinateEntity> coordenadas(ColorModel color) {
        List<CoordinateEntity> corrdenadasColor = new ArrayList<>();
        for (PieceEntity ficha : fichas) {
            if (ficha.getColor() == color)
                corrdenadasColor.add(ficha.getCoordenada());
        }
        return corrdenadasColor;
    }

    public void clear() {
        this.fichas.clear();
    }

    public ColorModel[][] completeBoard() {
        ColorModel[][] matriz = new ColorModel[3][3];
        for (PieceEntity ficha : fichas) {
            matriz[ficha.getCoordenada().getFila()][ficha.getCoordenada().getColumna()] = ficha
                    .getColor();
        }
        return matriz;
    }
}
