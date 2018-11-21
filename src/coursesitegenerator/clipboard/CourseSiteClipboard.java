/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.clipboard;

import coursesitegenerator.CourseSiteGenerator;
import coursesitegenerator.data.TeachingAssistantPrototype;
import djf.components.AppClipboardComponent;
import java.util.ArrayList;

/**
 *
 * @author Jia Wei Zheng
 */
public class CourseSiteClipboard implements AppClipboardComponent {
    CourseSiteGenerator app;
    ArrayList<TeachingAssistantPrototype> clipboardCutItems;
    ArrayList<TeachingAssistantPrototype> clipboardCopiedItems;
    
    public CourseSiteClipboard(CourseSiteGenerator initApp) {
    }
    
    @Override
    public void cut() {
    }

    @Override
    public void copy() {
    }
    
    @Override
    public void paste() {

    }    

    @Override
    public boolean hasSomethingToCut() {
        return false;
    }

    @Override
    public boolean hasSomethingToCopy() {
        return false;
    }

    @Override
    public boolean hasSomethingToPaste() {
        return false;
    }
}