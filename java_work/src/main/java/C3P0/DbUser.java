package C3P0;

public class DbUser {
    private String id;
    private String username;
    private String nickname;
    private String mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {   //右键生成，toString，自动生成，然后自己修改下
        return "\t" + "id= " + id + "\t " +
                "username= " + username + "\t " +
                "nickname= " + nickname + "\t " +
                "mobile= " + mobile + "\n";
    }
}
