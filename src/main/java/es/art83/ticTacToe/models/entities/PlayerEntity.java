package es.art83.ticTacToe.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlayerEntity {
    @Id
    private String user;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<GameEntity> games;

    public PlayerEntity(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public PlayerEntity() {
        this("", "");
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void update(PlayerEntity player) {
        this.setUser(player.user);
        this.setPassword(player.password);
    }

    @Override
    public String toString() {
        return "User[" + user + ":" + password + "]";
    }

    @Override
    public int hashCode() {
        return this.user.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        PlayerEntity other = (PlayerEntity) obj;
        return this.user.equals(other.user);
    }

    @Override
    public PlayerEntity clone() {
        return new PlayerEntity(this.user, this.password);
    }

}
