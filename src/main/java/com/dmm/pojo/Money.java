package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public class Money implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "money_id", type = IdType.AUTO)
    private Integer moneyId;
    /**
     * 工资
     */
    @TableField("money_price")
    private BigDecimal moneyPrice;
    /**
     * 试用期折扣
     */
    @TableField("money_discount")
    private BigDecimal moneyDiscount;
    /**
     * 用户id
     */
    @TableField("money_user")
    private String moneyUser;

    @TableField(exist = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public BigDecimal getMoneyPrice() {
        return moneyPrice;
    }

    public void setMoneyPrice(BigDecimal moneyPrice) {
        this.moneyPrice = moneyPrice;
    }

    public BigDecimal getMoneyDiscount() {
        return moneyDiscount;
    }

    public void setMoneyDiscount(BigDecimal moneyDiscount) {
        this.moneyDiscount = moneyDiscount;
    }

    public String getMoneyUser() {
        return moneyUser;
    }

    public void setMoneyUser(String moneyUser) {
        this.moneyUser = moneyUser;
    }

    @Override
    public String toString() {
        return "Money{" +
        ", moneyId=" + moneyId +
        ", moneyPrice=" + moneyPrice +
        ", moneyDiscount=" + moneyDiscount +
        ", moneyUser=" + moneyUser +
        "}";
    }
}
