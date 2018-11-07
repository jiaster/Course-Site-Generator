package coursesitegenerator.transactions;

import jtps.jTPS_Transaction;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.TeachingAssistantPrototype;

/**
 *
 * @author McKillaGorilla
 */
public class AddTA_Transaction implements jTPS_Transaction {
    CourseSiteData data;
    TeachingAssistantPrototype ta;
    
    public AddTA_Transaction(CourseSiteData initData, TeachingAssistantPrototype initTA) {
        data = initData;
        ta = initTA;
    }

    @Override
    public void doTransaction() {
        data.addTA(ta);        
    }

    @Override
    public void undoTransaction() {
        data.removeTA(ta);
    }
}
