package com.adityabisht.unicad;

public class UserHelperClass {
    String name, enrol, pass, branch, batch;
    Boolean rep;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String enrol, String pass, String branch, String batch, Boolean rep) {
        this.name = name;
        this.enrol = enrol;
        this.pass = pass;
        this.branch = branch;
        this.batch = batch;
        this.rep = rep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrol() {
        return enrol;
    }

    public void setEnrol(String enrol) {
        this.enrol = enrol;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Boolean getRep() {
        return rep;
    }

    public void setRep(Boolean rep) {
        this.rep = rep;
    }
}
