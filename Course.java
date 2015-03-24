package com.example.matan_naman.phpmysql;

/**
 * Created by matan_naman on 25/03/2015.
 */
public class Course {
    private String cID;
    private String cName;
    private int cPrice;
    private String imgLink;
    private float rating ;
    public Course(String cID,String cName,int cPrice,String imgLink,float rating){
        this.cID=cID;
        this.cName=cName;
        this.cPrice=cPrice;
        this.imgLink=imgLink;
        this.rating=rating;
    }
}

