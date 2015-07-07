/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JSON.PhoneBook.PhoneBook2;

import com.chargebee.CSV.PhoneBook.PhoneBook2.*;
import com.chargebee.org.json.JSONArray;
import com.chargebee.org.json.JSONException;
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

    public void setMobileNumber(JSONArray mobileNumberA) throws JSONException {
        for (int i=0;  i<mobileNumberA.length(); i++) 
         this.mobileNumber.add(mobileNumberA.getString(i));
        
    
    }

    public ArrayList<String> getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(JSONArray homeNumberA) throws JSONException {
        for (int i=0;  i<homeNumberA.length(); i++) 
         this.homeNumber.add(homeNumberA.getString(i));
        
    }

    public ArrayList<String> getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(JSONArray workNumberA) throws JSONException {
        for (int i=0;  i<workNumberA.length(); i++) 
         this.workNumber.add(workNumberA.getString(i));
        
    }
    
    public Phone(JSONArray mobileNumberA,JSONArray homeNumberA,JSONArray workNumberA) throws JSONException {
        for (int i=0;  i<mobileNumberA.length(); i++) 
         this.mobileNumber.add(mobileNumberA.getString(i));
        
        for (int i=0;  i<workNumberA.length(); i++) 
         this.workNumber.add(workNumberA.getString(i));
        
        for (int i=0;  i<homeNumberA.length(); i++) 
         this.homeNumber.add(homeNumberA.getString(i));
        
    }
}
