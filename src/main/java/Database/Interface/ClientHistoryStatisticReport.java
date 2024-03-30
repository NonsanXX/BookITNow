/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Interface;

import Database.Dataclass.RoomData;
import Database.Dataclass.ClientData;

/**
 *
 * @author phump
 */
public interface ClientHistoryStatisticReport extends StatisticReport {
    /**
     * 
     * @param roomData Room that user make an reservation.
     * @param timeStamp Time that user make an reservation.
     * @return true if add complete, false if not.
     */
    public abstract boolean addHistory(RoomData roomData, long timeStamp);
}