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
public class ChangeCSSTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldCSS;
    String newCSS;
    
    public ChangeCSSTransaction(CourseSiteData initData, String oldC, String newC) {
        data=initData;
        oldCSS=oldC;
        newCSS=newC;
    }

    @Override
    public void doTransaction() {
        data.changeCSS(newCSS);
    }

    @Override
    public void undoTransaction() {
        data.changeCSS(oldCSS);
    }
}