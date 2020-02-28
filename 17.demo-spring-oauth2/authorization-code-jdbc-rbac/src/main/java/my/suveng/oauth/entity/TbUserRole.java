package my.suveng.oauth.entity;

import java.io.Serializable;

/**
 * 用户角色表(TbUserRole)实体类
 *
 * @author makejava
 * @since 2020-02-28 18:20:55
 */
public class TbUserRole implements Serializable {
    private static final long serialVersionUID = 149351338940916669L;
    
    private Long id;
    /**
    * 用户 ID
    */
    private Long userId;
    /**
    * 角色 ID
    */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}