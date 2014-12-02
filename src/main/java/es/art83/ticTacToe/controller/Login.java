package es.art83.ticTacToe.controller;

import es.art83.ticTacToe.model.entities.User;

public interface Login {

    boolean read(User user);

    boolean create(User user);

}
