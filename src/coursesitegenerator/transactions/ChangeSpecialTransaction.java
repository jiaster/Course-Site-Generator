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
public class ChangeSpecialTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldSpecial;
    String newSpecial;
    
    public ChangeSpecialTransaction(CourseSiteData initData, String oldS, String newS) {
        data=initData;
        oldSpecial=oldS;
        newSpecial=newS;
    }

    @Override
    public void doTransaction() {
        data.changeSpecial(newSpecial);
    }

    @Override
    public void undoTransaction() {
        data.changeSpecial(oldSpecial);
    }
}