/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.CSV.PhoneBook.PhoneBook2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class PhoneBook {

    private void directory(CSVParser parser) {
        HashMap<String, ArrayList> map = new HashMap();
        for (CSVRecord record : parser) {
            ArrayList<Person> person = new ArrayList();
            Person p = new Person(record.get("Name"), record.get("Address"), new Phone(record.get("Mobile"), record.get("Home"), record.get("Work")));
            if (!map.containsKey(record.get("Name"))) {
                person.add(p);
                map.put(record.get("Name"), person);
                continue;
            }
            person = map.get(record.get("Name"));
            person.add(p);
            map.put(record.get("Name"), person);
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
                    if (p.getPhone().getHomeNumber().equalsIgnoreCase(param) || p.getPhone().getMobileNumber().equalsIgnoreCase(param) || p.getPhone().getWorkNumber().equalsIgnoreCase(param)) {
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
        String source = System.getProperty("user.home") + "/input2.csv";

        PhoneBook pb = new PhoneBook();

        CSVParser parser = new CSVParser(new FileReader(source), CSVFormat.EXCEL.withHeader());

        pb.directory(parser);
        parser.close();

    }
}
