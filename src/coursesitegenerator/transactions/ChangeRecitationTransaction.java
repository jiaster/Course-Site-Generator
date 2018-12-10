/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import coursesitegenerator.data.Recitation;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jiaster
 */
public class ChangeRecitationTransaction implements jTPS_Transaction {
    CourseSiteData data;
    Recitation recitation;
    String oldVal;
    String newVal;
    String type;
    
    public ChangeRecitationTransaction(CourseSiteData initData,Recitation initRecitation,String initType, String oldS, String newS) {
        data=initData;
        recitation= initRecitation;
        oldVal=oldS;
        newVal=newS;
        type=initType;
    }

    @Override
    public void doTransaction() {
        if (type.equals("section"))
            recitation.setSection(newVal);
        else if (type.equals("daytime"))
            recitation.setDaytime(newVal);
        else if (type.equals("ta1"))
            recitation.setTaone(newVal);
        else if (type.equals("ta2"))
            recitation.setTatwo(newVal);
        else if (type.equals("room"))
            recitation.setRoom(newVal);
        data.refreshTables();
    }

    @Override
    public void undoTransaction() {
        if (type.equals("section"))
            recitation.setSection(oldVal);
        else if (type.equals("daytime"))
            recitation.setDaytime(oldVal);
        else if (type.equals("ta1"))
            recitation.setTaone(oldVal);
        else if (type.equals("ta2"))
            recitation.setTatwo(oldVal);
        else if (type.equals("room"))
            recitation.setRoom(oldVal);
        data.refreshTables();
    }
}