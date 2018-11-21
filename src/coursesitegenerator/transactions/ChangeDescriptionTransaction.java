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
 * @author Jia Wei Zheng
 */
public class ChangeDescriptionTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldDescription;
    String newDescription;
    
    public ChangeDescriptionTransaction(CourseSiteData initData, String oldD, String newD) {
        data=initData;
        oldDescription=oldD;
        newDescription=newD;
    }

    @Override
    public void doTransaction() {
        data.changeDescription(newDescription);
    }

    @Override
    public void undoTransaction() {
        data.changeDescription(oldDescription);
    }
}