package cn.stylefeng.guns.modular.system.model;

/**
 * Created by Administrator on 2018/10/29.
 */
public class Msg {
    //0代表失败,1代表成功
    private Integer status=0;
    private String token="";
    private String msg="";

    public static Msg g(){
        return new Msg();
    }

    public Integer getStatus() {
        return status;
    }

    public Msg setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Msg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Msg setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "status=" + status +
                ", token='" + token + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
