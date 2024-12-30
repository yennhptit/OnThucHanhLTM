package UDPTH;

import java.io.Serializable;

public class Product937 implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code, name;
    private int quanity;

    public Product937(int id, String code, String name, int quanity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quanity = quanity;
    }

    public Product937() {
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

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    @Override
    public String toString() {
        return "Product917{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quanity=" + quanity +
                '}';
    }
}
