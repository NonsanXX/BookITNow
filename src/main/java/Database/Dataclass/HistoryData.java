/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

/**
 *
 * @author phump
 * @param <Dataclass>
 */
public class HistoryData<Dataclass> {
    private String timeStamp;
    private TimeDate timeDate;
    private Dataclass dataclass;
    
    public HistoryData(){
        this("", null, null);
    }
    
    public HistoryData(String timeStamp, TimeDate timeDate, Dataclass dataclass) {
        this.timeStamp = timeStamp;
        this.timeDate = timeDate;
        this.dataclass = dataclass;
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

    public Dataclass getDataclass() {
        return dataclass;
    }

    public void setDataclass(Dataclass dataclass) {
        this.dataclass = dataclass;
    }
    
    public Object[] toRowData(long rid){
        return new Object[]{rid, timeStamp, timeDate, dataclass};
    }
}
