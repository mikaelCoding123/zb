package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * order
 * @author 
 */
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    private String id;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 产品
     */
    private String product;

    private static final long serialVersionUID = 1L;
}