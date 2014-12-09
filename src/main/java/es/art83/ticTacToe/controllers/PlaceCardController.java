package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.entities.CoordinateEntity;

public interface PlaceCardController {

    void placeCard(CoordinateEntity coordinateEntity);

    void placeCard(CoordinateEntity source, CoordinateEntity destination);

}
