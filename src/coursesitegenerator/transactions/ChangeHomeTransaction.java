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
public class ChangeHomeTransaction implements jTPS_Transaction {
    CourseSiteData data;
    boolean oldHome;
    boolean newHome;
    
    public ChangeHomeTransaction(CourseSiteData initData, boolean oldH, boolean newH) {
        data=initData;
        oldHome=oldH;
        newHome=newH;
    }

    @Override
    public void doTransaction() {
        data.changeHome(newHome);
    }

    @Override
    public void undoTransaction() {
        data.changeHome(oldHome);
    }
}