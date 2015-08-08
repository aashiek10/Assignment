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
import java.util.Scanner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class Phnbk {

    public static final String dataBaseName = "phonebook";
    public static final String[] names = {"mobile", "home", "work"};

    private void directory(CSVParser parser) throws Exception {

        Connection connection = MethodBank.getConnection();
        Statement statement = MethodBank.getStatement(connection);
        MethodBank.createDataBase(statement, dataBaseName);
        createTables(statement);
        int i = 0;
        for (CSVRecord record : parser) {
            i++;
            String tempo = " INSERT INTO phone_book (name, address) VALUES ('"
                    + record.get("Name") + "','" + record.get("Address") + "')";
            statement.executeUpdate(tempo);

            String s = record.get("Mobile");
            populate(statement, s, i, "mobile_number");

            s = record.get("Work");
            populate(statement, s, i, "work_number");

            s = record.get("Home");
            populate(statement, s, i, "home_number");

        }
        process(connection, statement);
    }

    private void createTables(Statement statement) throws SQLException {

        String crtTabl = "CREATE TABLE phone_book "
                + "(id INTEGER NOT NULL AUTO_INCREMENT, "
                + " name VARCHAR(255), "
                + " address VARCHAR(255), "
                + " PRIMARY KEY ( id ))";

        statement.executeUpdate(crtTabl);

        crtTabl = "CREATE TABLE mobile_number "
                + "(id INT(11), "
                + " number INT(11), "
                + " PRIMARY KEY ( number ))";

        statement.executeUpdate(crtTabl);

        crtTabl = "CREATE TABLE home_number "
                + "(id INT(11), "
                + " number INT(11), "
                + " PRIMARY KEY ( number ))";

        statement.executeUpdate(crtTabl);

        crtTabl = "CREATE TABLE work_number "
                + "(id INT(11), "
                + " number INT(11), "
                + " PRIMARY KEY ( number ))";

        statement.executeUpdate(crtTabl);

    }

    private void populate(Statement statement, String s, int i, String tableName) throws SQLException {
        String tempo;
        if (s != null) {
            for (String retval : s.split(",")) {
                tempo = " INSERT INTO " + tableName + " (id, number) VALUES ('" + i + "','" + retval + "')";
                statement.executeUpdate(tempo);
            }
        }
    }

    private void process(Connection connection, Statement statement) throws SQLException, Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search by : name/number?");
        String choice = sc.nextLine();
        System.out.println("Enter the " + choice + " : ");
        String param = sc.nextLine();

        if (choice.toLowerCase().equalsIgnoreCase("name")) {
            detailsName(statement, param, connection);
        } else if (choice.toLowerCase().equalsIgnoreCase("number")) {
            detailsNumber(statement, param, connection);
        } else {
            System.out.println("Invalid Choice!!");
        }

        MethodBank.dropDataBase(statement, dataBaseName);
        //closeConnection(connection);
        //closeStatement(statement);

    }

    private void detailsName(Statement statement, String param, Connection connection) throws Exception {
        String tempo = "SELECT * FROM phone_book WHERE name LIKE '%" + param + "%'";
        ResultSet result = statement.executeQuery(tempo);

        while (result.next()) {
            int id = result.getInt("id");
            printOutDetails(result);
         
            Statement statement2 = connection.createStatement();
            for (String s : names) {
                tempo = "SELECT number FROM " + s + "_number WHERE id = '" + id + "'";
                ResultSet result2 = statement2.executeQuery(tempo);
                System.out.print(s + " : ");
                printOutNumber(result2);
            }
        }
    }

    private void detailsNumber(Statement statement, String param, Connection connection) throws Exception {
        String tempo2 = "SELECT m.id, m.number FROM mobile_number AS m INNER JOIN home_number AS h ON m.id = h.id "
                + "INNER JOIN work_number AS w ON w.id = m.id "
                + "WHERE m.number = '" + param + "' OR w.number = '" + param + "' "
                + "OR h.number = '" + param + "'";
        ResultSet res = statement.executeQuery(tempo2);
        res.next();
        int id = res.getInt("id");
        
        String tempo = "SELECT * FROM phone_book WHERE id = '" + id + "'";
        ResultSet result = statement.executeQuery(tempo);

        while (result.next()) {
            printOutDetails(result);
         
            Statement statement2 = connection.createStatement();
            for (String s : names) {
                tempo = "SELECT number FROM " + s + "_number WHERE id = '" + id + "'";
                ResultSet result2 = statement2.executeQuery(tempo);
                System.out.print(s + " : ");
                printOutNumber(result2);
            }
        }
        
    }

    private void printOutDetails(ResultSet result) throws SQLException {

        System.out.println("ID : " + result.getInt("id"));
        System.out.println("Name : " + result.getString("name"));
        System.out.println("Address : " + result.getString("address"));

    }

    private void printOutNumber(ResultSet result) throws SQLException {
        while (result.next()) {
            System.out.print(result.getInt("number") + ", ");
        }
    }

    public static void main(String[] args) throws IOException, Exception {
        String source = System.getProperty("user.home") + "/input.csv";
        com.chargebee.JDBC.PhoneBook.Phnbk pb = new com.chargebee.JDBC.PhoneBook.Phnbk();
        CSVParser parser = new CSVParser(new FileReader(source), CSVFormat.EXCEL.withHeader());
        pb.directory(parser);
        parser.close();

    }

}
