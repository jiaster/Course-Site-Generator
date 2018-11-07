/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator;

import coursesitegenerator.clipboard.CourseSiteClipboard;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.files.CourseSiteFiles;
import coursesitegenerator.workspace.CourseSiteWorkspace;
import djf.AppTemplate;
import djf.components.AppClipboardComponent;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;
import djf.components.AppWorkspaceComponent;
import java.util.Locale;
import static javafx.application.Application.launch;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.files.CourseSiteFiles;

/**
 *
 * @author Jiaster
 */
public class CourseSiteGenerator extends AppTemplate{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    launch(args);
    }

    @Override
    public AppDataComponent buildDataComponent(AppTemplate app) {
        return new CourseSiteData(this);
    }

    @Override
    public AppFileComponent buildFileComponent() {
        return new CourseSiteFiles(this);
    }

    @Override
    public AppWorkspaceComponent buildWorkspaceComponent(AppTemplate app) {
        return new CourseSiteWorkspace(this);        
    }

    @Override
    public AppClipboardComponent buildClipboardComponent(AppTemplate app) {
        return new CourseSiteClipboard(this);
    }
}
