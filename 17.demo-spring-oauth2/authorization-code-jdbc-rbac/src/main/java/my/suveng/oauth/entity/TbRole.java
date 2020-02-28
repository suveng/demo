package my.suveng.oauth.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色表(TbRole)实体类
 *
 * @author makejava
 * @since 2020-02-28 18:10:16
 */
public class TbRole implements Serializable {
    private static final long serialVersionUID = -13271128531806592L;
    
    private Long id;
    /**
    * 父角色
    */
    private Long parentId;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 角色英文名称
    */
    private String enname;
    /**
    * 备注
    */
    private String description;
    
    private Date created;
    
    private Date updated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}