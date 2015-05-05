package com.example.matan_naman.phpmysql;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by matan_naman on 04/05/2015.
 */


    public class User implements Serializable {

        private String uID;
        private String fName;
        private String lName;
        private int uGender;
        private Date uBDay;
        private String uAddr;
        private String uCity;
        private String uPhone;
        private String uEmail;
        private String uName;
        private int uType;

        public User() {

        }


        public void setUserID(String userID) {
            this.uID=userID;
        }

        public String getUserID() {
            return uID;
        }

        public void setFirstName(String firstN) {
            this.fName=firstN;
        }

        public String getFirstName() {
            return fName;
        }

        public void setLastName(String lastN) {
            this.lName=lastN;
        }

        public String getLastName() {
            return lName;
        }

        public void setUserGender(int userG) {
            this.uGender=userG;
        }
        public String getUserGender() {

            if(this.uGender==1) {
                return "Female";
            }
            else {
                return "Male";
            }
        }
        public void setUserBDay(Date userBDay) {
            this.uBDay=userBDay;
        }

        public void setUserBDay(String userBDay) {

        /*The Birthday String in format : dd/mm/yyyy*/

            SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");

            try {

                Date userBD=dFormat.parse(userBDay);
                this.uBDay=userBD;

            } catch (Exception e) {
            }
        }


        public String getUserBDay() {

            SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");

            return dFormat.format(this.uBDay);
        }

        public void setUserAddress(String userA) {
            this.uAddr=userA;
        }

        public String getUserAddress() {
            return uAddr;
        }

        public void setUserCity(String userC) {
            this.uCity=userC;
        }

        public String getUserCity() {
            return uCity;
        }

        public void setUserPhone(String userP) {
            this.uPhone=userP;
        }

        public String getUserPhone() {
            return uPhone;
        }

        public void setUserEmail(String userE) {
            this.uEmail=userE;
        }

        public String getUserEmail() {
            return uEmail;
        }

        public void setUserName(String userN) {
            this.uName=userN;
        }

        public String getUserName() {
            return uName;
        }

        public void setUserType(int userT) {
            this.uType=userT;
        }

        public int getUserType() {
            return uType;
        }

        private Date stringToDate(String userBDay) {

        /*The Birthday String in format : dd/mm/yyyy*/

            SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
            Date userBD=null;

            try {

                userBD=dFormat.parse(userBDay);


            } catch (Exception e) {
            }

            return userBD;
        }


    public void SetValue(HashMap map) {
        SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        setUserID((String) map.get("uID"));
        setFirstName((String) map.get("fName"));
        setLastName((String) map.get("lName"));
        setUserGender(Integer.parseInt((String) map.get("uGender")));
        //try {
            //setUserBDay((Date)(dFormat.parse((String) map.get("uBDay"))));
            setUserBDay(dFormat.format(date));
       // } catch (ParseException e) {
        //    e.printStackTrace();
        //}
        setUserAddress((String) map.get("uAddr"));
        setUserCity((String) map.get("uCity"));
        setUserPhone((String) map.get("uPhone"));
        setUserEmail((String) map.get("uEmail"));
        setUserName((String) map.get("uName"));
        setUserType(Integer.parseInt((String) map.get("uType")));
    }
    }




