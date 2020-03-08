package First.pers.yyc.SpringBoot.Interface.Bean;

public class User {
    @Override
    public String toString() {
        return "{" +
                "username:'" + username + '\'' +
                ", password:'" + password + '\'' +
                ", name:'" + name + '\'' +
                ", age:" + age +
                ", sex:'" + sex + '\'' +
                '}';
    }

    private String username;
    private String password;
    private String name;
    private int age;
    private String sex;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
