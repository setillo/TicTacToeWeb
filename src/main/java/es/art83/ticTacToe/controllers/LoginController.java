package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public interface LoginController {

    boolean read(PlayerEntity user);

    boolean create(PlayerEntity user);

}
