/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Dataclass.ClientData;
import Database.Dataclass.RoomData;
import Database.Dataclass.HistoryData;
import Database.Dataclass.TimeDate;
import Database.Exception.DatabaseGetInterrupted;
import javax.swing.table.DefaultTableModel;

import Database.Interface.ClientHistoryStatisticReport;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phump
 */
public class ClientHistoryDatabase extends Database{
    private static final String HISTORY_FIELD_NAME = "table";
    public static final Object[] columName = {"RID", "TimeStamp", "Reservation detail", "Room"};
    
    public static DefaultTableModel createDefaultTableModel(ArrayList<HistoryData> data){
        DefaultTableModel table = new DefaultTableModel(columName, 0);
        int rowCount = 1;
        for(HistoryData historyData : data){
            table.addRow(new Object[]{rowCount, historyData.getTimeStamp(), historyData.getTimeDate(), historyData.getRecorded()});
            rowCount += 1;
        }
        return table;
    };
    
    public static ArrayList<HistoryData> readHistory(String clientStdID) throws DatabaseGetInterrupted{
        try {
            ArrayList<HistoryData> returnVar = new ArrayList<>();
            HashMap<String, Object> readData = (HashMap<String, Object>) getDb().collection(CLIENT_HISTORY_COLLECTION).document(clientStdID).get().get().getData();
            ArrayList<Object> reader = (readData == null) ? null : (ArrayList<Object>) readData.get(HISTORY_FIELD_NAME);
            if(reader == null){
                reader = new ArrayList<>();
            }
            for(Object obj : reader){
                HashMap<String, Object> read = (HashMap<String, Object>) obj;
                returnVar.add(new HistoryData((String) read.get(HistoryData.TIMESTAMP_FIELD_NAME), new TimeDate((Map<String, Object>) read.get(HistoryData.TIMEDATE_FIELD_NAME)), (String) read.get(HistoryData.RECORDED_FIELD_NAME)));
            }
            return returnVar;
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
    
    public static void updateHistory(String clientStdID, ArrayList<HistoryData> data){
        HashMap<String, Object> push = new HashMap<>();
        push.put(HISTORY_FIELD_NAME, data);
        getDb().collection(CLIENT_HISTORY_COLLECTION).document(clientStdID).set(push);
        System.out.println("Updated");
    }
    
    public static boolean addHistory(String clientStdID, HistoryData history) throws DatabaseGetInterrupted{
        if(history != null){
            ArrayList<HistoryData> readData = readHistory(clientStdID);
            readData.add(history);
            updateHistory(clientStdID, readData);
            return true;
        }
        return false;
    }
    
    public static void deleteHistory(String clientStdID){
        getDb().collection(CLIENT_HISTORY_COLLECTION).document(clientStdID).delete();
    }
}
