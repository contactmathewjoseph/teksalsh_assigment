package com.ytosko.twc.retronews;

public class UserX {
    private String fname,lname,mail;

    public UserX() {
    }

    public UserX(String fname, String lname, String mail) {
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
