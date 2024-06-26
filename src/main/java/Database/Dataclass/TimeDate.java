/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Map;
/**
 *
 * @author phump
 */
public class TimeDate extends TimeRange implements Comparable<TimeDate>{
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String timeDate;
    
    public TimeDate(){
        super();
    }
    
    public TimeDate(Double time1, Double time2) {
        super(time1, time2);
    }
    
    public TimeDate(Double time1, Double time2, String timeDate){
        super(time1, time2);
        this.timeDate = timeDate;
    }
    
    public TimeDate(Map<String, Object> map){
        this((Double) map.get("time1"), (Double) map.get("time2"), (String) map.get("timeDate"));
    }
    
    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
    public boolean isOverlap(TimeDate tr){
        boolean timeOverlap = new TimeRange(time1, time2).isOverlap(new TimeRange(tr.time1, tr.time2));
        if(!tr.timeDate.equals(timeDate)){ // not same day
            return false;
        }
        return timeOverlap; // if same day consider timeOverlap
    }
    
    /**
     * 
     * @param timeDate1
     * @param timeDate2
     * @return True if there exist one point of time that timeDate2 always greater than timeDate1
     */
    public static boolean timeDateCompare(TimeDate timeDate1, TimeDate timeDate2){
        LocalDate date1 = LocalDate.parse(timeDate1.getTimeDate(), FORMATTER);
        LocalDate date2 = LocalDate.parse(timeDate2.getTimeDate(), FORMATTER);
        
        int result = date1.compareTo(date2);
        if(result == 0){
            return timeDate2.getTime2() > timeDate1.getTime2();
        }
        return result < 0;
    }
    
    public static Double getTimeNow(){
        LocalDateTime now = LocalDateTime.now();
        return now.getHour() + now.getMinute()/60.0;
    }
    
    public static String getDateNow(){
        return FORMATTER.format(LocalDate.now());
    }
    
    public static String getTimeStamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(LocalDateTime.now());
    }
    
    public static String toPoint60(Double time){
        return String.format("%02d:%02d", (int) Math.floor(time), (int) (time%1*60));
    }
    
    @Override
    public String toString(){
        return String.format("%s - %s, %s", toPoint60(time1), toPoint60(time2), timeDate);
    }
    
    @Override
    public int compareTo(TimeDate time){
        if(this.equals(time)){
            return 0;
        }
        if (timeDateCompare(this, time)){
            return -1;
        }
        return 1;
    }
    
    public boolean equals(TimeDate timeDate){
        return Math.abs(time1 - timeDate.getTime1()) <= 0.01 && Math.abs(time2 - timeDate.getTime2()) <= 0.01 && this.timeDate.equals(timeDate.getTimeDate());
    }
}
