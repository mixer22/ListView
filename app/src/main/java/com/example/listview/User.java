package com.example.listview;

public class User {
    String name, phoneNumber;
    Sex sex;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public User(String name, String phoneNumber, Sex sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }
}
