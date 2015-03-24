package com.example.matan_naman.phpmysql;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matan_naman on 25/03/2015.
 */
public class Order {
    private String ordID;
    private String custID;
    private List<Course> courses = new ArrayList<Course>();
    private int amount;

    public Order(String ordID, String custID, List<Course> courses, int amount) {
        this.ordID = ordID;
        this.custID = custID;
        this.courses = courses;
        this.amount = amount;
    }
}
