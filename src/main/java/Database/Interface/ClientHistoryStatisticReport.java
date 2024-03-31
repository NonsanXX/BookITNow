/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Interface;

import Database.Dataclass.RoomData;
import Database.Dataclass.ClientData;
import Database.Dataclass.TimeDate;
import Database.Dataclass.HistoryData;

import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author phump
 */
public interface ClientHistoryStatisticReport extends StatisticReport {
    
    public abstract DefaultTableModel createDefaultTableModel(Iterable<HistoryData> data);
    
    public abstract ArrayList<HistoryData> readHistory(String ID);

    public abstract void updateHistory(String clientStdID, ArrayList<HistoryData> data);
    
    public abstract boolean addHistory(String ID, HistoryData historyData);
    

}