/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.MethodBank;

import com.chargebee.org.json.JSONArray;
import com.chargebee.org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class MethodBank {
    
    public static void print(CSVPrinter printer, String[] s) throws Exception {
        for (String val : s) {
            printer.print(val != null ? val : "");
        }
        printer.println();
    }
    
    public static String[] toArray(CSVRecord rec, int extraSize) {

        String[] arr = new String[rec.size()+ extraSize];
        int i = 0;
        for (String str : rec) {
            arr[i++] = str;
        }

        return arr;
    }
    
    //Overloading
    public static String[] toArray(CSVRecord rec) {
        return MethodBank.toArray(rec,0);
    }
    
    public static CSVParser parserInitializer(String csvInput) throws IOException, Exception {
        CSVParser parser = new CSVParser(new FileReader(csvInput), CSVFormat.EXCEL);
        return parser;
    }
    
    public static CSVPrinter printerInitializer(String csvOut) throws IOException, Exception {
        CSVPrinter printer = new CSVPrinter(new FileWriter(csvOut), CSVFormat.EXCEL.withRecordSeparator("\n").withDelimiter(','));
        return printer;
    }
    
    public static JSONObject readJsonObjectData(String fileName) throws Exception { //processes the Json object and returns in the required format. 
        File f = new File(fileName);
        FileInputStream fr = new FileInputStream(f);
        byte[] b = new byte[fr.available()];
        fr.read(b);
        JSONObject jobj = new JSONObject(new String(b));
        return jobj; // The required Json object

    }
    
    public static JSONArray readJsonArrayData(String fileName) throws Exception { //processes the Json array and returns in the required format. 
        File f = new File(fileName);
        FileInputStream fr = new FileInputStream(f);
        byte[] b = new byte[fr.available()];
        fr.read(b);
        JSONArray jarr = new JSONArray(new String(b));
        return jarr; // The required Json array

    }
    
    public static int indexFinder(String[] s, int difference, String columnHeader) throws Exception {
        int columnIndex = -1;
        for (int i = 0; i < s.length - difference; i++) {
            if (s[i].equalsIgnoreCase(columnHeader)) {
                columnIndex = i;
                break;
            }
        }
        return columnIndex;
    }
    
    public static int indexFinder(String[] s, String columnHeader) throws Exception {
        return indexFinder(s, 0, columnHeader);
    }
}
