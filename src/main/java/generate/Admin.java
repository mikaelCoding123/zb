package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * admin
 * @author 
 */
@Data
public class Admin implements Serializable {
    private Long pokid;

    /**
     * 用户名
     */
    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}