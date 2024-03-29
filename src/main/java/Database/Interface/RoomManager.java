/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Interface;

import Database.Dataclass.RoomData;
/**
 *
 * @author phump
 */
public interface RoomManager {
    public abstract void addRoom(RoomData rd);
    
    public abstract void refresh();
}
