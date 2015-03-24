package com.example.matan_naman.phpmysql;

/**
 * Created by matan_naman on 25/03/2015.
 */
public class CreditCard {
    private String custID;
    private String cardNum;
    private String cardDate;
    private String csv;
    public CreditCard(String custID,String cardNum,String cardDate,String csv){
        this.custID=custID;
        this.cardNum=cardNum;
        this.cardDate=cardDate;
        this.csv=csv;
    }
}
