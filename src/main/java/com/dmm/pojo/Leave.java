package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 离职记录表
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@TableName("user_leave")
public class Leave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "leave_id", type = IdType.AUTO)
    private Integer leaveId;
    /**
     * 离职用户id
     */
    @TableField("leave_user")
    private String leaveUser;
    @TableField(exist = false)
    private User user;
    /**
     * 离职时间
     */
    @TableField("leave_time")
    private String leaveTime;
    /**
     * 离职原因
     */
    @TableField("leave_reason")
    private String leaveReason;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveUser() {
        return leaveUser;
    }

    public void setLeaveUser(String leaveUser) {
        this.leaveUser = leaveUser;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    @Override
    public String toString() {
        return "Leave{" +
                ", leaveId=" + leaveId +
                ", leaveUser=" + leaveUser +
                ", leaveTime=" + leaveTime +
                ", leaveReason=" + leaveReason +
                "}";
    }
}
