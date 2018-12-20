package cn.bdqn.entity;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {

    private static long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private String address;
    private Date createDate;
    private Integer isDefault;
    private String remark;

    public Address() {
    }

    public Address(Integer userId, String address, Date createDate, Integer isDefault, String remark) {
        this.userId = userId;
        this.address = address;
        this.createDate = createDate;
        this.isDefault = isDefault;
        this.remark = remark;
    }

    public Address(Integer id, Integer userId, String address, Date createDate, Integer isDefault, String remark) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.createDate = createDate;
        this.isDefault = isDefault;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", isDefault=" + isDefault +
                ", remark='" + remark + '\'' +
                '}';
    }
}

