package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
public class SysUserGroupPK implements Serializable {
    private Long userId;
    private Long groupId;

    @Column(name = "user_id")
    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return Objects.hash(userId, groupId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SysUserGroupPK that = (SysUserGroupPK) o;
        return Objects.equals(userId, that.userId) && Objects.equals(groupId, that.groupId);
    }
}
