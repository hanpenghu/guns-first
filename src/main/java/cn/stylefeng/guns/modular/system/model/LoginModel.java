package cn.stylefeng.guns.modular.system.model;

/**
 * Created by Administrator on 2018/10/29.
 */
public class LoginModel {
    private String password;
    private String username;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
