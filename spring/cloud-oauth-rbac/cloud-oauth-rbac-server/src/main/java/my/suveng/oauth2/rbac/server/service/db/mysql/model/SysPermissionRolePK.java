package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
public class SysPermissionRolePK implements Serializable {
	private Long permissionId;
	private Long roleId;

	@Column(name = "permission_id")
	@Id
	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
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
		return Objects.hash(permissionId, roleId);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysPermissionRolePK that = (SysPermissionRolePK) o;
		return Objects.equals(permissionId, that.permissionId) &&
			Objects.equals(roleId, that.roleId);
	}
}
