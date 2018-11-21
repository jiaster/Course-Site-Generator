package coursesitegenerator.transactions;

import jtps.jTPS_Transaction;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.TeachingAssistantPrototype;

/**
 *
 * @author Jia Wei Zheng
 */
public class RemoveTATransaction implements jTPS_Transaction {
    CourseSiteData data;
    TeachingAssistantPrototype ta;
    
    public RemoveTATransaction(CourseSiteData initData, TeachingAssistantPrototype initTA) {
        data = initData;
        ta = initTA;
    }

    @Override
    public void doTransaction() {
        data.removeTA(ta);        
    }

    @Override
    public void undoTransaction() {
        data.addTA(ta);
    }
}