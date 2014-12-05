package es.art83.ticTacToe.models.entities;

public class GameEntity {
    private int id;

    private String name;

    private PlayerEntity playerEntity;

    private TurnEntity turnEntity;

    private BoardEntity boardEntity;

    public GameEntity(String name, PlayerEntity playerEntity) {
        this.name = name;
        this.playerEntity = playerEntity;
        this.turnEntity = new TurnEntity();
        this.boardEntity = new BoardEntity();
    }

    public GameEntity() {
        this(null, new PlayerEntity());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

}
