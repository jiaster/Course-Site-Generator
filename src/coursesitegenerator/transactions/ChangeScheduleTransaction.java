/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jiaster
 */
public class ChangeScheduleTransaction implements jTPS_Transaction {
    CourseSiteData data;
    boolean oldSchedule;
    boolean newSchedule;
    
    public ChangeScheduleTransaction(CourseSiteData initData, boolean oldS, boolean newS) {
        data=initData;
        oldSchedule=oldS;
        newSchedule=newS;
    }

    @Override
    public void doTransaction() {
        data.changeSchedule(newSchedule);
    }

    @Override
    public void undoTransaction() {
        data.changeSchedule(oldSchedule);
    }
}