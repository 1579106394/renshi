package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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
    private BigDecimal logMoney;
    /**
     * 发给员工id
     */
    @TableField("log_user")
    private String logUser;
    /**
     * 加班工资
     */
    @TableField("log_add")
    private BigDecimal logAdd;
    /**
     * 扣除工资
     */
    @TableField("log_deduct")
    private BigDecimal logDeduct;
    /**
     * 发工资时间
     */
    @TableField("log_time")
    private String logTime;

    @TableField(exist = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public BigDecimal getLogMoney() {
        return logMoney;
    }

    public void setLogMoney(BigDecimal logMoney) {
        this.logMoney = logMoney;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public BigDecimal getLogAdd() {
        return logAdd;
    }

    public void setLogAdd(BigDecimal logAdd) {
        this.logAdd = logAdd;
    }

    public BigDecimal getLogDeduct() {
        return logDeduct;
    }

    public void setLogDeduct(BigDecimal logDeduct) {
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

    /**
     * 重写equals。当月份和用户相同时视为两个对象相同
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoneyLog moneyLog = (MoneyLog) o;
        return logUser.equals(moneyLog.logUser) &&
                logTime.equals(moneyLog.logTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logUser, logTime);
    }
}
