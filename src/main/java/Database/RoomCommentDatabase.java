/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.Database.getDb;
import Database.Exception.DatabaseGetInterrupted;
import Database.Dataclass.CommentData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author phump
 */
public class RoomCommentDatabase extends Database{
    public static final String COMMENT_FIELD_NAME = "table";
    
    public static ArrayList<CommentData> readComment(String roomName) throws DatabaseGetInterrupted{
        try {
            ArrayList<CommentData> returnVar = new ArrayList<>();
            HashMap<String, Object> readData = (HashMap<String, Object>) getDb().collection(ROOM_COMMENT_COLLECTION).document(roomName).get().get().getData();
            ArrayList<Object> reader = (readData == null) ? null : (ArrayList<Object>) readData.get(COMMENT_FIELD_NAME);
            if(reader == null){
                reader = new ArrayList<>();
            }
            for(Object obj : reader){
                HashMap<String, Object> read = (HashMap<String, Object>) obj;
                returnVar.add(new CommentData((String) read.get(CommentData.AUTHOR_FIELD_NAME), (String) read.get(CommentData.COMMENT_FIELD_NAME), (Long) read.get(CommentData.RATING_FIELD_NAME)));
            }
            return returnVar;
            } catch (InterruptedException | ExecutionException ex) {
                throw new DatabaseGetInterrupted();
            }
    }
    
    public static void addComment(String roomName, CommentData comment) throws DatabaseGetInterrupted{
        ArrayList<CommentData> currentComment = readComment(roomName);
        currentComment.add(comment);
        updateComment(roomName, currentComment);
    }
    
    public static void updateComment(String roomName, ArrayList<CommentData> data){
        HashMap<String, Object> push = new HashMap<>();
        push.put(COMMENT_FIELD_NAME, data);
        getDb().collection(ROOM_COMMENT_COLLECTION).document(roomName).set(push);
    }
    
    public static void deleteComment(String roomName, CommentData comment) throws DatabaseGetInterrupted{
        ArrayList<CommentData> currentComment = readComment(roomName);
        currentComment.remove(comment);
        updateComment(roomName, currentComment);
    }
}
