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
public class ChangeSemesterTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldSemester;
    String newSemester;
    
    public ChangeSemesterTransaction(CourseSiteData initData, String oldSem, String newSem) {
        data=initData;
        oldSemester=oldSem;
        newSemester=newSem;
    }

    @Override
    public void doTransaction() {
        data.changeSemester(newSemester);
    }

    @Override
    public void undoTransaction() {
        data.changeSemester(oldSemester);
    }
}