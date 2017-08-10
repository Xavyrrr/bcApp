/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NonFrames;

import java.io.File;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author xavyr
 */
public class FileHexConverter {
    public String bytesToBase64(byte[] bytes){
        String result = "";
        result = new String(new Base64().encode(bytes));

        return result;
    }
    
    public byte[] fileToBytes(File file){
        Path p = file.toPath();
        try{
            return Files.readAllBytes(p);
            
        }catch(Exception e ){
            e.printStackTrace();
        }
        return new byte[1];
    }
    
    public String base64ToHex(String base){
        String result = "";
        result = Hex.encodeHexString(base.getBytes());
        return result;
    }
    
    public String hexToBase64(String hex){
        String result = "";
        try{
            result = new String(Hex.decodeHex(hex.toCharArray()));
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public byte[] Base64ToBytes(String base){
        byte[] data = Base64.decodeBase64(base);
        
        return data;
    }
    
    public String stringToHex(String arg){
        return Hex.encodeHexString(arg.getBytes());
        //return String.format("%040x", new BigInteger(1, arg.getBytes()));
    }
    
    public String hexToString(String arg){
        try{
        return new String(Hex.decodeHex(arg.toCharArray()), "UTF-8");
        } catch(Exception e){
            
        }
        return "";
    }
    
    public String fileToHex(File file){
        StringBuilder result = new StringBuilder();
        
       /* Path p = file.toPath();
        try{
            byte[] data = Files.readAllBytes(p);
            for(byte b : data){
                result.append(String.format("%02x", b));
            }
        }catch(Exception e ){
            e.printStackTrace();
        }*/
        
        Path p = file.toPath();
        try{
            byte[] data = Files.readAllBytes(p);
            String base = bytesToBase64(data);
            //String hex = base64ToHex(base);
            String hex = stringToHex(base);
            result.append(hex);
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
     //   byte[] bytes = hexToBytes(hex);
        String base = hexToBase64(hex);
        byte[] bytes = Base64ToBytes(base);
        
        try{
            RandomAccessFile file = new RandomAccessFile(pathToFile, "rw");
            file.write(bytes);
            file.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
