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
public class ChangeInstructorHomeTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldHome;
    String newHome;
    
    public ChangeInstructorHomeTransaction(CourseSiteData initData, String oldH, String newH) {
        data=initData;
        oldHome=oldH;
        newHome=newH;
    }

    @Override
    public void doTransaction() {
        data.changeInstructorHome(newHome);
    }

    @Override
    public void undoTransaction() {
        data.changeInstructorHome(oldHome);
    }
}