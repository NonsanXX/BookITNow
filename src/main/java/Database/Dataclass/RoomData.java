/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import java.util.ArrayList;
/**
 *
 * @author phump
 */
public class RoomData {
    private String roomName;
    private ArrayList<String> facilityList;
    private String roomDescription;
    private ArrayList<timeRange> availableTime;
    
    public RoomData(){
        this("", null, "", null);
    }
    
    public RoomData(String roomName, ArrayList<String> facilityList, String roomDescription, ArrayList<timeRange> availableTime){
        this.roomName = roomName;
        this.facilityList = facilityList;
        this.roomDescription = roomDescription;
        this.availableTime = availableTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<String> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(ArrayList<String> facilityList) {
        this.facilityList = facilityList;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    
    public ArrayList<timeRange> getAvailableTime(){
        return availableTime;
    }
    
    public void setAvailableTime(ArrayList<timeRange> availableTime){
        this.availableTime = availableTime;
    }
}
