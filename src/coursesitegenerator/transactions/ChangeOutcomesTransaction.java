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
public class ChangeOutcomesTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldOutcomes;
    String newOutcomes;
    
    public ChangeOutcomesTransaction(CourseSiteData initData, String oldO, String newO) {
        data=initData;
        oldOutcomes=oldO;
        newOutcomes=newO;
    }

    @Override
    public void doTransaction() {
        data.changeOutcomes(newOutcomes);
    }

    @Override
    public void undoTransaction() {
        data.changeOutcomes(oldOutcomes);
    }
}