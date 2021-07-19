package com;

public class UserT {
    private String name;

    public String getName() {
        return name;
    }

    public UserT() {
        System.out.println("Create UserT!");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
