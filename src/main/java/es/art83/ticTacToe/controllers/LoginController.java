package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.entities.UserEntity;

public interface LoginController {

    boolean read(UserEntity user);

    boolean create(UserEntity user);

}
