/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Dataclass.ClientData;
import Database.Dataclass.RoomData;
import Database.Dataclass.HistoryData;
import Database.Exception.DatabaseGetInterrupted;
import javax.swing.table.DefaultTableModel;
import Database.Interface.ClientHistoryStatisticReport;

import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author phump
 */
public class ClientHistoryDatabase extends Database{
    private static final String HISTORY_FIELD_NAME = "table";
    public static final Object[] columName = {"RID", "TimeStamp", "Reservation detail", "Room data"};
    
    public static DefaultTableModel createDefaultTableModel(Iterable<HistoryData> data){
        DefaultTableModel table = new DefaultTableModel(columName, 0);
        int rowCount = 1;
        for(HistoryData historyData : data){
            table.addRow(new Object[]{rowCount, historyData.getTimeStamp(), historyData.getTimeDate(), historyData.getDataclass()});
            rowCount += 1;
        }
        return table;
    };
    
    public static ArrayList<HistoryData> readHistory(String clientStdID) throws DatabaseGetInterrupted{
        try {
            HashMap<String, Object> readData = (HashMap<String, Object>) getDb().collection(CLIENT_HISTORY_COLLECTION).document(clientStdID).get().get().getData();
            if(readData == null){
                readData = new HashMap<>();
                readData.put(HISTORY_FIELD_NAME, new ArrayList<>());
            }
            return (ArrayList<HistoryData>) readData.get(HISTORY_FIELD_NAME);
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
    
    public static boolean addHistory(String clientStdID, HistoryData<RoomData> history) throws DatabaseGetInterrupted{
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
