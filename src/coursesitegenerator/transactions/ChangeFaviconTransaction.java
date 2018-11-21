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
public class ChangeFaviconTransaction implements jTPS_Transaction {
    CourseSiteData data;
    String oldFavPath;
    String newFavPath;
    
    public ChangeFaviconTransaction(CourseSiteData initData, String oldPath, String newPath) {
        data=initData;
        oldFavPath=oldPath;
        newFavPath=newPath;
    }

    @Override
    public void doTransaction() {
        data.setFaviconPath(newFavPath);
        data.setFavicon();
    }

    @Override
    public void undoTransaction() {
        System.out.println(oldFavPath);
        data.setFaviconPath(oldFavPath);
        data.setFavicon();
    }
}
