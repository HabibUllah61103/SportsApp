package com.example.week_8;

import java.util.ArrayList;

public class UserManager {
    private static final UserManager instance = new UserManager();

    private ArrayList<Signup_next_page.User> users;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        return instance;
    }

    public ArrayList<Signup_next_page.User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Signup_next_page.User> users) {
        this.users = users;
    }
}
