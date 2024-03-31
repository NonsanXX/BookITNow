/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Interface;

/**
 *
 * @author phump
 * @param <Infographic>
 */
public interface RoomReservedTime<Infographic> extends StatisticReport<Infographic>{
    public abstract Infographic reservedTimeReport();
}
