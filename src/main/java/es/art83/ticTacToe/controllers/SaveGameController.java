package es.art83.ticTacToe.controllers;

public interface SaveGameController {
    void saveGame(String gameName);

    void overWriteGame(String gameName);

    void saveGame();
}
