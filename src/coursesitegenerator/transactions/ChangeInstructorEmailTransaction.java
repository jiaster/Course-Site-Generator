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
public class ChangeInstructorEmailTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldEmail;
    String newEmail;
    
    public ChangeInstructorEmailTransaction(CourseSiteData initData, String oldE, String newE) {
        data=initData;
        oldEmail=oldE;
        newEmail=newE;
    }

    @Override
    public void doTransaction() {
        data.changeInstructorEmail(newEmail);
    }

    @Override
    public void undoTransaction() {
        data.changeInstructorEmail(oldEmail);
    }
}