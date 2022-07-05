package com.web.demo.bo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * admin
 * @author 
 */
@Data
public class Admin implements Serializable {
    @TableId
    private Long pokid;

    /**
     * 用户名
     */
    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}