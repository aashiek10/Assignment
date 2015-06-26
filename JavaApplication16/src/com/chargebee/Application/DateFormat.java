/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.Application;

import com.chargebee.MethodBank.MethodBank;
import com.chargebee.org.json.JSONObject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class DateFormat {
    private static Integer columnIndex = null;


    public void formatter(CSVParser parser, CSVPrinter printer, JSONObject jobj) throws Exception {
        
        String date_format = jobj.getString("date_format");
        String column_header = jobj.getString("column_header");
        boolean isHeader = true;
        
        for (CSVRecord record : parser) {
            String[] s = MethodBank.toArray(record);
            if (isHeader) {
                columnIndex = MethodBank.indexFinder(s,column_header);
                MethodBank.print(printer, s);
                isHeader = false;
                continue;
            }

            String dateToPrint = "";
            SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat(date_format);
            SimpleDateFormat simpleDateFormatOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (record.get(columnIndex) != null && !record.get(columnIndex).equals("")) {
                Date date = simpleDateFormatInput.parse(record.get(columnIndex));
                dateToPrint = simpleDateFormatOutput.format(date);
                s[columnIndex] = dateToPrint;
            } 

            MethodBank.print(printer, s);

        }
    }
       public static void main(String[] args) throws IOException, Exception {
          Scanner sc = new Scanner(System.in);
        System.out.println("Input CSV File: ");
        String source = sc.nextLine();

        System.out.println("Input JSON File: ");
        String requirements = sc.nextLine();

        System.out.println("Output CSV File: ");
        String output = sc.nextLine();
        
        DateFormat df = new DateFormat();
        JSONObject jobj = MethodBank.readJsonObjectData(requirements); 
        CSVParser parser = MethodBank.parserInitializer(source);
        CSVPrinter printer = MethodBank.printerInitializer(output);
        
        df.formatter(parser, printer, jobj);
        parser.close();
        printer.close();

    }
}
