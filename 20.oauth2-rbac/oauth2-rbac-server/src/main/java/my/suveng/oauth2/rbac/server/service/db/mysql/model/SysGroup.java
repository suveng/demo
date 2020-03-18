package my.suveng.oauth2.rbac.server.service.db.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author suwenguang
 **/
@Entity
@Table(name = "sys_group", schema = "oauth2")
public class SysGroup {
	private Long id;
	private String name;
	private Long parentId;
	private Integer level;
	private Long masterId;
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
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "parent_id")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Basic
	@Column(name = "level")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Basic
	@Column(name = "master_id")
	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
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
		return Objects.hash(id, name, parentId, level, masterId, creator, updator, createTime, modifyTime, status);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysGroup sysGroup = (SysGroup) o;
		return Objects.equals(id, sysGroup.id) &&
			Objects.equals(name, sysGroup.name) &&
			Objects.equals(parentId, sysGroup.parentId) &&
			Objects.equals(level, sysGroup.level) &&
			Objects.equals(masterId, sysGroup.masterId) &&
			Objects.equals(creator, sysGroup.creator) &&
			Objects.equals(updator, sysGroup.updator) &&
			Objects.equals(createTime, sysGroup.createTime) &&
			Objects.equals(modifyTime, sysGroup.modifyTime) &&
			Objects.equals(status, sysGroup.status);
	}
}
