package com.web.demo.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * admin
 * @author 
 */
@Data
public class Test01 implements Serializable {
    @TableId
    private String pokid;

    /**
     * 用户名
     */
    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}