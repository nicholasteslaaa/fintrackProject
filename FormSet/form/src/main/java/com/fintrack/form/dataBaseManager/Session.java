package com.fintrack.form.dataBaseManager;

public class Session {
    String username;

    private static Session instance;

    // Private constructor prevents instantiation from other classes
    private Session() {}

    // Global access point
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void unsetUsername(){this.username = null;}

}
