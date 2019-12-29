package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 招聘表
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public class Recruitment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 职位
     */
    private String position;
    @TableField(exist = false)
    private Position p;
    /**
     * 招聘数量
     */
    private Integer number;
    /**
     * 要求
     */
    private String requirements;
    /**
     * 发布时间
     */
    private String createtime;
    /**
     * 是否招聘结束。1已结束，0未结束
     */
    private Integer status;

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                ", id=" + id +
                ", position=" + position +
                ", number=" + number +
                ", requirements=" + requirements +
                ", createtime=" + createtime +
                ", status=" + status +
                "}";
    }
}
