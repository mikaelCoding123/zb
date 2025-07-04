package com.web.demo.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * admin
 * @author 
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -2597342667901138950L;
    @TableId
    private Long pokid;

    /**
     * 用户名
     */
    private String username;
    @TableField(select = false)
    private String password;

}