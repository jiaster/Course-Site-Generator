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
 * @author Jia Wei Zheng
 */
public class RemoveRecitationTransaction implements jTPS_Transaction {
    CourseSiteData data;
    Recitation recitation;
    
    public RemoveRecitationTransaction(CourseSiteData initData, Recitation initRecitation) {
        data = initData;
        recitation = initRecitation;
    }

    @Override
    public void doTransaction() {
        data.removeRecitation(recitation);
    }

    @Override
    public void undoTransaction() {
        data.addRecitation(recitation);
        data.refreshTables();
    }
}