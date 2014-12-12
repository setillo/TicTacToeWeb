package es.art83.ticTacToe.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import es.art83.ticTacToe.models.utils.ColorModel;

@Entity
public class GameEntity {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    @OneToOne
    @JoinColumn
    private PlayerEntity player;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game")
    private TurnEntity turn;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game")
    private BoardEntity board;

    public GameEntity(String name, PlayerEntity playerEntity, BoardEntity boardClone,
            TurnEntity turnClone) {
        this.setName(name);
        this.setPlayer(playerEntity);
        this.setBoardEntity(boardClone);
        this.setTurn(turnClone);
    }

    public GameEntity(String name, PlayerEntity playerEntity) {
        this(name, playerEntity, new BoardEntity(), new TurnEntity());
    }

    public GameEntity(PlayerEntity playerEntity) {
        this(null, playerEntity);
    }

    public GameEntity() {
        this(null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerEntity getPlayer() {
        return this.player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public TurnEntity getTurn() {
        return this.turn;
    }

    public void setTurn(TurnEntity turn) {
        this.turn = turn;
    }

    public BoardEntity getBoard() {
        return board;
    }

    public void setBoardEntity(BoardEntity board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return this.board.existTicTacToe();
    }

    public ColorModel[][] completeBoard() {
        return this.board.completeBoard();
    }

    public ColorModel winner() {
        return this.turn.getColorChanged();
    }

    public ColorModel turnColor() {
        return this.turn.getColor();
    }

    public boolean isFullBoard() {
        return this.board.fullBoard();
    }

    public List<CoordinateEntity> validSourceCoordinates() {
        return this.board.coordinates(this.turnColor());
    }

    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.board.validDestinationCoordinates();
    }

    public void placeCard(CoordinateEntity coordinate) {
        this.board.put(new PieceEntity(this.getTurn().getColor(), coordinate));
        this.turn.change();
    }

    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        this.board.remove(source);
        this.placeCard(destination);
    }

    public void update(GameEntity game) {
        this.turn.update(game.turn);
        this.board.update(game.board);
        this.setName(game.getName());
        this.setPlayer(game.getPlayer());
    }

    @Override
    public String toString() {
        return "GameEntity[" + name + "," + player + "," + turn + "," + board + "]";
    }

    @Override
    public GameEntity clone() {
        BoardEntity boardClone = this.board.clone();
        TurnEntity turnClone = this.turn.clone();
        return new GameEntity(this.name, this.player, boardClone, turnClone);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((player == null) ? 0 : player.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        GameEntity other = (GameEntity) obj;
        boolean result;

        if (this.name == null) {
            result = other.name == null;
        } else {
            result = other.name != null && this.name.equals(other.name);
        }

        return result && this.player.equals(other.player);
    }

}
