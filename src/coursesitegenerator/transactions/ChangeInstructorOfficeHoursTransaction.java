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
public class ChangeInstructorOfficeHoursTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldOfficeHours;
    String newOfficeHours;
    
    public ChangeInstructorOfficeHoursTransaction(CourseSiteData initData, String oldO, String newO) {
        data=initData;
        oldOfficeHours=oldO;
        newOfficeHours=newO;
    }

    @Override
    public void doTransaction() {
        data.changeInstructorOfficeHours(newOfficeHours);
    }

    @Override
    public void undoTransaction() {
        data.changeInstructorOfficeHours(oldOfficeHours);
    }
}