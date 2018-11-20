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
public class ChangeSubjectTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldSubject;
    String newSubject;
    
    public ChangeSubjectTransaction(CourseSiteData initData, String oldSub, String newSub) {
        data=initData;
        oldSubject=oldSub;
        newSubject=newSub;
    }

    @Override
    public void doTransaction() {
        data.changeSubject(newSubject);
    }

    @Override
    public void undoTransaction() {
        data.changeSubject(oldSubject);
    }
}