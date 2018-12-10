/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lecture;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jiaster
 */
public class ChangeLectureTransaction implements jTPS_Transaction {
    CourseSiteData data;
    Lecture lecture;
    String oldVal;
    String newVal;
    String type;
    
    public ChangeLectureTransaction(CourseSiteData initData,Lecture initLecture,String initType, String oldS, String newS) {
        data=initData;
        lecture= initLecture;
        oldVal=oldS;
        newVal=newS;
        type=initType;
    }

    @Override
    public void doTransaction() {
        if (type.equals("section"))
            lecture.setSection(newVal);
        else if (type.equals("days"))
            lecture.setDays(newVal);
        else if (type.equals("time"))
            lecture.setTime(newVal);
        else if (type.equals("room"))
            lecture.setRoom(newVal);
        data.refreshTables();
    }

    @Override
    public void undoTransaction() {
        if (type.equals("section"))
            lecture.setSection(oldVal);
        else if (type.equals("days"))
            lecture.setDays(oldVal);
        else if (type.equals("time"))
            lecture.setTime(oldVal);
        else if (type.equals("room"))
            lecture.setRoom(oldVal);
        data.refreshTables();
    }
}