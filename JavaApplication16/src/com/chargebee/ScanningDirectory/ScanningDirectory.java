/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.ScanningDirectory;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author cb-aashiek
 */
public class ScanningDirectory {
    private static HashMap<String, Integer> hm = new HashMap();
    
    public static void numberOfFiles(File directory) {
        File[] list = directory.listFiles();
        for (File file : list) {
            if (file.isFile()) {
                String extension = "";
                extension = file.toString().substring(file.toString().lastIndexOf(".") + 1);
                System.out.println(extension);
                if (hm.containsKey(extension)) {
                    int tempo = 0;
                    tempo = hm.get(extension);
                    tempo = tempo + 1;
                    hm.put(extension, tempo);
                } else {
                    hm.put(extension, 1);
                }
            } else if (file.isDirectory()) {
                numberOfFiles(file);
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Directory path: ");
        String path = sc.nextLine();
        numberOfFiles(new File(path));
        System.out.println(hm);
    }
}
