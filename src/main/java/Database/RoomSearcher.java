/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.RoomDatabase.filter;
import Database.Dataclass.RoomData;
import Database.Dataclass.TimeRange;
import Database.Exception.DatabaseGetInterrupted;

import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phump
 */
public class RoomSearcher extends JPanel implements ActionListener{
    public JTextField roomName, building, floor, capacity, openTime, closeTime;
    public JList<String> list;
    public JButton search;
    public RoomSearcher(){
        roomName = new JTextField(15);
        building = new JTextField(15);
        floor = new JTextField(3);
        capacity = new JTextField(5);
        openTime = new JTextField(4);
        closeTime = new JTextField(4);
        search = new JButton("Search");
        
        String[] item = {"TV", "White Board", "USB Charger", "Projector", "VR Headset", "Speaker", "Wi-Fi", "Computer"};
        list = new JList<>(item);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(1);
        
        add(new JLabel("Room Name: "));
        add(roomName);
        add(new JLabel("Facility List: "));
        add(list);
        add(new JLabel("Building: "));
        add(building);
        add(new JLabel("Floor: "));
        add(floor);
        add(new JLabel("Capacity: "));
        add(capacity);
        add(new JLabel("OpenTime: "));
        add(openTime);
        add(new JLabel(" - "));
        add(closeTime);
        add(search);
        
        search.addActionListener(this);
    }
    
    /**
     * On clicking Search button it will fetch data in declared textField
     * and it return RoomData from given value on the textField
     * @return 
     */
    public RoomData onSearch(){
        RoomData desirableRoom = new RoomData();
        desirableRoom.setRoomName(roomName.getText());
        ArrayList<String> faclist = new ArrayList<>();
        for(String selected : list.getSelectedValuesList()){
            faclist.add(selected);
        }
        if(faclist.isEmpty()){
            faclist = null;
        }
        desirableRoom.setFacilityList(faclist);
        desirableRoom.setBuilding(building.getText());
        desirableRoom.setFloor(floor.getText());
        try{
            desirableRoom.setCapacity(Long.parseLong(capacity.getText()));
        } catch(NumberFormatException ex){
            desirableRoom.setCapacity(0);
        }
        ArrayList<TimeRange> openTimeRange = null;
        try{
            openTimeRange = new ArrayList<>();
            TimeRange tr = new TimeRange();
            Double time1 = Double.valueOf(openTime.getText());
            Double time2 = Double.valueOf(closeTime.getText());
            tr.setTime1(Math.floor(time1)+time1%1/0.6);
            tr.setTime2(Math.floor(time2)+time2%1/0.6);
            openTimeRange.add(tr);
        } catch(NumberFormatException ex){
            desirableRoom.setOpenTime(null);
        }
        if(openTimeRange == null || openTimeRange.isEmpty()){
            openTimeRange = null;
        }
        desirableRoom.setOpenTime(openTimeRange);
        return desirableRoom;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RoomSearcher());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomData rm = onSearch();
        System.out.println(rm.getRoomName());
        System.out.println(rm.getBuilding());
        System.out.println(rm.getFloor());
        System.out.println(rm.getFacilityList());
        System.out.println(rm.getCapacity());
        System.out.println(rm.getOpenTime().get(0).getTime1());
        System.out.println(rm.getOpenTime().get(0).getTime2());
    }
}
