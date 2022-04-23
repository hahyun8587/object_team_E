package com.project2;

import Employee;

public class User {
    private String ID;
    private String pw;
    private String name;
    private int privilege;
    private Employee emp;

    public void signUp() {
        /*implement*/
    }

    public Employee login() {
        /*implement*/
    }

    public void logout() {
        /*implement*/
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public void setEmployee(Employee emp) {
        this.emp = emp;
    }
}
