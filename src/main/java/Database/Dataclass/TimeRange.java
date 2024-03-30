/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

/**
 *
 * @author phump
 */
public class TimeRange {
    public Double time1;
    public Double time2;
    
    public TimeRange(){
        this(0.0, 0.0);
    }
    
    public TimeRange(Double time1, Double time2){
        this.time1 = time1;
        this.time2 = time2;
    }

    public Double getTime1() {
        return time1;
    }

    public void setTime1(Double time1) {
        this.time1 = time1;
    }

    public Double getTime2() {
        return time2;
    }

    public void setTime2(Double time2) {
        this.time2 = time2;
    }
    
    /**
     * 
     * @return length of TimeRange
     */
    public Double length(){
        return time2 - time1;
    }
    
    /**
    * @param tr Given TimeRange
    * @return true if tr is sub-Range of the object
    */
    public boolean isSuperRange(TimeRange tr){
        return time1 <= tr.time1 && time2 >= tr.time2;
    }
    
    /**
     *
     * @param tr
     * @return true if tr is overlap with the object
     * <img src="https://i.stack.imgur.com/6iULg.png" width="600" height="300">
     */
    public boolean isOverlap(TimeRange tr){
        return length() + tr.length() > Double.max(time2, tr.time2) + Double.min(time1, tr.time1);
    }
}