package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 账号
     */
    @TableId(value = "username", type = IdType.INPUT)
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 照片
     */
    private String img;
    /**
     * 1普通员工，2人事，3管理员
     */
    private Integer role;
    /**
     * 简介
     */
    private String content;
    /**
     * 入职时间
     */
    @TableField("start_time")
    private String startTime;
    /**
     * 转正时间
     */
    @TableField("formal_time")
    private String formalTime;
    /**
     * 1转正，0试用
     */
    private Integer formal;
    /**
     * 是否离职，1离职0未离职
     */
    private Integer leave;
    /**
     * 职位id
     */
    private Integer position;

    @TableField(exist = false)
    private Position userPosition;

    public Position getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(Position userPosition) {
        this.userPosition = userPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFormalTime() {
        return formalTime;
    }

    public void setFormalTime(String formalTime) {
        this.formalTime = formalTime;
    }

    public Integer getFormal() {
        return formal;
    }

    public void setFormal(Integer formal) {
        this.formal = formal;
    }

    public Integer getLeave() {
        return leave;
    }

    public void setLeave(Integer leave) {
        this.leave = leave;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                ", username=" + username +
                ", password=" + password +
                ", img=" + img +
                ", role=" + role +
                ", content=" + content +
                ", startTime=" + startTime +
                ", formalTime=" + formalTime +
                ", formal=" + formal +
                ", leave=" + leave +
                ", position=" + position +
                "}";
    }
}
