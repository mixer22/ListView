package com.example.listview;

import java.util.Comparator;

public class NumberComparator implements Comparator<User> {
    public int compare(User a, User b) {
        return a.getNumber().compareTo(b.getNumber());
    }
}
