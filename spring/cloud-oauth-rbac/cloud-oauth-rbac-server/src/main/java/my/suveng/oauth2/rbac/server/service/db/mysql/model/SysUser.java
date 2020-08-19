package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
@Entity
@Table(name = "sys_user", schema = "oauth2")
public class SysUser {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phonePrefix;
    private String phone;
    private Long creator;
    private Long updator;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Integer status;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_prefix")
    public String getPhonePrefix() {
        return phonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "creator")
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "updator")
    public Long getUpdator() {
        return updator;
    }

    public void setUpdator(Long updator) {
        this.updator = updator;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "modify_time")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, phonePrefix, phone, creator, updator, createTime, modifyTime,
                status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) && Objects.equals(username, sysUser.username)
                && Objects.equals(password, sysUser.password) && Objects.equals(email, sysUser.email)
                && Objects.equals(phonePrefix, sysUser.phonePrefix) && Objects.equals(phone, sysUser.phone)
                && Objects.equals(creator, sysUser.creator) && Objects.equals(updator, sysUser.updator)
                && Objects.equals(createTime, sysUser.createTime) && Objects.equals(modifyTime, sysUser.modifyTime)
                && Objects.equals(status, sysUser.status);
    }
}
