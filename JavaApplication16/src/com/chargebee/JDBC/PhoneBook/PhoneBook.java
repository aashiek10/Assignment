/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JDBC.PhoneBook;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
   public static final String dataBaseName = "phonebook";
    
    private void directory(CSVParser parser) throws Exception {
        HashMap<Integer, String> mapName = new HashMap();
        HashMap<Integer, ArrayList<String>> mapNumber = new HashMap(); 
        int i =1;
        
        
        Connection connection = MethodBank.getConnection();
        Statement statement = MethodBank.getStatement(connection);
        MethodBank.createDataBase(statement, dataBaseName);
        
        String crtTabl = "CREATE TABLE phone_book " +
                   "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                   " name VARCHAR(255), " +  
                   " address VARCHAR(255), " +
	           " mobile INT(11), " +
	           " home INT(11), " +
                   " work INT(11), " + 
                   " PRIMARY KEY ( id ))";
        statement.executeUpdate(crtTabl);

        
        for (CSVRecord record : parser) {

                mapName.put(i, record.get("Name"));
                
                String tempo = " INSERT INTO phone_book (name, address, mobile, home, work) VALUES ('" 
                               + record.get("Name") + "','" + record.get("Address") + "','" 
                               + record.get("Mobile") + "','" + record.get("Home") + "','" 
                               + record.get("Work").trim() + "')";
                
                
                ArrayList<String> list = new ArrayList();
                list.add(record.get("Mobile"));
                list.add(record.get("Home"));
                list.add(record.get("Work"));
                mapNumber.put(i, list);
                i++;
                statement.executeUpdate(tempo);
            }            
        display(mapName, mapNumber,statement);
    }

    private void display(HashMap<Integer, String> mapName, HashMap<Integer, ArrayList<String>> mapNumber, Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Search by : name/number?");
        String choice = sc.nextLine();
        System.out.println("Enter the " + choice + " : ");
        String param = sc.nextLine();

        if (choice.toLowerCase().equalsIgnoreCase("name")) {
            int i = 0;
            for (String value : mapName.values()) {
                i++;
                if (value.toLowerCase().contains(param)) {
                    String tempo = "SELECT * FROM phone_book WHERE id = " + i;
                    ResultSet result = statement.executeQuery(tempo);
                    while (result.next()) {
                        System.out.println("ID : " + result.getInt("id"));
                        System.out.println("Name : "+result.getString("name"));
                        System.out.println("Address : " + result.getString("address"));
                        System.out.println("Mobile : " + result.getInt("mobile"));
                        System.out.println("Work : " + result.getInt("work"));
                        System.out.println("Home : " + result.getInt("home"));
                    }
                    continue;
                }
            }
        }
        else if (choice.toLowerCase().equalsIgnoreCase("number")) {
            for (Map.Entry<Integer, ArrayList<String>> entry : mapNumber.entrySet()) {
                ArrayList<String> tempo = new ArrayList();
                tempo = entry.getValue();
                if (tempo.contains(param)) {
                    String tempo2 = "SELECT * FROM phone_book WHERE id = " + entry.getKey();
                    ResultSet result = statement.executeQuery(tempo2);
                    while (result.next()) {
                        System.out.println("ID : " + result.getInt("id"));
                        System.out.println("Name : "+result.getString("name"));
                        System.out.println("Address : " + result.getString("address"));
                        System.out.println("Mobile : " + result.getInt("mobile"));
                        System.out.println("Work : " + result.getInt("work"));
                        System.out.println("Home : " + result.getInt("home"));
                    }
                        break;
                }       
                }
            }
         else {
            System.out.println("Invalid Choice!!");
        }

        MethodBank.dropDataBase(statement, dataBaseName);
        //closeConnection(connection);
        //closeStatement(statement);
                
    }

    public static void main(String[] args) throws IOException, Exception {
        String source = System.getProperty("user.home") + "/input.csv";

        com.chargebee.JDBC.PhoneBook.PhoneBook pb = new com.chargebee.JDBC.PhoneBook.PhoneBook();

        CSVParser parser = new CSVParser(new FileReader(source), CSVFormat.EXCEL.withHeader());

        pb.directory(parser);
        parser.close();

    }
 
}
