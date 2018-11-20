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
public class ChangeSyllabusTransaction implements jTPS_Transaction {
    CourseSiteData data;
    boolean oldSyllabus;
    boolean newSyllabus;
    
    public ChangeSyllabusTransaction(CourseSiteData initData, boolean oldS, boolean newS) {
        data=initData;
        oldSyllabus=oldS;
        newSyllabus=newS;
    }

    @Override
    public void doTransaction() {
        data.changeSyllabus(newSyllabus);
    }

    @Override
    public void undoTransaction() {
        data.changeSyllabus(oldSyllabus);
    }
}