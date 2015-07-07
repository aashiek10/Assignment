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
public class Teacher extends Person {

    private Float salary;
    private ArrayList<String> classesHandled = new ArrayList();

   
    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public ArrayList<String> getClassesHandled() {
        return classesHandled;
    }

    public void setClassesHandled(ArrayList<String> classesHandled) {
        this.classesHandled = classesHandled;
    }

    public void print() {
        System.out.println("Name: " + super.getName());
        System.out.println("Salary: " + this.salary);
        System.out.println("ID: " + super.getId());
        System.out.println("Joining Date: " + super.getJoiningDate());
        System.out.println("Classes Handled: ");
        for (int i = 0; i <classesHandled.size(); ++i) {
            System.out.println(this.classesHandled.get(i));
        }

    }
}
