/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Exception;

/**
 *
 * @author phump
 */
public class DatabaseGetInterrupted extends Exception{
    public DatabaseGetInterrupted(){
        this("");
    }
    
    public DatabaseGetInterrupted(String s){
        super(s);
    }
}
