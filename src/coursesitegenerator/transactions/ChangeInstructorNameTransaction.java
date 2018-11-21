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
public class ChangeInstructorNameTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldName;
    String newName;
    
    public ChangeInstructorNameTransaction(CourseSiteData initData, String oldN, String newN) {
        data=initData;
        oldName=oldN;
        newName=newN;
    }

    @Override
    public void doTransaction() {
        data.changeInstructorName(newName);
    }

    @Override
    public void undoTransaction() {
        data.changeInstructorName(oldName);
    }
}