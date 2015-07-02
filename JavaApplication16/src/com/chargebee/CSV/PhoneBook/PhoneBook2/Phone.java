/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.CSV.PhoneBook.PhoneBook2;

import java.util.ArrayList;

/**
 *
 * @author cb-aashiek
 */
public class Phone {
    ArrayList<String> mobileNumber = new ArrayList();
    ArrayList<String> homeNumber = new ArrayList();
    ArrayList<String> workNumber = new ArrayList();

    public ArrayList<String> getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(ArrayList<String> mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ArrayList<String> getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(ArrayList<String> homeNumber) {
        this.homeNumber = homeNumber;
    }

    public ArrayList<String> getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(ArrayList<String> workNumber) {
        this.workNumber = workNumber;
    }
    
    public Phone(ArrayList<String> mobileNumber,ArrayList<String> homeNumber,ArrayList<String> workNumber) {
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
        this.homeNumber = homeNumber;
    }
}
