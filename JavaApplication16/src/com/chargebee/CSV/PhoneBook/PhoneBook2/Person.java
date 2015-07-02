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
public class Person {
    private String name;
    private String address;
    private Phone phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println();
    }

}
