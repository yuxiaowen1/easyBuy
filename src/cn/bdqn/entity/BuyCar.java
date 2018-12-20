package cn.bdqn.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuyCar implements Serializable {


    private static long serialVersionUID = 1L;

    private Product product;
    private Integer num;

    public BuyCar() {
    }

    public BuyCar(Product product, Integer num) {
        this.product = product;
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BuyCar{" +
                "product=" + product +
                ", num=" + num +
                '}';
    }
}
