package com.example.proyectomoviles;

public class Usermodel {
    String reginame, regiemail,regipass;

    public Usermodel(String reginame, String regiemail, String regipass) {
        this.reginame = reginame;
        this.regiemail = regiemail;
        this.regipass = regipass;
    }

    public String getReginame() {
        return reginame;
    }

    public void setReginame(String reginame) {
        this.reginame = reginame;
    }

    public String getRegiemail() {
        return regiemail;
    }

    public void setRegiemail(String regiemail) {
        this.regiemail = regiemail;
    }

    public String getRegipass() {
        return regipass;
    }

    public void setRegipass(String regipass) {
        this.regipass = regipass;
    }
}
