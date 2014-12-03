package es.art83.ticTacToe.models.entities;

public class UserEntity {
    private String user;

    private String password;

    public UserEntity(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public UserEntity() {
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

    @Override
    public String toString() {
        return "User[" + user + "," + password + "]";
    }

    @Override
    public int hashCode() {
        return this.user.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        UserEntity other = (UserEntity) obj;
        return this.user.equals(other.user);
    }

}
