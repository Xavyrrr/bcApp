/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NonFrames;

import com.google.gson.Gson;

/**
 *
 * @author xavyr
 */
public class FileMetadata {
    public String sender;
    public String location;
    public String hash;
    public boolean valid; 
    public String assetName;
    public String signer;
    
    public FileMetadata(){
        this.sender = "";
        this.location = "";
        this.hash = "";
    }
    
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public static FileMetadata fromJson(String json){
        try{
            Gson gson = new Gson();
            FileMetadata fmd = gson.fromJson(json, FileMetadata.class);
            fmd.valid = true;
        return fmd;
        } catch(Exception e){
            return new FileMetadata();
        }
        
    }
    
}
