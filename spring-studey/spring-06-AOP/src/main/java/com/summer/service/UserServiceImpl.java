package com.summer.service;

public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("add a new user");
    }

    @Override
    public void update() {
        System.out.println("update a new user");
    }

    @Override
    public int delete() {
        System.out.println("delete a new user");
        return 1;
    }

    @Override
    public void select() {
        System.out.println("select a new user");
    }
}
