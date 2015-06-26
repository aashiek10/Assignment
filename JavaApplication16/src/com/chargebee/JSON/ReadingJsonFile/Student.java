/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JSON.ReadingJsonFile;

/**
 *
 * @author cb-aashiek
 */
public class Student {
    private String name;
    private String standard;
    private String joiningDate;
    private String id;
    private String [] marks = new String[5];
    private String [] subject = new String[5];

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getMarks() {
        return marks;
    }

    public void setMarks(String[] marks) {
        this.marks = marks;
    }
    
    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Standard: " + this.standard);
        System.out.println("ID: " + this.id);
        System.out.println("Joining Date: " + this.joiningDate);
        for(int i=0; i<5; ++i) {
            System.out.println("Subject: " + this.subject[i]);
            System.out.println("Marks: " + this.marks[i]);
        }
    }
}
