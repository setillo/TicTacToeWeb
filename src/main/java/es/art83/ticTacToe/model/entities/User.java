package es.art83.ticTacToe.model.entities;

public class User {
    private String user;

    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User() {
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
        User other = (User) obj;
        return this.user.equals(other.user);
    }

}
