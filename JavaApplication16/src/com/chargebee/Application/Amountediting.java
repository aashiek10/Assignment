/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.Application;

import com.chargebee.MethodBank.MethodBank;
import com.chargebee.org.json.JSONObject;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class Amountediting {

    private static Integer amountColumnIndex = null;
    private static Integer refundColumnIndex = null;
    private static Integer taxColumnIndex = null;

    public void formatter(CSVParser parser, CSVPrinter printer, JSONObject jobj) throws Exception {

        String refund_column_header = jobj.getString("refund_column_header");
        String tax_column_header = jobj.getString("tax_column_header");
        String amount_column_header = jobj.getString("amount_column_header");
        boolean isHeader = true;

        for (CSVRecord record : parser) {
            String[] s = MethodBank.toArray(record);
            if (isHeader) {
                amountColumnIndex = MethodBank.indexFinder(s, amount_column_header);
                refundColumnIndex = MethodBank.indexFinder(s, refund_column_header);
                taxColumnIndex = MethodBank.indexFinder(s, tax_column_header);
                MethodBank.print(printer, s);
                isHeader = false;
                continue;
            }
            int tempo = 0;
            float tempo2 = 0;
            tempo = Integer.parseInt(s[amountColumnIndex]);
            tempo2 = tempo / 100;
            s[amountColumnIndex] = Float.toString(tempo2);

            tempo = Integer.parseInt(s[refundColumnIndex]);
            tempo2 = tempo / 10;
            s[refundColumnIndex] = Float.toString(tempo2);

            tempo = Integer.parseInt(s[taxColumnIndex]);
            tempo2 = tempo / 100;
            s[taxColumnIndex] = Float.toString(tempo2);

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

        Amountediting ae = new Amountediting();
        JSONObject jobj = MethodBank.readJsonObjectData(requirements);
        CSVParser parser = MethodBank.parserInitializer(source);
        CSVPrinter printer = MethodBank.printerInitializer(output);

        ae.formatter(parser, printer, jobj);
        parser.close();
        printer.close();

    }
}
