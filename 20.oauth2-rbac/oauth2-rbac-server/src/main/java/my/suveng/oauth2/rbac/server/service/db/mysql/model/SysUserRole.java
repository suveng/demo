package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
@Entity
@Table(name = "sys_user_role", schema = "oauth2")
@IdClass(SysUserRolePK.class)
public class SysUserRole {
	private Long userId;
	private Long roleId;
	private Long creator;
	private Long updator;
	private Timestamp createTime;
	private Timestamp modifyTime;
	private Integer status;

	@Id
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Id
	@Column(name = "role_id")
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
		return Objects.hash(userId, roleId, creator, updator, createTime, modifyTime, status);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysUserRole that = (SysUserRole) o;
		return Objects.equals(userId, that.userId) &&
			Objects.equals(roleId, that.roleId) &&
			Objects.equals(creator, that.creator) &&
			Objects.equals(updator, that.updator) &&
			Objects.equals(createTime, that.createTime) &&
			Objects.equals(modifyTime, that.modifyTime) &&
			Objects.equals(status, that.status);
	}
}
