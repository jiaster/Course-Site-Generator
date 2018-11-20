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
public class ChangeGradingNoteTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldGradingNote;
    String newGradingNote;
    
    public ChangeGradingNoteTransaction(CourseSiteData initData, String oldG, String newG) {
        data=initData;
        oldGradingNote=oldG;
        newGradingNote=newG;
    }

    @Override
    public void doTransaction() {
        data.changeGradingNote(newGradingNote);
    }

    @Override
    public void undoTransaction() {
        data.changeGradingNote(oldGradingNote);
    }
}