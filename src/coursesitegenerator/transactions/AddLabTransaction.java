/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.transactions;

import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import coursesitegenerator.data.Lecture;
import jtps.jTPS_Transaction;

/**
 *
 * @author Jia Wei Zheng
 */
public class AddLabTransaction implements jTPS_Transaction {
    CourseSiteData data;
    Lab lab;
    
    public AddLabTransaction(CourseSiteData initData, Lab initLab) {
        data = initData;
        lab = initLab;
    }

    @Override
    public void doTransaction() {
        data.addLab(lab);        
    }

    @Override
    public void undoTransaction() {
        data.removeLab(lab);
    }
}