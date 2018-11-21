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
public class ChangeNavbarTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldNavBarPath;
    String newNavBarPath;
    
    public ChangeNavbarTransaction(CourseSiteData initData, String oldPath, String newPath) {
        data=initData;
        oldNavBarPath=oldPath;
        newNavBarPath=newPath;
    }

    @Override
    public void doTransaction() {
        data.setNavbarPath(newNavBarPath);
        data.setNavbar();
    }

    @Override
    public void undoTransaction() {
        //System.out.println(oldFavPath);
        data.setNavbarPath(oldNavBarPath);
        data.setNavbar();
    }
}