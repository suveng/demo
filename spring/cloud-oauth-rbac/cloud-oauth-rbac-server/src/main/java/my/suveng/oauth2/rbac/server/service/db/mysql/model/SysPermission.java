package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
@Entity
@Table(name = "sys_permission", schema = "oauth2")
public class SysPermission {
    private Long id;
    private String name;
    private Long creator;
    private Long updator;
    private Timestamp createTime;
    private Timestamp updateTime;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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
        return Objects.hash(id, name, creator, updator, createTime, updateTime, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SysPermission that = (SysPermission) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(creator, that.creator)
                && Objects.equals(updator, that.updator) && Objects.equals(createTime, that.createTime)
                && Objects.equals(updateTime, that.updateTime) && Objects.equals(status, that.status);
    }
}
