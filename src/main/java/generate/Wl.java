package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * wl
 * @author 
 */
@Data
public class Wl implements Serializable {
    /**
     * 订单id

     */
    private String id;

    /**
     * 寄件人电话
     */
    private String jjrdh;

    /**
     * 寄件人地址
     */
    private String jjrdz;

    /**
     * 寄件人
     */
    private String jjr;

    /**
     * 寄件日期
     */
    private Date jsrq;

    /**
     * 收件人地址
     */
    private String sjrdz;

    /**
     * 收件人电话
     */
    private String sjrdh;

    /**
     * 收件人
     */
    private String sjr;

    /**
     * 收件日期
     */
    private Date llrq;

    /**
     * 快递状态 
0表示快递没有完成
1表示快递已经完成
     */
    private String zt;

    /**
     * 物流公司id

     */
    private String wlgsid;

    private static final long serialVersionUID = 1L;
}