/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.CSV;

import com.chargebee.MethodBank.MethodBank;
import static com.chargebee.MethodBank.MethodBank.print;
import static com.chargebee.MethodBank.MethodBank.toArray;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author cb-aashiek
 */
public class RemovingDuplicateEntries {
    
    private void remove(CSVParser parser, CSVPrinter printer) throws Exception {
            
        List<String> list = new ArrayList();
        for (CSVRecord record : parser) {
            String tempo = "";
            String[] s = toArray(record);
            for (String val : s) {
                tempo = tempo + val;
            }
                if (!list.contains(tempo)) {
                    list.add(tempo);
                    printer.printRecord(record);
                }
            }
        }
    

    public static void main(String[] args) throws IOException, Exception {
        String source = System.getProperty("user.home") + "/input.csv";
        String output = System.getProperty("user.home") + "/output.csv";

        RemovingDuplicateEntries rde = new RemovingDuplicateEntries();

        CSVParser parser = MethodBank.parserInitializer(source);
        CSVPrinter printer = MethodBank.printerInitializer(output);
        

        rde.remove(parser, printer);
        parser.close();
        printer.close();

    } 
}
