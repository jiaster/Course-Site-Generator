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
public class ChangeRightFooterTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldRightFooterPath;
    String newRightFooterPath;
    
    public ChangeRightFooterTransaction(CourseSiteData initData, String oldPath, String newPath) {
        data=initData;
        oldRightFooterPath=oldPath;
        newRightFooterPath=newPath;
    }

    @Override
    public void doTransaction() {
        data.setRightFooterPath(newRightFooterPath);
        data.setRightFooter();
    }

    @Override
    public void undoTransaction() {
        //System.out.println(oldFavPath);
        data.setRightFooterPath(oldRightFooterPath);
        data.setRightFooter();
    }
}