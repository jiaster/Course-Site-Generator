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
public class ChangePrereqTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldPrereq;
    String newPrereq;
    
    public ChangePrereqTransaction(CourseSiteData initData, String oldP, String newP) {
        data=initData;
        oldPrereq=oldP;
        newPrereq=newP;
    }

    @Override
    public void doTransaction() {
        data.changePrereq(newPrereq);
    }

    @Override
    public void undoTransaction() {
        data.changePrereq(oldPrereq);
    }
}