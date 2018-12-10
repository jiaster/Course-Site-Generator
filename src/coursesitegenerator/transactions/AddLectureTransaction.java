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
public class AddLectureTransaction implements jTPS_Transaction {
    CourseSiteData data;
    Lecture lecture;
    
    public AddLectureTransaction(CourseSiteData initData, Lecture initLecture) {
        data = initData;
        lecture = initLecture;
    }

    @Override
    public void doTransaction() {
        data.addLecture(lecture);        
    }

    @Override
    public void undoTransaction() {
        data.removeLecture(lecture);
    }
}