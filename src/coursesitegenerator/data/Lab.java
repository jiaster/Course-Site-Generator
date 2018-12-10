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
 * @author Jiaster
 */
public class Lab {
    private final StringProperty section;
    private final StringProperty dayTime;
    private final StringProperty room;
    private final StringProperty ta1;
    private final StringProperty ta2;
    
    public Lab(){
        section = new SimpleStringProperty("-");
        dayTime = new SimpleStringProperty("-");
        room = new SimpleStringProperty("-");
        ta1 = new SimpleStringProperty("-");
        ta2 = new SimpleStringProperty("-");
    }
    
    public Lab(String initSection, String initDaytime, String initRoom, String initTA1,String initTA2) {
        section = new SimpleStringProperty(initSection);
        dayTime = new SimpleStringProperty(initDaytime);
        room = new SimpleStringProperty(initRoom);
        ta1 = new SimpleStringProperty(initTA1);
        ta2 = new SimpleStringProperty(initTA2);
    }
    
    public String getSection(){
        return section.get();
    }
    public String getDaytime(){
        return dayTime.get();
    }
    public String getTA1(){
        return ta1.get();
    }
    public String getTA2(){
        return ta2.get();
    }
    public String getRoom(){
        return room.get();
    }
    public void setSection(String newSection){
        section.setValue(newSection);
    }
    public void setDaytime(String newDaytime){
        dayTime.setValue(newDaytime);
    }
    public void setTA1(String ta){
        ta1.setValue(ta);
    }
    public void setTA2(String ta){
        ta2.setValue(ta);
    }
    public void setRoom(String newRoom){
        room.setValue(newRoom);
    }
}