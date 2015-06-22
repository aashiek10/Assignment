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
public class ScanningMoving {
    
private static HashMap<String, Integer> hm = new HashMap();
    
    public static void numberOfFiles(File directory) {
        File[] list = directory.listFiles();
        for (File file : list) {
            
            String extension = file.toString().substring(file.toString().lastIndexOf(".") + 1);
            String fileName = file.getName().substring(0, file.getName().lastIndexOf(".")+1);
            String tempo = file.getName();
            System.out.println(fileName + "->" + extension);
            int i = 0;
            
            if (file.isFile()) {
                /*while ((!file.renameTo(new File("/home/cb-aashiek/Music/MovedFiles/" + (fileName+extension))))) {
                    i = i+1;
                    fileName = fileName+i;
                    System.out.println("Inside while loop!!");
                    System.out.println(tempo);
                }*/
                String ex="";
                String fn=file.getName();
                while(true){
                    
                    if(new File("/home/cb-aashiek/Music/MovedFiles/"+fn.substring(0,fn.lastIndexOf("."))+ex+fn.substring(fn.lastIndexOf(".",fn.length()))).exists()){
                
                        ex="-"+i++;
                        
                    }else{
                    
                        file.renameTo(new File("/home/cb-aashiek/Music/MovedFiles/"+fn.substring(0,fn.lastIndexOf("."))+ex+fn.substring(fn.lastIndexOf(".",fn.length()))));
                        i=1;
                        ex="";
                        break;
                    }   
                    
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

