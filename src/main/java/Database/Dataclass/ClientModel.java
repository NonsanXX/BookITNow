/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import java.util.HashMap;
/**
 *
 * @author phump
 * @param <PrimaryKey>
 */
public abstract class ClientModel<PrimaryKey>{
    public final PrimaryKey key;
    
    public ClientModel(PrimaryKey key){
        this.key = key;
    }
    
    public PrimaryKey getKey(){
        return key;
    }
    
    public abstract HashMap<String, Object> toHashMap();
}
