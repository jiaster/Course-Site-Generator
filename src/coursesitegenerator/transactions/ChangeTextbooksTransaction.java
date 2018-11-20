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
public class ChangeTextbooksTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldTextbooks;
    String newTextbooks;
    
    public ChangeTextbooksTransaction(CourseSiteData initData, String oldT, String newT) {
        data=initData;
        oldTextbooks=oldT;
        newTextbooks=newT;
    }

    @Override
    public void doTransaction() {
        data.changeTextbooks(newTextbooks);
    }

    @Override
    public void undoTransaction() {
        data.changeTextbooks(oldTextbooks);
    }
}