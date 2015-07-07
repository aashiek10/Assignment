/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.Application;

import com.chargebee.org.json.JSONArray;
import com.chargebee.org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class MappingHeaders {
    private static List<Integer> colNumber = new ArrayList();
    private static ArrayList<String> listData = new ArrayList();
    
    private JSONObject readJsonData(String fileName2) throws Exception { //processes the Json array and returns in the required format. 
        File f = new File(fileName2);
        FileInputStream fr = new FileInputStream(f);
        byte[] b = new byte[fr.available()];
        fr.read(b);
        //JSONArray jarr = new JSONArray(new String(b));
        JSONObject jobj = new JSONObject(new String(b));
        return jobj; // The required Json object

    }

    private void extractJsonData(JSONObject jobj, CSVPrinter printer, CSVParser parser) throws Exception { //Extracts the customer_id and token nad stores them in the HashMap hm as key-value pair.
        ArrayList<String> listMerger = new ArrayList();
        Map map = parser.getHeaderMap();
        System.out.println(map);
        Iterator iterator = jobj.keys();
        
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            JSONArray tempo = jobj.getJSONArray(key);
            
            if(tempo.getString(1).equals("print")){
                if(map.containsKey(tempo.getString(0))) { 
                    colNumber.add((int)map.get(tempo.getString(0)));
                    map.put(tempo.getString(0),key);
                    
            } }
            
            else if(tempo.getString(1).equals("merge")){
                JSONArray merging = tempo.getJSONArray(0);
                for (int i=0;  i<merging.length(); i++){ 
                listMerger.add(merging.getString(i));
                if(map.containsKey(merging.getString(i))){
                    map.remove(merging.getString(i));
                }
                }
                map.put("merge", key);
            }
            
        }
        System.out.println(map);
        Collection headers = map.values();
        System.out.println(headers);
        System.out.println(colNumber);
        print(headers,printer);
        validateAndWrite(parser,printer,listMerger);
    }

    private void validateAndWrite(CSVParser parser, CSVPrinter printer, ArrayList listMerger) throws IOException {
        
        for (CSVRecord record : parser) {
            
            List<String> tempo = new ArrayList();
            List<String> tempoMerge = new ArrayList();
            int i = -1;

            for (String str : record) {
                i = i + 1;
                if (colNumber.contains(i)) {
                    tempo.add(str);
                } else {
                    tempoMerge.add(str); 
                }
            }
            String t = "{";
            for (int j = 0; j < listMerger.size(); ++j) {
                t = t + '"' + listMerger.get(j) + '"' + " : " + '"' + tempoMerge.get(j) + '"';
            }
            tempo.add(t);
            print(tempo, printer);
        }
    }


    private void print(Collection list, CSVPrinter printer) throws IOException {
        printer.printRecord(list);
    }

    public static void main(String[] args) throws Exception {
        String source1 = System.getProperty("user.home") + "/Output-3.csv"; // Source CSV file containing the customer details 
        String source2 = System.getProperty("user.home") + "/header.json";//Json file containing the customer id and token
        String output = System.getProperty("user.home") + "/Output-4.csv";// The destination CSV file.
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input CSV File: ");
//        String source1 = sc.nextLine();
//
//        System.out.println("config File: ");
//        String source2 = sc.nextLine();
//
//        System.out.println("Output CSV File: ");
//        String output = sc.nextLine();
//        
        
        MappingHeaders objHm = new MappingHeaders();
        JSONObject jobj = objHm.readJsonData(source2);
        CSVPrinter printer = new CSVPrinter(new FileWriter(output), CSVFormat.EXCEL.withRecordSeparator("\n").withDelimiter(','));
        CSVParser parser = new CSVParser(new FileReader(source1), CSVFormat.EXCEL.withHeader());
        objHm.extractJsonData(jobj, printer, parser);
        parser.close();
        printer.close();

    }
}
