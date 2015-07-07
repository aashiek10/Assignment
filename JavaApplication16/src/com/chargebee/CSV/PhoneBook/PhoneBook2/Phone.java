/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.CSV.PhoneBook.PhoneBook2;

/**
 *
 * @author cb-aashiek
 */
public class Phone {
    String mobileNumber = new String();
    String homeNumber = new String();
    String workNumber = new String();

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
    
    public Phone(String mobileNumber,String homeNumber,String workNumber) {
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
        this.homeNumber = homeNumber;
    }
}
