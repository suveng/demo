package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
@Entity
@Table(name = "sys_permission_group", schema = "oauth2")
@IdClass(SysPermissionGroupPK.class)
public class SysPermissionGroup {
    private Long permissionId;
    private Long groupId;
    private Long creator;
    private Long updator;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Integer status;

    @Id
    @Column(name = "permission_id")
    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Id
    @Column(name = "group_id")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
        return Objects.hash(permissionId, groupId, creator, updator, createTime, modifyTime, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SysPermissionGroup that = (SysPermissionGroup) o;
        return Objects.equals(permissionId, that.permissionId) && Objects.equals(groupId, that.groupId)
                && Objects.equals(creator, that.creator) && Objects.equals(updator, that.updator)
                && Objects.equals(createTime, that.createTime) && Objects.equals(modifyTime, that.modifyTime)
                && Objects.equals(status, that.status);
    }
}
