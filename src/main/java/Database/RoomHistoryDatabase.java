/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.Database.getDb;
import Database.Dataclass.HistoryData;
import Database.Dataclass.TimeDate;
import Database.Exception.DatabaseGetInterrupted;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phump
 */
public class RoomHistoryDatabase extends Database{
    private static final String HISTORY_FIELD_NAME = "table";
    public static final Object[] columName = {"RID", "TimeStamp", "Reservation detail", "Client"};
    
    public static DefaultTableModel createDefaultTableModel(String roomName) throws DatabaseGetInterrupted{
        return createDefaultTableModel(readHistory(roomName));
    }
    
    public static DefaultTableModel createDefaultTableModel(ArrayList<HistoryData> data){
        DefaultTableModel table = new DefaultTableModel(columName, 0){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        int rowCount = 1;
        for(HistoryData historyData : data){
            table.addRow(new Object[]{rowCount, historyData.getTimeStamp(), historyData.getTimeDate(), historyData.getRecorded()});
            rowCount += 1;
        }
        return table;
    };
    
    public static ArrayList<HistoryData> readHistory(String roomName) throws DatabaseGetInterrupted{
        try {
            ArrayList<HistoryData> returnVar = new ArrayList<>();
            HashMap<String, Object> readData = (HashMap<String, Object>) getDb().collection(ROOM_HISTORY_COLLECTION).document(roomName).get().get().getData();
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
    
    public static void updateHistory(String roomName, ArrayList<HistoryData> data){
        HashMap<String, Object> push = new HashMap<>();
        push.put(HISTORY_FIELD_NAME, data);
        getDb().collection(ROOM_HISTORY_COLLECTION).document(roomName).set(push);
    }
    
    public static boolean addHistory(String roomName, HistoryData history) throws DatabaseGetInterrupted{
        if(history != null){
            ArrayList<HistoryData> readData = readHistory(roomName);
            readData.add(history);
            updateHistory(roomName, readData);
            return true;
        }
        return false;
    }
    
    public static void deleteHistory(String roomName){
        getDb().collection(ROOM_HISTORY_COLLECTION).document(roomName).delete();
    }
}
