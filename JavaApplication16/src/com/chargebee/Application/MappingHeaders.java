/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.Application;

import com.chargebee.org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class MappingHeaders {
    
    private static HashMap<String, String> hmJsonData = new HashMap(); //To store the customer_id and token from Json array as key-value pair.

    private JSONObject readJsonData(String fileName2) throws Exception { //processes the Json array and returns in the required format. 
        File f = new File(fileName2);
        FileInputStream fr = new FileInputStream(f);
        byte[] b = new byte[fr.available()];
        fr.read(b);
        //JSONArray jarr = new JSONArray(new String(b));
        JSONObject jobj = new JSONObject(new String(b));
        return jobj; // The required Json object

    }

    private void extractJsonData(JSONObject jobj) throws Exception { //Extracts the customer_id and token nad stores them in the HashMap hm as key-value pair.

        Iterator iterator = jobj.keys();
        while (iterator.hasNext()) {
            String key = ((String) iterator.next()).trim(); //Header given in the CSV given by customer
            String value = ((String) jobj.get(key)).trim();// The header it must be actually mapped to
            hmJsonData.put(key, value);
        }
    }

    private void configure(String csvInput, String csvOut) throws Exception { // Objects of CSVParser and CSVPrinter are created and passed on to be used.  Also calls the method for writing data into the output CSV. 
        CSVParser parser = new CSVParser(new FileReader(csvInput), CSVFormat.EXCEL.withHeader());
        CSVPrinter printer = new CSVPrinter(new FileWriter(csvOut), CSVFormat.EXCEL.withRecordSeparator("\n").withDelimiter(','));
        Map<String, Integer> hmCsvHeaders = new HashMap();

        hmCsvHeaders = parser.getHeaderMap();
        validateAndWrite(hmCsvHeaders, printer);
        writeData(parser, printer);

        parser.close();
        printer.close();
    }

    private void validateAndWrite(Map<String, Integer> hmCsvHeaders, CSVPrinter printer) throws IOException {
        List<String> list = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : hmCsvHeaders.entrySet()) {
            if (hmJsonData.containsKey(entry.getKey())) {
                list.add((hmJsonData.get(entry.getKey())).trim());
            } else {
                list.add((entry.getKey()).trim());
            }
        }
        print(list, printer);
    }

    private void writeData(CSVParser parser, CSVPrinter printer) throws IOException {
        for (CSVRecord record : parser) {
            printer.printRecord(record);
        }
    }

    private void print(List<String> list, CSVPrinter printer) throws IOException {
        printer.printRecord(list);
    }

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Input CSV File: ");
        String source1 = sc.nextLine();

        System.out.println("config File: ");
        String source2 = sc.nextLine();

        System.out.println("Output CSV File: ");
        String output = sc.nextLine();
        
        
        MappingHeaders objHm = new MappingHeaders();
        JSONObject jobj = objHm.readJsonData(source2);
        objHm.extractJsonData(jobj);
        objHm.configure(source1, output);

    }
}
