/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Exception;

/**
 *
 * @author phump
 */
public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(){
        this("");
    }
    
    public ClientNotFoundException(String s){
        super(s);
    }
}
