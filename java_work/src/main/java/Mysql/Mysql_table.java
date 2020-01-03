package Mysql;

public class Mysql_table {
    static class user {
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

        user(String id, String username, String nickname,String mobile) {
            this.id = id; //default
            this.username = username;
            this.nickname = nickname;
            this.mobile = mobile;

        }
    }
}
