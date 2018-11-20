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
public class ChangeHWSTransaction implements jTPS_Transaction {
    CourseSiteData data;
    boolean oldHWS;
    boolean newHWS;
    
    public ChangeHWSTransaction(CourseSiteData initData, boolean oldHW, boolean newHW) {
        data=initData;
        oldHWS=oldHW;
        newHWS=newHW;
    }

    @Override
    public void doTransaction() {
        data.changeHWS(newHWS);
    }

    @Override
    public void undoTransaction() {
        data.changeHWS(oldHWS);
    }
}