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
public class ChangeTopicsTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldTopics;
    String newTopics;
    
    public ChangeTopicsTransaction(CourseSiteData initData, String oldT, String newT) {
        data=initData;
        oldTopics=oldT;
        newTopics=newT;
    }

    @Override
    public void doTransaction() {
        data.changeTopics(newTopics);
    }

    @Override
    public void undoTransaction() {
        data.changeTopics(oldTopics);
    }
}