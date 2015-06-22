/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.ScanningDirectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author cb-aashiek
 */
public class ReadingWords {
    public static TreeMap<String, Integer> tm = new TreeMap();
    
    public static void countingWords(File file) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            print(tokens);
        }
    }

    public static void print(String[] tokens) {
        for(String s : tokens) {
            if(tm.containsKey(s)) {
               int t = tm.get(s);
               t = t+1;
               tm.put(s, t);
            }
            else {
                tm.put(s,1);
            }
        }        
    }
    
    public static void writeFile(File file) throws IOException {
        PrintStream fileStream = new PrintStream(file.getPath());
        Iterator iterator2 = (Iterator) tm.values().iterator();
        Iterator iterator1 = (Iterator) tm.keySet().iterator();
        while (iterator1.hasNext()) {
            String keyTempo = iterator1.next().toString();
            String valueTempo = iterator2.next().toString();
            fileStream.println(keyTempo + " : " + valueTempo);
            
        }
        
        fileStream.close();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input File path: ");
        String path = sc.nextLine();
        System.out.println("Output File Path: ");
        String path2 = sc.nextLine();
        countingWords(new File(path));
        writeFile(new File(path2));
        System.out.println(tm);
    }
}
