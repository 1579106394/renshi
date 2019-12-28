package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@TableName("money_log")
public class MoneyLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;
    /**
     * 实发工资
     */
    @TableField("log_money")
    private Double logMoney;
    /**
     * 发给员工id
     */
    @TableField("log_user")
    private String logUser;
    /**
     * 加班工资
     */
    @TableField("log_add")
    private Double logAdd;
    /**
     * 扣除工资
     */
    @TableField("log_deduct")
    private Double logDeduct;
    /**
     * 发工资时间
     */
    @TableField("log_time")
    private String logTime;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Double getLogMoney() {
        return logMoney;
    }

    public void setLogMoney(Double logMoney) {
        this.logMoney = logMoney;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Double getLogAdd() {
        return logAdd;
    }

    public void setLogAdd(Double logAdd) {
        this.logAdd = logAdd;
    }

    public Double getLogDeduct() {
        return logDeduct;
    }

    public void setLogDeduct(Double logDeduct) {
        this.logDeduct = logDeduct;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "MoneyLog{" +
        ", logId=" + logId +
        ", logMoney=" + logMoney +
        ", logUser=" + logUser +
        ", logAdd=" + logAdd +
        ", logDeduct=" + logDeduct +
        ", logTime=" + logTime +
        "}";
    }
}
