/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;
/**
 *
 * @author phump
 */
public class HistoryData {
    public static final String TIMESTAMP_FIELD_NAME = "timeStamp";
    public static final String TIMEDATE_FIELD_NAME = "timeDate";
    public static final String RECORDED_FIELD_NAME = "recorded";
    
    private String timeStamp;
    private TimeDate timeDate;
    private String recorded;
    
    public HistoryData(){
        this("", null, null);
    }
    
    public HistoryData(String timeStamp, TimeDate timeDate, String roomName) {
        this.timeStamp = timeStamp;
        this.timeDate = timeDate;
        this.recorded = roomName;
    }
    
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TimeDate getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(TimeDate timeDate) {
        this.timeDate = timeDate;
    }

    public String getRecorded() {
        return recorded;
    }

    public void setRecorded(String recorded) {
        this.recorded = recorded;
    }
    
    public Object[] toRowData(long rid){
        return new Object[]{rid, timeStamp, timeDate, recorded};
    }
}
