package com.topie.campus.security.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.topie.campus.common.Sortable;

@Table(name = "t_user_role")
public class Role extends Sortable {

    private static final long serialVersionUID = -387429146553168074L;

    /**
     * id
     */
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODE")
    private String code;
    
    @Column(name="SEQ")
    private int seq;
    
    @Column(name="DETAIL")
    private String detail;

    /**
     * 角色名称
     */
    @Column(name = "NAME")
    private String roleName;

    /**
     * 角色默认跳转function
     */
    @Column(name = "HOMEPAGE")
    private String defaultAction;

    /**
     * 是否启用，0=不启用，1=启用
     */
    @Column(name="enabled")
    private Integer state;

    /**
     * 生成时间
     */
    @Column(name = "insert_time")
    private Date insertTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Transient
    private List<Integer> functions;


    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色默认跳转function
     *
     * @return default_action - 角色默认跳转function
     */
    public String getDefaultAction() {
        return defaultAction;
    }

    /**
     * 设置角色默认跳转function
     *
     * @param defaultAction 角色默认跳转function
     */
    public void setDefaultAction(String defaultAction) {
        this.defaultAction = defaultAction;
    }

    /**
     * 获取是否启用，0=不启用，1=启用
     *
     * @return state - 是否启用，0=不启用，1=启用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置是否启用，0=不启用，1=启用
     *
     * @param state 是否启用，0=不启用，1=启用
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取生成时间
     *
     * @return insert_time - 生成时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置生成时间
     *
     * @param insertTime 生成时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Integer> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Integer> functions) {
        this.functions = functions;
    }
}
