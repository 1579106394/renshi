package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 职位变更记录
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@TableName("postion_change")
public class PostionChange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "change_id", type = IdType.AUTO)
    private Integer changeId;
    /**
     * 用户id
     */
    @TableField("change_user")
    private String changeUser;
    /**
     * 旧职位
     */
    @TableField("change_old_position")
    private Integer changeOldPosition;
    /**
     * 新职位
     */
    @TableField("change_new_position")
    private Integer changeNewPosition;
    /**
     * 职位变更时间
     */
    @TableField("change_time")
    private String changeTime;

    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Position oldPosition;
    @TableField(exist = false)
    private Position newPosition;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(Position oldPosition) {
        this.oldPosition = oldPosition;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(Position newPosition) {
        this.newPosition = newPosition;
    }

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    public String getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser;
    }

    public Integer getChangeOldPosition() {
        return changeOldPosition;
    }

    public void setChangeOldPosition(Integer changeOldPosition) {
        this.changeOldPosition = changeOldPosition;
    }

    public Integer getChangeNewPosition() {
        return changeNewPosition;
    }

    public void setChangeNewPosition(Integer changeNewPosition) {
        this.changeNewPosition = changeNewPosition;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    @Override
    public String toString() {
        return "PostionChange{" +
                ", changeId=" + changeId +
                ", changeUser=" + changeUser +
                ", changeOldPosition=" + changeOldPosition +
                ", changeNewPosition=" + changeNewPosition +
                ", changeTime=" + changeTime +
                "}";
    }
}
