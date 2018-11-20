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
public class ChangeYearTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldYear;
    String newYear;
    
    public ChangeYearTransaction(CourseSiteData initData, String oldY, String newY) {
        data=initData;
        oldYear=oldY;
        newYear=newY;
    }

    @Override
    public void doTransaction() {
        data.changeYear(newYear);
    }

    @Override
    public void undoTransaction() {
        data.changeYear(oldYear);
    }
}