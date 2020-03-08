package yyc.model;

public class User {
    private int id;
    private long mobile;
    private String username;
    private String nickname;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
