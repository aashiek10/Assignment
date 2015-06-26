/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JSON.PhoneBook;

import com.chargebee.CSV.PhoneBook.Directory;
import static com.chargebee.MethodBank.MethodBank.readJsonArrayData;
import com.chargebee.org.json.JSONArray;
import com.chargebee.org.json.JSONException;
import com.chargebee.org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cb-aashiek
 */
public class PhoneBook {
    private void directory(JSONArray jarr) throws JSONException {
        List<Directory> list = new ArrayList();
        for(int i = 0; i < jarr.length(); ++i) {
        JSONObject jobj = jarr.getJSONObject(i);
        list.add(new Directory((jobj.getString("Name")),(jobj.getString("Address")),(jobj.getString("Mobile")),(jobj.getString("Work")),(jobj.getString("Home"))));
        }
        display(list);
    }

    private void display(List<Directory> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Search by : name/number?");
        String choice = sc.nextLine();
        System.out.println("Enter the " + choice + " : ");
        String param = sc.nextLine();

        if (choice.toLowerCase().equalsIgnoreCase("name")) {
            for (Directory d : list) {
                String tempo = d.getName();
                if (tempo.toLowerCase().contains(param)) {
                    d.print();
                }
            }
        } else if (choice.toLowerCase().equalsIgnoreCase("number")) {
            for (Directory d : list) {
                if (d.getMobile().equalsIgnoreCase(param) || d.getPhone().equalsIgnoreCase(param) || d.getWork().equalsIgnoreCase(param)) {
                    d.print();
                }
            }
        } else {
            System.out.println("Invalid Choice!!");
        }
    }
    public static void main(String[] args) throws IOException, Exception {
        String source = System.getProperty("user.home") + "/input.json";
        JSONArray jarr = readJsonArrayData(source);
        PhoneBook pb = new PhoneBook();
        
        pb.directory(jarr);

    }
}
