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
public class Lab {
    private final StringProperty section;
    private final StringProperty dayTime;
    private final StringProperty room;
    private final StringProperty taone;
    private final StringProperty tatwo;
    
    public Lab(){
        section = new SimpleStringProperty("-");
        dayTime = new SimpleStringProperty("-");
        room = new SimpleStringProperty("-");
        taone = new SimpleStringProperty("-");
        tatwo = new SimpleStringProperty("-");
    }
    
    public Lab(String initSection, String initDaytime, String initRoom, String initTA1,String initTA2) {
        section = new SimpleStringProperty(initSection);
        dayTime = new SimpleStringProperty(initDaytime);
        room = new SimpleStringProperty(initRoom);
        taone = new SimpleStringProperty(initTA1);
        tatwo = new SimpleStringProperty(initTA2);
    }
    
    public String getSection(){
        return section.get();
    }
    public String getDaytime(){
        return dayTime.get();
    }
    public String getTaone(){
        return taone.get();
    }
    public String getTatwo(){
        return tatwo.get();
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
    public void setTaone(String ta){
        taone.setValue(ta);
    }
    public void setTatwo(String ta){
        tatwo.setValue(ta);
    }
    public void setRoom(String newRoom){
        room.setValue(newRoom);
    }
}