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
public class RoomData{
    private String roomName;
    private ArrayList<String> facilityList;
    private String roomDescription;
    private ArrayList<TimeRange> openTime;
    private ArrayList<TimeRange> reservedTime;
    private HashMap<String, TimeRange> currentQueue;
    private int capacity;
    public RoomData(){
        this("", null, "", null, null, null);
    }
    
    public RoomData(String roomName, ArrayList<String> facilityList, String roomDescription, ArrayList<TimeRange> openTime, ArrayList<TimeRange> reservedTime, HashMap<String, TimeRange> currentQueue){
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

    public ArrayList<TimeRange> getOpenTime() {
        return openTime;
    }

    public void setOpenTime(ArrayList<TimeRange> openTime) {
        this.openTime = openTime;
    }

    public boolean checkOpenTime(TimeRange checkTime){
        for(TimeRange tr : openTime){
            if(tr.isSuperRange(checkTime)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkOpenTimeList(ArrayList<TimeRange> checkTimeRange){
        for(TimeRange tr : checkTimeRange){
            if(!checkOpenTime(tr)){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<TimeRange> getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(ArrayList<TimeRange> reservedTime) {
        this.reservedTime = reservedTime;
    }

    public HashMap<String, TimeRange> getCurrentQueue() {
        return currentQueue;
    }
    
    public void setCurrentQueue(HashMap<String, TimeRange> currentQueue) {
        this.currentQueue = currentQueue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean isSuperRangeOfOpenTime(TimeRange tr){
        for(TimeRange open : openTime){
            if(open.isSuperRange(tr)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isOverlapWithReservedTime(TimeRange tr){
        for(TimeRange reserved : reservedTime){
            if(reserved.isOverlap(tr)){
                return true;
            }
        }
        return false;
    }
    /**
    * To reserve time, it must satisfy three conditions
    1: Given TimeRange MUST be a subRange of openTime
    2: Given TimeRange MUST not overlap with any reservedTime
    3: Reservation MUST not exceed room capacity
    * 
    * 
    * @param tr Given TimeRange
    * @return true if reserving is complete
    */
    public boolean reservingTime(TimeRange tr){
        if(isSuperRangeOfOpenTime(tr) && !isOverlapWithReservedTime(tr) && reservedTime.size() < capacity){
            reservedTime.add(tr);
            return true;
        }
        return false;
    }
    
    /**
     * Delete TimeRange in reservedTime if there exist TimeRange
     * @param tr Delete TimeRange
     * @return true if there exist TimeRange in reservedTime
     */
    public boolean unReservedTime(TimeRange tr){
        if(!reservedTime.contains(tr)){
            return false;
        }
        reservedTime.remove(tr);
        return true;
    }
    /**
     * 
     * @param time - Time in 24 hours. Time 12.50 means 12:30
     */
    public void updateReservedTime(Double time){
        for(TimeRange tr : reservedTime){
            if(tr.getTime2() > time){
                unReservedTime(tr);
            }
        }
    }
}
