/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.data;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jiaster
 */
public class ScheduleItem {
    private final StringProperty type;
    private final StringProperty date;
    private final StringProperty title;
    private final StringProperty topic;
    private String link;
    
    public ScheduleItem(){
        type = new SimpleStringProperty("-");
        date = new SimpleStringProperty("-");
        title = new SimpleStringProperty("-");
        topic = new SimpleStringProperty("-");
        link = "";
    }
    
    public ScheduleItem(String initType, LocalDate initDate, String initTitle, String initTopic, String initLink) {
        type = new SimpleStringProperty(initType);
        date = new SimpleStringProperty(initDate.toString());
        title = new SimpleStringProperty(initTitle);
        topic = new SimpleStringProperty(initTopic);
        link = initLink;
    }
    
    public ScheduleItem(String initType, String initDate, String initTitle, String initTopic, String initLink) {
        type = new SimpleStringProperty(initType);
        date = new SimpleStringProperty(initDate);
        title = new SimpleStringProperty(initTitle);
        topic = new SimpleStringProperty(initTopic);
        link = initLink;
    }
    
    public String getType(){
        return type.get();
    }
    public String getDate(){
        return date.get();
    }
    public String getTitle(){
        return title.get();
    }
    public String getTopic(){
        return topic.get();
    }
    public void setType(String newType){
        type.setValue(newType);
    }
    public void setDate(LocalDate newDate){
        date.setValue(newDate.toString());
    }
    public void setDate(String newDate) {
        date.setValue(newDate);
    }
    public void setTitle(String newTitle){
        title.setValue(newTitle);
    }
    public void setTopic(String newTopic){
        topic.setValue(newTopic);
    }
    public String getLink(){
        return link;
    }
    public void setLink(String newLink){
        link = newLink;
    }
}