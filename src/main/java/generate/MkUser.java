package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * mk_user
 * @author 
 */
@Data
public class MkUser implements Serializable {
    private String userid;

    /**
     * 用户名（登录用的）
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String sjhm;

    private String dzyx;

    /**
     * 余额
     */
    private String balance;

    private static final long serialVersionUID = 1L;
}