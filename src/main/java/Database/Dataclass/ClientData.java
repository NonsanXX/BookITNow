/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import Database.Exception.ClientDataConstructureException;

import java.util.HashMap;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phump
 */
public class ClientData {
    public static final String FIELD_THAI_NAME = "thaiName";
    public static final String FIELD_THAI_SURNAME = "thaiSurname";
    public static final String FIELD_ENGLISH_NAME = "englishName";
    public static final String FIELD_ENGLISH_SURNAME = "englishSurname";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_ACCESS_LEVEL = "accessLevel";
    
    public static final long accessLevelClient = 0l;
    public static final long accessLevelAdmin = 1l;
    
    private String thaiName;
    private String thaiSurname;
    private String englishName;
    private String englishSurname;
    private String email;
    private String studentID;
    private String passcode;
    private long accessLevel;
    
    public ClientData(){
        this("", "", "", "", "", "", "", 0);
    }

    public ClientData(String thaiName, String thaiSurname, String englishName, String englishSurname, String email, String StudentID, String passcode, int accessLevel) {
        this.thaiName = thaiName;
        this.thaiSurname = thaiSurname;
        this.englishName = englishName;
        this.englishSurname = englishSurname;
        this.email = email;
        this.studentID = StudentID;
        this.passcode = hashing(passcode);
        this.accessLevel = accessLevel;
    }
    
    public ClientData(HashMap<String, Object> fieldMap) throws ClientDataConstructureException{
        try {
            for(String s : fieldMap.keySet()){
                getClass().getDeclaredField(s).set(this, fieldMap.get(s));
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            throw new ClientDataConstructureException("Invalid fieldName or Invalid fieldType.");
        }
    }
    
    public String getThaiName() {
        return thaiName;
    }

    public void setThaiName(String thaiName) {
        this.thaiName = thaiName;
    }

    public String getThaiSurname() {
        return thaiSurname;
    }

    public void setThaiSurname(String thaiSurname) {
        this.thaiSurname = thaiSurname;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishSurname() {
        return englishSurname;
    }

    public void setEnglishSurname(String englishSurname) {
        this.englishSurname = englishSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String StudentID) {
        this.studentID = StudentID;
    }
    
    public long getAccessLevel(){
        return accessLevel;
    }
    
    public void setAccessLevel(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = hashing(passcode);
    }
    
    public boolean comparePasscode(String passcode){
        return hashing(passcode).equals(this.passcode);
    }
    
    public static String hashing(String passcode){
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(passcode);
    }

    public HashMap<String, Object> toHashMap(){
        /**
         * @return HashMap between Field and it's value
         */
        HashMap<String, Object> h = new HashMap<>();
        Class<?> thisObject = getClass();
        Field[] fields = thisObject.getDeclaredFields();
        for(Field field : fields){
            try {
                h.put(field.getName(), field.get(this));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(ClientData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return h;
    }
}
