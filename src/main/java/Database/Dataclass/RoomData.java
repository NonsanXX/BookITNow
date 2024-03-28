/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author phump
 */
public class RoomData {
    private String roomName;
    private ArrayList<String> facilityList;
    private String roomDescription;
    private ArrayList<timeRange> openTime;
    private ArrayList<timeRange> reservedTime;
    private HashMap<String, timeRange> currentQueue;
    public RoomData(){
        this("", null, "", null, null, null);
    }
    
    public RoomData(String roomName, ArrayList<String> facilityList, String roomDescription, ArrayList<timeRange> openTime, ArrayList<timeRange> reservedTime, HashMap<String, timeRange> currentQueue){
        this.roomName = roomName;
        this.facilityList = facilityList;
        this.roomDescription = roomDescription;
        this.openTime = openTime;
        this.reservedTime = reservedTime;
        this.currentQueue = currentQueue;
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

    public ArrayList<timeRange> getOpenTime() {
        return openTime;
    }

    public void setOpenTime(ArrayList<timeRange> openTime) {
        this.openTime = openTime;
    }

    public ArrayList<timeRange> getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(ArrayList<timeRange> reservedTime) {
        this.reservedTime = reservedTime;
    }

    public HashMap<String, timeRange> getCurrentQueue() {
        return currentQueue;
    }

    public void setCurrentQueue(HashMap<String, timeRange> currentQueue) {
        this.currentQueue = currentQueue;
    }
    
    public boolean isSuperRangeOfOpenTime(timeRange tr){
        for(timeRange open : openTime){
            if(open.isSuperRange(tr)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isOverlapWithReservedTime(timeRange tr){
        for(timeRange reserved : reservedTime){
            if(reserved.isOverlap(tr)){
                return true;
            }
        }
        return false;
    }
    /**
    * To reserve time, it must satisfy two conditions
    * 1: Given timeRange MUST be a subRange of openTime
    * 2: Given timeRange MUST not overlap with any reservedTime
    * 
    * @param tr Given timeRange
    * @return true if reserving is complete
    */
    public boolean reservingTime(timeRange tr){
        if(isSuperRangeOfOpenTime(tr) && !isOverlapWithReservedTime(tr)){
            reservedTime.add(tr);
            return true;
        }
        return false;
    }
    
    /**
     * Delete timeRange in reservedTime if there exist timeRange
     * @param tr Delete timeRange
     * @return true if there exist timeRange in reservedTime
     */
    public boolean unReservedTime(timeRange tr){
        if(!reservedTime.contains(tr)){
            return false;
        }
        reservedTime.remove(tr);
        return true;
    }
}
