package coursesitegenerator.workspace.foolproof;

import coursesitegenerator.CourseSiteGenerator;
import djf.modules.AppGUIModule;
import djf.ui.foolproof.FoolproofDesign;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static coursesitegenerator.CourseSitePropertyType.CSG_ADD_TA_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_EMAIL_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_COMBOBOX;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.workspace.CourseSiteWorkspace;
import static coursesitegenerator.workspace.style.CSGStyle.CLASS_CSG_TEXT_FIELD;
import static coursesitegenerator.workspace.style.CSGStyle.CLASS_CSG_TEXT_FIELD_ERROR;
import djf.components.AppWorkspaceComponent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;

public class CourseSiteFoolproofDesign implements FoolproofDesign {

    CourseSiteGenerator app;

    public CourseSiteFoolproofDesign(CourseSiteGenerator initApp) {
        app = initApp;
    }

    @Override
    public void updateControls() {
        updateAddTAFoolproofDesign();
        updateEditTAFoolproofDesign();
        updateTimeFoolproofDesign();
    }
    
    public void updateTimeFoolproofDesign(){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ComboBox startTime = (ComboBox) gui.getGUINode(CSG_START_TIME_COMBOBOX);
        ComboBox endTime = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
        ObservableList<String> endHours = data.getEndTimes();
        //ObservableList<String> endHourList = endTime.getItems();
        FilteredList<String> filteredEndHours = new FilteredList<>(endHours, p -> true);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        LocalTime startLocalTime;
        if (startTime.getValue().toString().substring(0, 2).contains(":"))
            startLocalTime=LocalTime.parse("0"+startTime.getValue().toString().toUpperCase(), formatter);
        else
            startLocalTime=LocalTime.parse(startTime.getValue().toString().toUpperCase(), formatter);
        filteredEndHours.setPredicate(time -> {
            LocalTime endLocalTime;
            if (time.substring(0, 2).contains(":"))//if one digit hour add a 0
                endLocalTime=LocalTime.parse("0"+time.toUpperCase(), formatter);
            else
                endLocalTime=LocalTime.parse(time.toUpperCase(), formatter);
            
            if (endLocalTime.isAfter(startLocalTime)) {
                return true;
            } else {
                return false;
            }
        });

        SortedList<String> sortedTime = new SortedList<>(filteredEndHours);
        //SortedList.comparatorProperty().bind(endTime.comparatorProperty());
        //check if end times are already more than start times
        
        /*
        int firstEndHour=(Integer.parseInt(sortedTime.get(0).substring(0, sortedTime.get(0).indexOf(":"))));
        if (sortedTime.get(0).contains("p")&&sortedTime.get(0).substring(0,2).equals("12"))
            firstEndHour+=12;
        String firstStartTime=(String) startTime.getValue();
        int firstStartHour = (Integer.parseInt(firstStartTime.substring(0, firstStartTime.indexOf(":"))));
        if (firstStartTime.contains("p"))
            firstStartHour+=12;
        System.out.println(firstStartHour+" "+firstEndHour);
        if (firstStartHour>firstEndHour)
            
        if(endTime.getItems().contains(startTime.getValue()));{
            System.out.println(endTime.getItems()+" "+startTime.getValue());
            */
        CourseSiteWorkspace work = (CourseSiteWorkspace) app.getWorkspaceComponent();
           //work.disableEndTimes();
            endTime.setItems(sortedTime);
            //work.reenableEndTimes();
    }

    private void updateAddTAFoolproofDesign() {
        AppGUIModule gui = app.getGUIModule();
        
        // FOOLPROOF DESIGN STUFF FOR ADD TA BUTTON
        TextField nameTextField = ((TextField) gui.getGUINode(CSG_NAME_TEXT_FIELD));
        TextField emailTextField = ((TextField) gui.getGUINode(CSG_EMAIL_TEXT_FIELD));
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        Button addTAButton = (Button) gui.getGUINode(CSG_ADD_TA_BUTTON);

        // FIRST, IF NO TYPE IS SELECTED WE'LL JUST DISABLE
        // THE CONTROLS AND BE DONE WITH IT
        boolean isTypeSelected = data.isTATypeSelected();
        if (!isTypeSelected) {
            nameTextField.setDisable(true);
            emailTextField.setDisable(true);
            addTAButton.setDisable(true);
            return;
        } // A TYPE IS SELECTED SO WE'LL CONTINUE
        else {
            nameTextField.setDisable(false);
            emailTextField.setDisable(false);
            addTAButton.setDisable(false);
        }

        // NOW, IS THE USER-ENTERED DATA GOOD?
        boolean isLegalNewTA = data.isLegalNewTA(name, email);

        // ENABLE/DISABLE THE CONTROLS APPROPRIATELY
        addTAButton.setDisable(!isLegalNewTA);
        if (isLegalNewTA) {
            nameTextField.setOnAction(addTAButton.getOnAction());
            emailTextField.setOnAction(addTAButton.getOnAction());
        } else {
            nameTextField.setOnAction(null);
            emailTextField.setOnAction(null);
        }

        // UPDATE THE CONTROL TEXT DISPLAY APPROPRIATELY
        boolean isLegalNewName = data.isLegalNewName(name);
        boolean isLegalNewEmail = data.isLegalNewEmail(email);
        foolproofTextField(nameTextField, isLegalNewName);
        foolproofTextField(emailTextField, isLegalNewEmail);
    }
    
    private void updateEditTAFoolproofDesign() {
        
    }
    
    public void foolproofTextField(TextField textField, boolean hasLegalData) {
        if (hasLegalData) {
            textField.getStyleClass().remove(CLASS_CSG_TEXT_FIELD_ERROR);
            if (!textField.getStyleClass().contains(CLASS_CSG_TEXT_FIELD)) {
                textField.getStyleClass().add(CLASS_CSG_TEXT_FIELD);
            }
        } else {
            textField.getStyleClass().remove(CLASS_CSG_TEXT_FIELD);
            if (!textField.getStyleClass().contains(CLASS_CSG_TEXT_FIELD_ERROR)) {
                textField.getStyleClass().add(CLASS_CSG_TEXT_FIELD_ERROR);
            }
        }
    }
}
