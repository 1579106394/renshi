package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class Money implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "money_id", type = IdType.AUTO)
    private Integer moneyId;
    /**
     * 工资
     */
    @TableField("money_price")
    private Double moneyPrice;
    /**
     * 试用期折扣
     */
    @TableField("money_discount")
    private Double moneyDiscount;
    /**
     * 用户id
     */
    @TableField("money_user")
    private String moneyUser;


    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public Double getMoneyPrice() {
        return moneyPrice;
    }

    public void setMoneyPrice(Double moneyPrice) {
        this.moneyPrice = moneyPrice;
    }

    public Double getMoneyDiscount() {
        return moneyDiscount;
    }

    public void setMoneyDiscount(Double moneyDiscount) {
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
