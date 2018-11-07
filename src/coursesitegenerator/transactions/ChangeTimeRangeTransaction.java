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
public class ChangeTimeRangeTransaction implements jTPS_Transaction {
    int oldStartHour,oldEndHour,newStartHour,newEndHour;
    CourseSiteData data;
    
    public ChangeTimeRangeTransaction(CourseSiteData initData,int oldStart,int oldEnd,int newStart,int newEnd
    ){
        data=initData;
        oldStartHour=oldStart;
        oldEndHour= oldEnd;
        newStartHour=newStart;
        newEndHour=newEnd;
    }

    @Override
    public void doTransaction() {
        data.setTimeRanges(newStartHour, newEndHour);
    }

    @Override
    public void undoTransaction() {
        data.setTimeRanges(oldStartHour, oldEndHour);
    }
    
}
