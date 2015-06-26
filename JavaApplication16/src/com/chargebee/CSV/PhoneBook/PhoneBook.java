/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.CSV.PhoneBook;

import com.chargebee.MethodBank.MethodBank;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<Directory> list = new ArrayList();
        for (CSVRecord record : parser) {
            list.add(new Directory(record.get("Name"), record.get("Address"), record.get("Mobile"), record.get("Work"), record.get("Home")));
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
    public static void main(String [] args) throws IOException, Exception {
        String source = System.getProperty("user.home") + "/input2.csv";

        PhoneBook pb = new PhoneBook();

        CSVParser parser = new CSVParser(new FileReader(source), CSVFormat.EXCEL.withHeader());
        
        pb.directory(parser);
        parser.close();
        
    }
}
