/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import static Database.RoomHistoryDatabase.createDefaultTableModel;
import Database.Exception.DatabaseGetInterrupted;
import Database.Interface.StatisticReport;

import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author phump
 */
public class RoomData implements StatisticReport<JFrame>{
    private String roomName;
    private String building;
    private String floor;
    private ArrayList<String> facilityList;
    private ArrayList<TimeRange> openTime;
    private ArrayList<TimeDate> reservedTime;
    private HashMap<String, TimeDate> currentQueue;
    private long capacity;
    private boolean status;
    
    public RoomData(){
        this("", "", "", null, null, null, null, 0l, false);
    }
    
    public RoomData(String roomName, String building, String floor, ArrayList<String> facilityList, ArrayList<TimeRange> openTime, ArrayList<TimeDate> reservedTime, HashMap<String, TimeDate> currentQueue, long capaity, boolean status){
        this.roomName = roomName;
        this.building = building;
        this.floor = floor;
        this.facilityList = facilityList;
        this.openTime = openTime;
        this.reservedTime = reservedTime;
        this.currentQueue = currentQueue;
        this.capacity = capaity;
        this.status = status;
    }
    

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    public ArrayList<String> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(ArrayList<String> facilityList) {
        this.facilityList = facilityList;
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
    
    public ArrayList<TimeDate> getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(ArrayList<TimeDate> reservedTime) {
        this.reservedTime = reservedTime;
    }
    
    public HashMap<String, TimeDate> getCurrentQueue() {
        return currentQueue;
    }
    
    public void setCurrentQueue(HashMap<String, TimeDate> currentQueue) {
        this.currentQueue = currentQueue;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean isSuperRangeOfOpenTime(TimeRange tr){
        for(TimeRange open : openTime){
            if(open.isSuperRange(tr)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isOverlapWithReservedTime(TimeDate tr){
        for(TimeDate reserved : reservedTime){
            if(reserved.isOverlap(tr)){
                return true;
            }
        }
        return false;
    }
    /**
    * To reserve time, it must satisfy three conditions
    1: Given TimeDate MUST be a subRange of openTime
    2: Given TimeDate MUST not overlap with any reservedTime
    3: Reservation MUST not exceed room capacity
    * 
    * 
    * @param tr Given TimeRange
    * @return true if reserving is complete
    */
    public boolean reservingTime(TimeDate tr){
        if(isSuperRangeOfOpenTime(tr) && !isOverlapWithReservedTime(tr) && reservedTime.size() < capacity){
            reservedTime.add(tr);
            return true;
        }
        return false;
    }
    
    public boolean checkReservingTime(TimeDate tr){
        return isSuperRangeOfOpenTime(tr) && !isOverlapWithReservedTime(tr) && reservedTime.size() < capacity;
    }
    
    /**
     * Delete TimeRange in reservedTime if there exist TimeRange
     * @param tr Delete TimeRange
     * @return true if there exist TimeRange in reservedTime
     */
    public boolean unReservedTime(TimeDate tr){
        if(!reservedTime.contains(tr)){
            return false;
        }
        reservedTime.remove(tr);
        return true;
    }
    /**
     * 
     * @param timeDate - Date in dateTimeFormatter in format dd/MM/YYYY
     * @param time - Time in 24 hours. Time 12.50 means 12:30
     */
    public void updateReservedTime(String timeDate, Double time){
        TimeDate tester = new TimeDate(0.0, time, timeDate);
        Iterator<TimeDate> reservedTimeIterator = reservedTime.iterator();
        while(reservedTimeIterator.hasNext()){
            TimeDate tr = reservedTimeIterator.next();
            if(TimeDate.timeDateCompare(tr, tester)){
                reservedTimeIterator.remove();
            }
        }
        
        Iterator<Map.Entry<String, TimeDate>> currentQueueIterator = currentQueue.entrySet().iterator();
        while(currentQueueIterator.hasNext()){
            Map.Entry<String, TimeDate> entry = currentQueueIterator.next();
            if(TimeDate.timeDateCompare(entry.getValue(), tester)){
                currentQueueIterator.remove();
            }
        }
    }

    @Override
    public JFrame report() {
        try{
            JFrame frame = new JFrame(roomName);
            JTable table = new JTable(createDefaultTableModel(roomName));
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
