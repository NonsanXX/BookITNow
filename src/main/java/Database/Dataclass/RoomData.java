/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import static Database.RoomHistoryDatabase.createDefaultTableModel;
import Database.RoomHistoryDatabase;
import Database.Exception.DatabaseGetInterrupted;
import Database.Interface.RoomReservedTime;
import Database.RoomDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.Interface.Cancellation;
/**
 *
 * @author phump
 */
public class RoomData implements RoomReservedTime<JTable>, Cancellation{
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
    
    public RoomData(String roomName, String building, String floor, ArrayList<String> facilityList, ArrayList<TimeRange> openTime, ArrayList<TimeDate> reservedTime, HashMap<String, TimeDate> currentQueue, long capacity, boolean status){
        this.roomName = roomName;
        this.building = building;
        this.floor = floor;
        this.facilityList = facilityList;
        this.openTime = openTime;
        this.reservedTime = reservedTime;
        this.currentQueue = currentQueue;
        this.capacity = capacity;
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

    public boolean getStatus() {
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
    
    public boolean isTimePassed(TimeDate tr){
        TimeDate thisTime = new TimeDate(0.0, TimeDate.getTimeNow(), TimeDate.getDateNow());
        return TimeDate.timeDateCompare(tr, thisTime);
    }
    /**
    * To reserve time, it must satisfy three conditions
    1: Given TimeDate MUST be a subRange of openTime
    2: Given TimeDate MUST not overlap with any reservedTime
    * 
    * 
    * @param tr Given TimeRange
    * @return true if reserving is complete
    */
    public boolean reservingTime(TimeDate tr){
        if(checkReservingTime(tr)){
            reservedTime.add(tr);
            return true;
        }
        return false;
    }
    
    public boolean checkReservingTime(TimeDate tr){
        return isSuperRangeOfOpenTime(tr) && !isOverlapWithReservedTime(tr) && !isTimePassed(tr);
    }
    
    /**
     * Delete TimeRange in reservedTime if there exist TimeRange
     * @param tr Delete TimeRange
     * @return true if there exist TimeRange in reservedTime
     */
    public boolean unReservedTime(TimeDate tr){
        for(TimeDate time : reservedTime){
            if(time.equals(tr)){
                reservedTime.remove(time);
                return true;
            }
        }
        return false;
    }
    
    public boolean deCurrentQueue(TimeDate tr){
        for(String key : currentQueue.keySet()){
            if(currentQueue.get(key).equals(tr)){
                currentQueue.remove(key);
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param timeDate - Date in dateTimeFormatter in format dd/MM/YYYY
     * @param time - Time in 24 hours. Time 12.50 means 12:30
     * @return true if complete update
     * @throws Database.Exception.DatabaseGetInterrupted
     */
    public Boolean updateReservedTime(String timeDate, Double time) throws DatabaseGetInterrupted{
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
        RoomDatabase.updateRoom(this);
        return true;
    }

    @Override
    public JTable report() {
        try{
            JTable table = new JTable(createDefaultTableModel(roomName));
            table.getTableHeader().setReorderingAllowed(false);
            table.setCellSelectionEnabled(false);
            return table;
        } catch(DatabaseGetInterrupted ex){
            return null;
        }
    }

    @Override
    public JTable reservedTimeReport() {
        Object[] columName = {"Date", "Time"};
        try {
            Boolean wait = updateReservedTime(TimeDate.getDateNow(), TimeDate.getTimeNow());
            while(!wait){}
            DefaultTableModel model = new DefaultTableModel(columName, 0);
            ArrayList<TimeDate> sortedTimedate = (ArrayList<TimeDate>) reservedTime.clone();
            Collections.sort(sortedTimedate);
            for(TimeDate time : sortedTimedate){
                Object[] rowData = {time.getTimeDate(), TimeDate.toPoint60(time.getTime1())+" - "+TimeDate.toPoint60(time.getTime2())};
                model.addRow(rowData);
            }
            
            JTable table = new JTable(model);
            table.getTableHeader().setReorderingAllowed(false);
            table.setCellSelectionEnabled(false);
            
            return table;
        } catch (DatabaseGetInterrupted ex) {
            return null;
        }
    }

    @Override
    public boolean cancel(TimeDate reservation) {
        boolean result = false;
        try {
            RoomHistoryDatabase.deleteHistory(roomName, reservation);
            result = unReservedTime(reservation) & deCurrentQueue(reservation);
            RoomDatabase.updateRoom(this);
        } catch (DatabaseGetInterrupted ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
