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
 * @author Jiaster
 */
public class ChangeStartDateTransaction implements jTPS_Transaction {
    CourseSiteData data;
    LocalDate oldDate;
    LocalDate newDate;
    
    public ChangeStartDateTransaction(CourseSiteData initData, LocalDate initOldDate, LocalDate initNewDate) {
        data = initData;
        oldDate = initOldDate;
        newDate = initNewDate;
    }

    @Override
    public void doTransaction() {
        data.changeStartDate(newDate);        
    }

    @Override
    public void undoTransaction() {
        data.changeStartDate(oldDate);
    }
}