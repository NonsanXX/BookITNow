/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import static Database.ClientHistoryDatabase.createDefaultTableModel;
import Database.Exception.DatabaseGetInterrupted;
import Database.Interface.StatisticReport;

import javax.swing.*;

import java.util.HashMap;

/**
 *
 * @author phump
 */
public class ClientData implements StatisticReport<Object>{

    /**
     *
     */
    public static final String FIELD_THAI_NAME = "thaiName";
    public static final String FIELD_THAI_SURNAME = "thaiSurname";
    public static final String FIELD_ENGLISH_NAME = "englishName";
    public static final String FIELD_ENGLISH_SURNAME = "englishSurname";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_STUDENT_ID = "studentID";
    public static final String FIELD_PASSCODE = "passcode";
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
    private boolean isSecure;
    
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
    
    public ClientData(HashMap<String, Object> fieldMap){
        this.thaiName = (String) fieldMap.get(FIELD_THAI_NAME);
        this.thaiSurname = (String) fieldMap.get(FIELD_THAI_SURNAME);
        this.englishName = (String) fieldMap.get(FIELD_ENGLISH_NAME);
        this.englishSurname = (String) fieldMap.get(FIELD_ENGLISH_SURNAME);
        this.email = (String) fieldMap.get(FIELD_EMAIL);
        this.studentID = (String) fieldMap.get(FIELD_STUDENT_ID);
        this.passcode = hashing((String) fieldMap.get(FIELD_PASSCODE));
        this.accessLevel = (long) fieldMap.get(FIELD_ACCESS_LEVEL);
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
        return passcode.length() < 64 ? org.apache.commons.codec.digest.DigestUtils.sha256Hex(passcode) : passcode;
    }

    public HashMap<String, Object> toHashMap(){
        /**
         * @return HashMap between Field and it's value
         */
        HashMap<String, Object> h = new HashMap<>();
        h.put(FIELD_THAI_NAME, thaiName);
        h.put(FIELD_THAI_SURNAME, thaiSurname);
        h.put(FIELD_ENGLISH_NAME, englishName);
        h.put(FIELD_ENGLISH_SURNAME, englishSurname);
        h.put(FIELD_EMAIL, email);
        h.put(FIELD_STUDENT_ID, studentID);
        h.put(FIELD_PASSCODE, passcode);
        h.put(FIELD_ACCESS_LEVEL, accessLevel);
        return h;
    }
    
    @Override
    public JFrame report() {
        try{
            JFrame frame = new JFrame();
            JTable table = new JTable(createDefaultTableModel(studentID));
            table.getTableHeader().setReorderingAllowed(false);
            table.setCellSelectionEnabled(false);
            
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            return frame;
        } catch(DatabaseGetInterrupted ex){
            return null;
        }
    }
}
