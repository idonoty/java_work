package piaodingding.userModell;

public class User_link_wechat {
    private int id;
    private int user_id;
    private String applets_open_id;
    private int open_id_type;
    private String create_time;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", applets_open_id='" + applets_open_id + '\'' +
                ", open_id_type=" + open_id_type +
                ", create_time='" + create_time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getApplets_open_id() {
        return applets_open_id;
    }

    public void setApplets_open_id(String applets_open_id) {
        this.applets_open_id = applets_open_id;
    }

    public int getOpen_id_type() {
        return open_id_type;
    }

    public void setOpen_id_type(int open_id_type) {
        this.open_id_type = open_id_type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
