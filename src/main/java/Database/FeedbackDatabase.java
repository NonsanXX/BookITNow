/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Interface.StatisticReport;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.Exception.DatabaseGetInterrupted;
import com.google.cloud.firestore.DocumentReference;


/**
 *
 * @author phump
 */
public class FeedbackDatabase extends Database implements StatisticReport<JTable>{
    private static final String FEEDBACK_FIELD_NAME = "Feedback";
    
    public static void addFeedback(String feedback){
        HashMap<String, Object> push = new HashMap<>();
        push.put("Feedback", feedback);
        getDb().collection(FEEDBACK_COLLECTION).document().set(push);
    }
    
    public static ArrayList<String> getFeedback() throws DatabaseGetInterrupted{
        ArrayList<String> roomListObject = new ArrayList<>();
        Iterable<DocumentReference> docRef = getDb().collection(FEEDBACK_COLLECTION).listDocuments();
        for(DocumentReference d : docRef){
            try {
                roomListObject.add((String) d.get().get().getData().get(FEEDBACK_FIELD_NAME));
            } catch (InterruptedException | ExecutionException ex) {
                throw new DatabaseGetInterrupted();
            }
        }
        return roomListObject;
    }

    @Override
    public JTable report() {
        ArrayList<String> feedbacks = null;
        try {
            feedbacks = getFeedback();
        } catch (DatabaseGetInterrupted ex) {
            return null;
        }
        Object[] columName = {"Feedback"};
        DefaultTableModel model = new DefaultTableModel(columName, 0);
        for(String feedback : feedbacks){
            Object[] rowData = {feedback};
            model.addRow(rowData);
        }
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setCellSelectionEnabled(false);
        return table;
    }
}
