/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.CSV.PhoneBook;

/**
 *
 * @author cb-aashiek
 */
public class Directory {
    private String name;
    private String address;
    private String mobile;
    private String work;
    private String phone;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Directory(String name, String address, String mobile, String work, String phone) {
        this.name=name;
        this.address=address;
        this.phone = phone;
        this.work=work;
        this.mobile=mobile;
    }
    
    public void print(){
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Mobile: " + this.mobile);
        System.out.println("Work: " + this.work);
        System.out.println("Home: " + this.phone);
        System.out.println();
    }
    
}
