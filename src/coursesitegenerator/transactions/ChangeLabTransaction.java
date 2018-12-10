/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jia Wei Zheng
 */
public class ChangeLabTransaction implements jTPS_Transaction {
    CourseSiteData data;
    Lab lab;
    String oldVal;
    String newVal;
    String type;
    
    public ChangeLabTransaction(CourseSiteData initData,Lab initLab,String initType, String oldS, String newS) {
        data=initData;
        lab= initLab;
        oldVal=oldS;
        newVal=newS;
        type=initType;
    }

    @Override
    public void doTransaction() {
        if (type.equals("section"))
            lab.setSection(newVal);
        else if (type.equals("daytime"))
            lab.setDaytime(newVal);
        else if (type.equals("ta1"))
            lab.setTaone(newVal);
        else if (type.equals("ta2"))
            lab.setTatwo(newVal);
        else if (type.equals("room"))
            lab.setRoom(newVal);
        data.refreshTables();
    }

    @Override
    public void undoTransaction() {
        if (type.equals("section"))
            lab.setSection(oldVal);
        else if (type.equals("daytime"))
            lab.setDaytime(oldVal);
        else if (type.equals("ta1"))
            lab.setTaone(oldVal);
        else if (type.equals("ta2"))
            lab.setTatwo(oldVal);
        else if (type.equals("room"))
            lab.setRoom(oldVal);
        data.refreshTables();
    }
}