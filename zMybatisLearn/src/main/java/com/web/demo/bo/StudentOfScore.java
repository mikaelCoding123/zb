package com.web.demo.bo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author
 * @version 1.0
 * @date 2025/4/21
 */

public class StudentOfScore implements Serializable {
    private String Sname;
    private String CId;
    private Integer score;
    private String Cname;

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOfScore that = (StudentOfScore) o;
        return Objects.equals(Sname, that.Sname) && Objects.equals(CId, that.CId) && Objects.equals(score, that.score) && Objects.equals(Cname, that.Cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Sname, CId, score, Cname);
    }

    @Override
    public String toString() {
        return "StudentOfScore{" +
                "Sname='" + Sname + '\'' +
                ", CId='" + CId + '\'' +
                ", score=" + score +
                ", Cname='" + Cname + '\'' +
                '}';
    }
}
