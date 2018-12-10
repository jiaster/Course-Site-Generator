/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.ScheduleItem;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jia Wei Zheng
 */
public class RemoveScheduleItemTransaction implements jTPS_Transaction {
    CourseSiteData data;
    ScheduleItem item;
    
    public RemoveScheduleItemTransaction(CourseSiteData initData, ScheduleItem initItem) {
        data = initData;
        item = initItem;
    }

    @Override
    public void doTransaction() {
        data.removeScheduleItem(item);
    }

    @Override
    public void undoTransaction() {
        data.addScheduleItem(item);
    }
}