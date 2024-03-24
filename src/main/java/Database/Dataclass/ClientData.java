/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import java.util.HashMap;

/**
 *
 * @author phump
 */
public class ClientData {
    private String thaiName;
    private String thaiSurname;
    private String englishName;
    private String englishSurname;
    private String email;
    private String studentID;
    private String passcode;
    
    public ClientData(){
        this("", "", "", "", "", "", "");
    }

    public ClientData(String thaiName, String thaiSurname, String englishName, String englishSurname, String email, String StudentID, String passcode) {
        this.thaiName = thaiName;
        this.thaiSurname = thaiSurname;
        this.englishName = englishName;
        this.englishSurname = englishSurname;
        this.email = email;
        this.studentID = StudentID;
        this.passcode = hashing(passcode);
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

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = hashing(passcode);
    }
    
    public boolean comparePasscode(String passcode){
        return hashing(passcode).equals(passcode);
    }
    
    public static String hashing(String passCode){
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(passCode);
    }
    
    public HashMap<String, String> toHashMap(){
        HashMap<String, String> h = new HashMap<>();
        h.put("thaiName", thaiName);
        h.put("thaiSurname", thaiSurname);
        h.put("englishName", englishName);
        h.put("englishSurname", englishSurname);
        h.put("email", email);
        h.put("stdID", studentID);
        h.put("passcode", passcode);
        return h;
    }
}
