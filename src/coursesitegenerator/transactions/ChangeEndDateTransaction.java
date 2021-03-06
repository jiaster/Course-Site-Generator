/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import java.time.LocalDate;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jia Wei Zheng
 */
public class ChangeEndDateTransaction implements jTPS_Transaction {
    CourseSiteData data;
    LocalDate oldDate;
    LocalDate newDate;
    
    public ChangeEndDateTransaction(CourseSiteData initData, LocalDate initOldDate, LocalDate initNewDate) {
        data = initData;
        oldDate = initOldDate;
        newDate = initNewDate;
    }

    @Override
    public void doTransaction() {
        data.changeEndDate(newDate);        
    }

    @Override
    public void undoTransaction() {
        data.changeEndDate(oldDate);
    }
}