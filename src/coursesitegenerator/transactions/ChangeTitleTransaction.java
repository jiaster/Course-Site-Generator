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
public class ChangeTitleTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldTitle;
    String newTitle;
    
    public ChangeTitleTransaction(CourseSiteData initData, String oldT, String newT) {
        data=initData;
        oldTitle=oldT;
        newTitle=newT;
    }

    @Override
    public void doTransaction() {
        data.changeTitle(newTitle);
    }

    @Override
    public void undoTransaction() {
        data.changeTitle(oldTitle);
    }
}