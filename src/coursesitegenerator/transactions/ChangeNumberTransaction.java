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
public class ChangeNumberTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldNumber;
    String newNumber;
    
    public ChangeNumberTransaction(CourseSiteData initData, String oldNum, String newNum) {
        data=initData;
        oldNumber=oldNum;
        newNumber=newNum;
    }

    @Override
    public void doTransaction() {
        data.changeNumber(newNumber);
    }

    @Override
    public void undoTransaction() {
        data.changeNumber(oldNumber);
    }
}
