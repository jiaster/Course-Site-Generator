/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import coursesitegenerator.data.ScheduleItem;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jia Wei Zheng
 */
public class ChangeScheduleItemTransaction implements jTPS_Transaction {
    CourseSiteData data;
    ScheduleItem item;
    String oldType;
    String oldDate;
    String oldTitle;
    String oldTopic;
    String oldLink;
    String newType;
    String newDate;
    String newTitle;
    String newTopic;
    String newLink;
    
    
    public ChangeScheduleItemTransaction(CourseSiteData initData,ScheduleItem initItem,String initNewType, String initNewDate, String initNewTitle, String initNewTopic, String initNewLink) {
        data=initData;
        item=initItem;
        oldType= item.getType();
        oldDate=item.getDate();
        oldTitle=item.getTitle();
        oldTopic=item.getTopic();
        oldLink=item.getLink();
        newType=initNewType;
        newDate=initNewDate;
        newTitle=initNewTitle;
        newTopic=initNewTopic;
        newLink=initNewLink;
    }

    @Override
    public void doTransaction() {
        item.setType(newType);
        item.setDate(newDate);
        item.setTitle(newTitle);
        item.setTopic(newTopic);
        item.setLink(newLink);
    }

    @Override
    public void undoTransaction() {
        item.setType(oldType);
        item.setDate(oldDate);
        item.setTitle(oldTitle);
        item.setTopic(oldTopic);
        item.setLink(oldLink);
        data.refreshTables();
    }
}