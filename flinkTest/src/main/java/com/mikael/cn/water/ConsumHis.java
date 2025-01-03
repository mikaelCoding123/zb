package com.mikael.cn.water;

//消费记录

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConsumHis implements Serializable {
    private final static long serialVersionUID = 1L;
    private String id;
    private String name;
    private Date time;
    private BigDecimal price;

    public ConsumHis() {
    }

    public ConsumHis(String id, String name, Date time, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConsumHis{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
