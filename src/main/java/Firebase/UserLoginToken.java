/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Firebase;
import Database.Dataclass.ClientData;
/**
 * This class is to keep track at the user login session
 * @author phump
 */
public final class UserLoginToken{
    private static ClientData client;
    
    public static String getClientID(){
        return client.getStudentID();
    }
    
    public static void loginUser(ClientData client){
        UserLoginToken.client = client;
    }
    
    public static void logoutUser(){
        UserLoginToken.client = null;
    }
}
