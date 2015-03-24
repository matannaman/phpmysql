package com.example.matan_naman.phpmysql;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matan_naman on 25/03/2015.
 */
public class Client extends Person{
    private List<Order> ord = new ArrayList<Order>();
    private String recommend;
    public Client(List<Order> ord,String recommend,String id,String fName,String lName,String gender,String bDay,String addr,String phone,String email,String uName,String uPass,int permission,boolean isActive){
        super(id,fName,lName,gender,bDay,addr,phone,email,uName,uPass,permission,isActive);
        this.ord=ord;
        this.recommend=recommend;
    }
}
