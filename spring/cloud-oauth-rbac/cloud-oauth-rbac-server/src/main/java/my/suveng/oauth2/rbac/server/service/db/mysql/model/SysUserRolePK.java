package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
public class SysUserRolePK implements Serializable {
    private Long userId;
    private Long roleId;

    @Column(name = "user_id")
    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "role_id")
    @Id
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SysUserRolePK that = (SysUserRolePK) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }
}
