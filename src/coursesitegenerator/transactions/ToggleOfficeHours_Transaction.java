package coursesitegenerator.transactions;

import jtps.jTPS_Transaction;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.TeachingAssistantPrototype;
import coursesitegenerator.data.TimeSlot;
import coursesitegenerator.data.TimeSlot.DayOfWeek;

/**
 *
 * @author McKillaGorilla
 */
public class ToggleOfficeHours_Transaction implements jTPS_Transaction {
    CourseSiteData data;
    TimeSlot timeSlot;
    DayOfWeek dow;
    TeachingAssistantPrototype ta;
    
    public ToggleOfficeHours_Transaction(   CourseSiteData initData, 
                                            TimeSlot initTimeSlot,
                                            DayOfWeek initDOW,
                                            TeachingAssistantPrototype initTA) {
        data = initData;
        timeSlot = initTimeSlot;
        dow = initDOW;
        ta = initTA;
    }

    @Override
    public void doTransaction() {
        timeSlot.toggleTA(dow, ta);
    }

    @Override
    public void undoTransaction() {
        timeSlot.toggleTA(dow, ta);
    }
}