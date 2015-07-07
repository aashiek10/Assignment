/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JSON.ReadingJsonFile;

import java.util.ArrayList;

/**
 *
 * @author cb-aashiek
 */
public class Student extends Person {
    
    private String standard;
    private ArrayList<Marks> marks = new ArrayList();
    
    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public ArrayList<Marks> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Marks> marks) {
        this.marks = marks;
    }
    
    public void print() {
        System.out.println("Name: " + super.getName());
        System.out.println("Standard: " + this.standard);
        System.out.println("ID: " + super.getId());
        System.out.println("Joining Date: " + super.getJoiningDate());
        for(int i=0; i<marks.size(); ++i) 
           marks.get(i).print();
        
    }
}
