package cn.bdqn.utils;

import cn.bdqn.entity.ProCategory;
import cn.bdqn.entity.Product;

import java.util.List;

public class ProCategoryVO {

    private ProCategory proCategory;
    private List<ProCategoryVO> children;
    private List<Product> products;

    public ProCategoryVO() {
    }

    public ProCategoryVO(ProCategory proCategory) {
        this.proCategory = proCategory;
    }

    public ProCategoryVO(ProCategory proCategory, List<ProCategoryVO> children) {
        this.proCategory = proCategory;
        this.children = children;
    }

    public ProCategoryVO(ProCategory proCategory, List<ProCategoryVO> children, List<Product> products) {
        this.proCategory = proCategory;
        this.children = children;
        this.products = products;
    }

    public ProCategory getProCategory() {
        return proCategory;
    }

    public void setProCategory(ProCategory proCategory) {
        this.proCategory = proCategory;
    }

    public List<ProCategoryVO> getChildren() {
        return children;
    }

    public void setChildren(List<ProCategoryVO> children) {
        this.children = children;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProCategoryVO{" +
                "proCategory=" + proCategory +
                ", children=" + children +
                ", products=" + products +
                '}';
    }
}
