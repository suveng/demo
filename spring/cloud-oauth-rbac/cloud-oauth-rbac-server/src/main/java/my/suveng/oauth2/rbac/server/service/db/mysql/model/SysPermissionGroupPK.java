package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
public class SysPermissionGroupPK implements Serializable {
    private Long permissionId;
    private Long groupId;

    @Column(name = "permission_id")
    @Id
    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Column(name = "group_id")
    @Id
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, groupId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SysPermissionGroupPK that = (SysPermissionGroupPK) o;
        return Objects.equals(permissionId, that.permissionId) && Objects.equals(groupId, that.groupId);
    }
}
