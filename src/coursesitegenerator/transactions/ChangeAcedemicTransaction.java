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
public class ChangeAcedemicTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldAcedemic;
    String newAcedemic;
    
    public ChangeAcedemicTransaction(CourseSiteData initData, String oldA, String newA) {
        data=initData;
        oldAcedemic=oldA;
        newAcedemic=newA;
    }

    @Override
    public void doTransaction() {
        data.changeAcedemic(newAcedemic);
    }

    @Override
    public void undoTransaction() {
        data.changeAcedemic(oldAcedemic);
    }
}