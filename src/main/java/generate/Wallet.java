package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * wallet
 * @author 
 */
@Data
public class Wallet implements Serializable {
    /**
     * 账号
     */
    private String userid;

    /**
     * 余额
     */
    private Long sum;

    private static final long serialVersionUID = 1L;
}