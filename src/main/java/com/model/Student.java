package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {

    private String sid;
    private String sname;
    private String semail;
    private Integer cid;
    private LocalDate dob;
    private LocalDateTime createdBy;

    public Student() {
    }

    public Student(String sid, String sname, String semail, Integer cid, LocalDate dob, LocalDateTime createdBy) {
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.cid = cid;
        this.dob = dob;
        this.createdBy = createdBy;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", semail='" + semail + '\'' +
                ", cid=" + cid +
                ", dob=" + dob +
                ", createdBy=" + createdBy +
                '}';
    }
}

