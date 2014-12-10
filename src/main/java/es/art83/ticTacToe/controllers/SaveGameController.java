package es.art83.ticTacToe.controllers;

import java.util.List;

public interface SaveGameController {

    List<String> gameNames();

    void saveGame(String gameName);

    String getGameName();

    void overWriteGame();

}
