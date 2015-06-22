/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.ScanningDirectory;

import static com.chargebee.ScanningDirectory.ReadingWords.tm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author cb-aashiek
 */
public class FindingWords {

public static HashMap<Integer, ArrayList<Integer>> hm = new HashMap();   
public static Integer lineCount=0;
public static Integer startIndex;

    public static void findingWords(File file, String word, PrintStream fileStream) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            lineCount = lineCount+1;
            String[] tokens = line.split("\\s+");
            print(tokens, word);
        }
        writeFile(fileStream);
    }

    public static void print(String[] tokens, String word) {
        startIndex = 0;
        ArrayList<Integer> list = new ArrayList();
        
        for (String s : tokens) {
            startIndex = startIndex + 1;
            if (s.equalsIgnoreCase(word)) {
                list.add(startIndex);
            }
        }
        hm.put(lineCount, list);
        System.out.println(hm);
    }

    public static void writeFile(PrintStream fileStream) throws IOException {
        Iterator iterator1 = (Iterator) hm.keySet().iterator();
        Iterator iterator2 = (Iterator) tm.values().iterator();
        while (iterator1.hasNext()) {
            String keyTempo = iterator1.next().toString();
            fileStream.println(keyTempo + " : " + hm.get(Integer.parseInt(keyTempo)));

        }

        fileStream.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input File path: ");
        String path = sc.nextLine();
        
        System.out.println("Word that needs to be searched for: ");
        String word = sc.nextLine();
        
        String path2 = path + word;
        PrintStream fileStream = new PrintStream(path2);
        
        findingWords(new File(path), word, fileStream);
    }
}
