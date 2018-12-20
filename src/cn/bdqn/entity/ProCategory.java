package cn.bdqn.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品目录实体
 */
public class ProCategory implements Serializable {
    private static long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer type;
    private String iconClass;

    private List<ProCategory> list;
    private List<Product> products;

    public ProCategory() {
    }

    public ProCategory(Integer id, String name, Integer parentId, Integer type, String iconClass) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.type = type;
        this.iconClass = iconClass;
    }

    public ProCategory(String name, Integer parentId, Integer type) {
        this.name = name;
        this.parentId = parentId;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public List<ProCategory> getList() {
        return list;
    }

    public void setList(List<ProCategory> list) {
        this.list = list;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", iconClass='" + iconClass + '\'' +
                ", list=" + list +
                '}';
    }
}
