package com.topie.zcpt.core.model;

import javax.persistence.*;

@Table(name = "app_applicationinfo")
public class AppApplicationinfo {
    private String id;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "app_code")
    private String appCode;

    @Column(name = "app_path")
    private String appPath;

    @Column(name = "app_path1")
    private String appPath1;

    @Column(name = "syn_type")
    private String synType;

    @Column(name = "syn_path")
    private String synPath;

    @Column(name = "syn_path1")
    private String synPath1;

    private String description;

    private String packagename;

    private String status;

    @Column(name = "op_level")
    private String opLevel;

    @Column(name = "user_level")
    private String userLevel;

    @Column(name = "param_name")
    private String paramName;

    private Integer seq;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return app_name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return app_code
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * @param appCode
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return app_path
     */
    public String getAppPath() {
        return appPath;
    }

    /**
     * @param appPath
     */
    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    /**
     * @return app_path1
     */
    public String getAppPath1() {
        return appPath1;
    }

    /**
     * @param appPath1
     */
    public void setAppPath1(String appPath1) {
        this.appPath1 = appPath1;
    }

    /**
     * @return syn_type
     */
    public String getSynType() {
        return synType;
    }

    /**
     * @param synType
     */
    public void setSynType(String synType) {
        this.synType = synType;
    }

    /**
     * @return syn_path
     */
    public String getSynPath() {
        return synPath;
    }

    /**
     * @param synPath
     */
    public void setSynPath(String synPath) {
        this.synPath = synPath;
    }

    /**
     * @return syn_path1
     */
    public String getSynPath1() {
        return synPath1;
    }

    /**
     * @param synPath1
     */
    public void setSynPath1(String synPath1) {
        this.synPath1 = synPath1;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return packagename
     */
    public String getPackagename() {
        return packagename;
    }

    /**
     * @param packagename
     */
    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return op_level
     */
    public String getOpLevel() {
        return opLevel;
    }

    /**
     * @param opLevel
     */
    public void setOpLevel(String opLevel) {
        this.opLevel = opLevel;
    }

    /**
     * @return user_level
     */
    public String getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel
     */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * @return param_name
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * @param paramName
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * @return seq
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}