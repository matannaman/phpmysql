package com.example.matan_naman.phpmysql;

/**
 * Created by matan_naman on 25/03/2015.
 */
public class Person {
    private String id;
    private String lName;
    private String fName;
    private String gender;
    private String bDay ;
    private String addr ;
    private String phone ;
    private String email ;
    private String uName ;
    private String uPass ;
    private int permission ;
    private boolean isActive ;
    public Person(String id,String fName,String lName,String gender,String bDay,String addr,String phone,String email,String uName,String uPass,int permission,boolean isActive){
        this.id=id;
        this.fName=fName;
        this.lName=lName;
        this.gender=gender;
        this.bDay=bDay;
        this.addr=addr;
        this.phone=phone;
        this.email=email;
        this.uName=uName;
        this.uPass=uPass;
        this.permission=permission;
        this.isActive=isActive;
    }
}



















