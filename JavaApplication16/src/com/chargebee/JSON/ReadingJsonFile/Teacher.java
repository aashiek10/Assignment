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
public class Teacher {

    private String name;
    private String salary;
    private String joiningDate;
    private String id;
    private String[] classesHandled = new String[3];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String[] getClassesHandled() {
        return classesHandled;
    }

    public void setClassesHandled(String[] classesHandled) {
        this.classesHandled = classesHandled;
    }

    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
        System.out.println("ID: " + this.id);
        System.out.println("Joining Date: " + this.joiningDate);
        System.out.println("Classes Handled: ");
        for (int i = 0; i < 3; ++i) {
            System.out.println(this.classesHandled[i]);
        }

    }
}
