/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JSON.PhoneBook.PhoneBook2;

import static com.chargebee.MethodBank.MethodBank.readJsonArrayData;
import com.chargebee.org.json.JSONArray;
import com.chargebee.org.json.JSONException;
import com.chargebee.org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author cb-aashiek
 */
public class PhoneBook {

    private void directory(JSONArray jarr) throws JSONException {
        HashMap<String, ArrayList> map = new HashMap();
        for(int i = 0; i < jarr.length(); ++i) {
            JSONObject jobj = jarr.getJSONObject(i);
            ArrayList<Person> person = new ArrayList();
            Person p = new Person(jobj.getString("Name"),jobj.getString("Address"), new Phone(jobj.getJSONArray("Mobile"),jobj.getJSONArray("Home"), jobj.getJSONArray("Work")));
            if (!map.containsKey(jobj.getString("Name"))) {
                person.add(p);
                map.put(jobj.getString("Name"), person);
                continue;
            }
            person = map.get(jobj.getString("Name"));
            person.add(p);
            map.put(jobj.getString("Name"), person);
        }
        display(map);
    }

    private void display(HashMap<String, ArrayList> map) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Search by : name/number?");
        String choice = sc.nextLine();
        System.out.println("Enter the " + choice + " : ");
        String param = sc.nextLine();

        if (choice.toLowerCase().equalsIgnoreCase("name")) {
            for (String key : map.keySet()) {
                if (key.toLowerCase().contains(param)) {
                    ArrayList<Person> tempo = new ArrayList();
                    tempo = map.get(key);
                    for (Person p : tempo) {
                        p.print();
                    }
                }
            }
        } else if (choice.toLowerCase().equalsIgnoreCase("number")) {
            for (Map.Entry<String, ArrayList> entry : map.entrySet()) {
                ArrayList<Person> tempo = new ArrayList();
                tempo = entry.getValue();
                for (Person p : tempo) {
                    if (p.getPhone().getHomeNumber().contains(param) || p.getPhone().getMobileNumber().contains(param) || p.getPhone().getWorkNumber().contains(param)) {
                        p.print();
                        break;
                    }
                    System.out.println("Phone Number not found!!");
                }
            }
        } else {
            System.out.println("Invalid Choice!!");
        }
    }

    public static void main(String[] args) throws IOException, Exception {
        String source = System.getProperty("user.home") + "/input.json";

        PhoneBook pb = new PhoneBook();
        JSONArray jarr = readJsonArrayData(source);
        pb.directory(jarr);

    }
}
