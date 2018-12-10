/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jia Wei Zheng
 */
public class Lecture{
    private final StringProperty section;
    private final StringProperty days;
    private final StringProperty time;
    private final StringProperty room;
    
    public Lecture(){
        section = new SimpleStringProperty("-");
        days = new SimpleStringProperty("-");
        time = new SimpleStringProperty("-");
        room = new SimpleStringProperty("-");
    }
    
    public Lecture(String initSection, String initDays, String initTime, String initRoom) {
        section = new SimpleStringProperty(initSection);
        days = new SimpleStringProperty(initDays);
        time = new SimpleStringProperty(initTime);
        room = new SimpleStringProperty(initRoom);
    }
    
    public String getSection(){
        return section.get();
    }
    public String getDays(){
        return days.get();
    }
    public String getTime(){
        return time.get();
    }
    public String getRoom(){
        return room.get();
    }
    public void setSection(String newSection){
        section.setValue(newSection);
    }
    public void setDays(String newDays){
        days.setValue(newDays);
    }
    public void setTime(String newTime){
        time.setValue(newTime);
    }
    public void setRoom(String newRoom){
        room.setValue(newRoom);
    }
}