package com.example.luisacfl.tareatabs;

/**
 * Created by luisacfl on 10/10/17.
 */

public class User {
    String name;
    String password;
    boolean isLogged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }


}
