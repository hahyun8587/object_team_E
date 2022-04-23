package com.std;

import com.std.Employee;

public class User {
    private String id;
    private String pw;
    private String name;
    private int privilege;
    private Employee emp;

    public void signUp() {
        /*implement*/
    }

    public Employee login(String id, String pw) {
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
