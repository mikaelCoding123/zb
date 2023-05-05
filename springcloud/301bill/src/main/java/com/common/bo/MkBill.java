package com.common.bo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mk_bill
 * @author 
 */
@Data
public class MkBill implements Serializable {
    private String billId;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 商品说明
     */
    private String spsm;

    /**
     * 积分
     */
    private String jf;

    /**
     * 订单创建时间
     */
    private Date cjsj;

    /**
     * 付款方式
     */
    private String fkfs;

    /**
     * 支付时间
     */
    private Date zfsj;

    private static final long serialVersionUID = 1L;
}