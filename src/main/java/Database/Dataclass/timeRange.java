/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

/**
 *
 * @author phump
 */
public class timeRange {
    public long time1;
    public long time2;
    
    public timeRange(){
        this(0l, 0l);
    }
    
    public timeRange(long time1, long time2){
        this.time1 = time1;
        this.time2 = time2;
    }

    public long getTime1() {
        return time1;
    }

    public void setTime1(long time1) {
        this.time1 = time1;
    }

    public long getTime2() {
        return time2;
    }

    public void setTime2(long time2) {
        this.time2 = time2;
    }
    
    /**
     * 
     * @return length of timeRange
     */
    public long length(){
        return time2 - time1;
    }
    
    /**
    * @param tr Given timeRange
    * @return true if tr is sub-Range of the object
    */
    public boolean isSuperRange(timeRange tr){
        return time1 <= tr.time1 && time2 >= tr.time2;
    }
    
    /**
     *
     * @param tr
     * @return true if tr is overlap with the object
     * <img src="https://i.stack.imgur.com/6iULg.png" width="600" height="300">
     */
    public boolean isOverlap(timeRange tr){
        return length() + tr.length() > Long.max(time2, tr.time2) + Long.min(time1, tr.time1);
    }
}
