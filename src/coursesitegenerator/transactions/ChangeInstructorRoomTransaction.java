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
public class ChangeInstructorRoomTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldRoom;
    String newRoom;
    
    public ChangeInstructorRoomTransaction(CourseSiteData initData, String oldR, String newR) {
        data=initData;
        oldRoom=oldR;
        newRoom=newR;
    }

    @Override
    public void doTransaction() {
        data.changeInstructorRoom(newRoom);
    }

    @Override
    public void undoTransaction() {
        data.changeInstructorRoom(oldRoom);
    }
}