package TCPTH;

import java.io.Serializable;

public class Custumer918 implements Serializable {
    private static final long serialVersionUID = 918;
    private int id;
    private String code, name, dayOfBirdth, userName;

    public Custumer918(int id, String code, String name, String dayOfBirdth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirdth = dayOfBirdth;
        this.userName = userName;
    }

    public Custumer918() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirdth() {
        return dayOfBirdth;
    }

    public void setDayOfBirdth(String dayOfBirdth) {
        this.dayOfBirdth = dayOfBirdth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Custumer918{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirdth='" + dayOfBirdth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
