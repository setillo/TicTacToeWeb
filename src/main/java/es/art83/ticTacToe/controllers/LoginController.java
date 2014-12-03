package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public interface LoginController {

    boolean read(PlayerEntity user);

    boolean create(PlayerEntity user);

    TicTacToeStateModel ticTacToeState();

}
