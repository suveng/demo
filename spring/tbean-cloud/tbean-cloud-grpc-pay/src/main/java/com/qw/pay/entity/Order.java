package com.qw.pay.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author suwenguang
 *
 * @since 2020-08-06 18:56:48
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 674673461400932450L;

    private Integer id;
    /**
     * 唯一标识id
     */
    private String uaId;
    /**
     * 状态，0：未回传，1：回传成功, 2：回传失败
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 事件类型 REGISTER，LOGIN，ACTIVATE
     */
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUaId() {
        return uaId;
    }

    public void setUaId(String uaId) {
        this.uaId = uaId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
