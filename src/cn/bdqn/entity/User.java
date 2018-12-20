package cn.bdqn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 */
public class User implements Serializable {

    private static long serialVersionUID = 1L;
    private Integer id;
    private Integer sex;
    private Integer type;
    private String loginName;
    private String userName;
    private String password;
    private String identityCode;
    private String email;
    private String mobile;
    private Date createDate;
    private Date modifyDate;

    public User() {
    }

    public User(String loginName, String userName, String password, String identityCode, String email, String mobile) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
    }

    public User(String loginName, String userName, String password, String email, String mobile) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public User(Integer id, Integer sex, Integer type, String loginName, String userName, String password, String identityCode, String email, String mobile) {
        this.id = id;
        this.sex = sex;
        this.type = type;
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
    }

    public User(Integer sex, Integer type, String loginName, String userName, String password, String identityCode, String email, String mobile) {
        this.sex = sex;
        this.type = type;
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
    }

    public User(String loginName, String userName, String password, String identityCode) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.identityCode = identityCode;
    }

    public User(Integer id, Integer sex, Integer type, String loginName, String userName, String password, String identityCode, String email, String mobile, Date createDate, Date modifyDate) {
        this.id = id;
        this.sex = sex;
        this.type = type;
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sex=" + sex +
                ", type=" + type +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", identityCode='" + identityCode + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
