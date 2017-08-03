/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bcapp;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author xavyr
 */
public class FileHexConverter {
    public String fileToHex(File file){
        StringBuilder result = new StringBuilder();
        
        Path p = file.toPath();
        try{
            byte[] data = Files.readAllBytes(p);
            for(byte b : data){
                result.append(String.format("%02x", b));
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        return result.toString();
    }
    
    public byte[] hexToBytes(String hex){
        int len = hex.length();
        byte[] data = new byte[len/2];
        for(int i = 0; i < len; i += 2){
            data[i/2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        
        return data;
    }
    
    public void writeHexToFile(String hex, String pathToFile){
        byte[] bytes = hexToBytes(hex);
        
        try{
            RandomAccessFile file = new RandomAccessFile(pathToFile, "rw");
            file.write(bytes);
            file.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
