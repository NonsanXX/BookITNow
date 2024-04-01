/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Interface;

import Database.Dataclass.TimeDate;
/**
 *
 * @author phump
 */
public interface Cancellation {
    public abstract boolean cancel(TimeDate reservation);
}
