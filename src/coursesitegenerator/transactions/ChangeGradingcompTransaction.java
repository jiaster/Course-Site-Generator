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
public class ChangeGradingcompTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldGradingcomp;
    String newGradingcomp;
    
    public ChangeGradingcompTransaction(CourseSiteData initData, String oldG, String newG) {
        data=initData;
        oldGradingcomp=oldG;
        newGradingcomp=newG;
    }

    @Override
    public void doTransaction() {
        data.changeGradedcomp(newGradingcomp);
    }

    @Override
    public void undoTransaction() {
        data.changeGradedcomp(oldGradingcomp);
    }
}