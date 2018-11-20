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
public class ChangeLeftFooterTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldLeftFooterPath;
    String newLeftFooterPath;
    
    public ChangeLeftFooterTransaction(CourseSiteData initData, String oldPath, String newPath) {
        data=initData;
        oldLeftFooterPath=oldPath;
        newLeftFooterPath=newPath;
    }

    @Override
    public void doTransaction() {
        data.setLeftFooterPath(newLeftFooterPath);
        data.setLeftFooter();
    }

    @Override
    public void undoTransaction() {
        //System.out.println(newLeftFooterPath);
        data.setLeftFooterPath(oldLeftFooterPath);
        data.setLeftFooter();
    }
}