/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Recitation;
import coursesitegenerator.data.ScheduleItem;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jiaster
 */
public class AddScheduleItemTransaction implements jTPS_Transaction {
    CourseSiteData data;
    ScheduleItem item;
    
    public AddScheduleItemTransaction(CourseSiteData initData, ScheduleItem initItem) {
        data = initData;
        item = initItem;
    }

    @Override
    public void doTransaction() {
        data.addScheduleItem(item);
    }

    @Override
    public void undoTransaction() {
        data.removeScheduleItem(item);
    }
}