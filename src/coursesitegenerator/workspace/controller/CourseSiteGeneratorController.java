/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.workspace.controller;

import coursesitegenerator.CourseSiteGenerator;
import static coursesitegenerator.CourseSitePropertyType.CSG_EMAIL_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_FOOLPROOF_SETTINGS;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_NO_TA_SELECTED_CONTENT;
import static coursesitegenerator.CourseSitePropertyType.CSG_NO_TA_SELECTED_TITLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_TA_EDIT_DIALOG;
import coursesitegenerator.data.CourseSiteData;
import djf.modules.AppGUIModule;
import djf.ui.dialogs.AppDialogsFacade;
import javafx.collections.ObservableList;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import coursesitegenerator.data.TAType;
import coursesitegenerator.data.TeachingAssistantPrototype;
import coursesitegenerator.data.TimeSlot;
import coursesitegenerator.dialogs.TADialog;
import coursesitegenerator.transactions.AddTA_Transaction;
import coursesitegenerator.transactions.ChangeTimeRangeTransaction;
import coursesitegenerator.transactions.EditTA_Transaction;
import coursesitegenerator.transactions.RemoveTATransaction;
import coursesitegenerator.transactions.ToggleOfficeHours_Transaction;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Jiaster
 */
public class CourseSiteGeneratorController {

    CourseSiteGenerator app;
    public String oldStartTime="8:00am";
    public String oldEndTime="11:00pm";
            
    public CourseSiteGeneratorController(CourseSiteGenerator initApp) {
        app = initApp;
        oldStartTime="8:00am";
        oldEndTime="11:00pm";
    }
    public String getOldStartTime(){
        return oldStartTime;
    }
    public String getOldEndTime(){
        return oldEndTime;
    }
    public void setOldStartTime(String time){
        oldStartTime=time;
    }
    public void setOldEndTime(String time){
        oldEndTime=time;
    }
    
    public void processAddTA() {
        AppGUIModule gui = app.getGUIModule();
        TextField nameTF = (TextField) gui.getGUINode(CSG_NAME_TEXT_FIELD);
        String name = nameTF.getText();
        TextField emailTF = (TextField) gui.getGUINode(CSG_EMAIL_TEXT_FIELD);
        String email = emailTF.getText();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TAType type = data.getSelectedType();
        if (data.isLegalNewTA(name, email)) {
            TeachingAssistantPrototype ta = new TeachingAssistantPrototype(name.trim(), email.trim(), type);
            AddTA_Transaction addTATransaction = new AddTA_Transaction(data, ta);
            app.processTransaction(addTATransaction);

            // NOW CLEAR THE TEXT FIELDS
            nameTF.setText("");
            emailTF.setText("");
            nameTF.requestFocus();
        }
        app.getFoolproofModule().updateControls(CSG_FOOLPROOF_SETTINGS);
    }
    
    public void processRemoveTA(){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        if (data.isTASelected()) {
            TeachingAssistantPrototype taToRemove = data.getSelectedTA();
            if (taToRemove != null) {
                RemoveTATransaction removeTA = new RemoveTATransaction(data, taToRemove);
                app.processTransaction(removeTA);
            }
        }
    }

    public void processVerifyTA() {
        
    }

    public void processToggleOfficeHours() {
        AppGUIModule gui = app.getGUIModule();
        TableView<TimeSlot> officeHoursTableView = (TableView) gui.getGUINode(CSG_OFFICE_HOURS_TABLE_VIEW);
        ObservableList<TablePosition> selectedCells = officeHoursTableView.getSelectionModel().getSelectedCells();
        if (selectedCells.size() > 0) {
            TablePosition cell = selectedCells.get(0);
            int cellColumnNumber = cell.getColumn();
            CourseSiteData data = (CourseSiteData)app.getDataComponent();
            if (data.isDayOfWeekColumn(cellColumnNumber)) {
                TimeSlot.DayOfWeek dow = data.getColumnDayOfWeek(cellColumnNumber);
                TableView<TeachingAssistantPrototype> taTableView = (TableView)gui.getGUINode(CSG_TAS_TABLE_VIEW);
                TeachingAssistantPrototype ta = taTableView.getSelectionModel().getSelectedItem();
                if (ta != null) {
                    TimeSlot timeSlot = officeHoursTableView.getSelectionModel().getSelectedItem();
                    ToggleOfficeHours_Transaction transaction = new ToggleOfficeHours_Transaction(data, timeSlot, dow, ta);
                    app.processTransaction(transaction);
                }
                else {
                    Stage window = app.getGUIModule().getWindow();
                    AppDialogsFacade.showMessageDialog(window, CSG_NO_TA_SELECTED_TITLE, CSG_NO_TA_SELECTED_CONTENT);
                }
            }
            int row = cell.getRow();
            cell.getTableView().refresh();
        }
    }

    public void processTypeTA() {
        app.getFoolproofModule().updateControls(CSG_FOOLPROOF_SETTINGS);
    }

    public void processEditTA() {
        CourseSiteData data = (CourseSiteData)app.getDataComponent();
        if (data.isTASelected()) {
            TeachingAssistantPrototype taToEdit = data.getSelectedTA();
            TADialog taDialog = (TADialog)app.getGUIModule().getDialog(CSG_TA_EDIT_DIALOG);
            taDialog.showEditDialog(taToEdit);
            TeachingAssistantPrototype editTA = taDialog.getEditTA();
            if (editTA != null) {
                EditTA_Transaction transaction = new EditTA_Transaction(taToEdit, editTA.getName(), editTA.getEmail(), editTA.getType());
                app.processTransaction(transaction);
            }
        }
    }

    public void processSelectAllTAs() {
        CourseSiteData data = (CourseSiteData)app.getDataComponent();
        data.selectTAs(TAType.All);
    }

    public void processSelectGradTAs() {
        CourseSiteData data = (CourseSiteData)app.getDataComponent();
        data.selectTAs(TAType.Graduate);
    }

    public void processSelectUndergradTAs() {
        CourseSiteData data = (CourseSiteData)app.getDataComponent();
        data.selectTAs(TAType.Undergraduate);
    }

    public void processSelectTA() {
        AppGUIModule gui = app.getGUIModule();
        TableView<TimeSlot> officeHoursTableView = (TableView) gui.getGUINode(CSG_OFFICE_HOURS_TABLE_VIEW);
        officeHoursTableView.refresh();
    }
    public void processSelectTimeRange(){
        //TODO FIX
        //fills up transaction queue
        AppGUIModule gui = app.getGUIModule();
        ComboBox startTime = (ComboBox) gui.getGUINode(CSG_START_TIME_COMBOBOX);
        ComboBox endTime = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
        CourseSiteData data = (CourseSiteData)app.getDataComponent();
        //endTime.getItems().clear();
        if (startTime.getValue()==null||endTime.getValue()==null)
            return;
        int startHour=Integer.parseInt(startTime.getValue().toString().substring(0, startTime.getValue().toString().indexOf(":")));
        int endHour=Integer.parseInt(endTime.getValue().toString().substring(0, endTime.getValue().toString().indexOf(":")));
        if (startTime.getValue().toString().charAt(startTime.getValue().toString().length()-2)=='p'&&startHour!=12)
            startHour+=12;
        if (endTime.getValue().toString().charAt(endTime.getValue().toString().length()-2)=='p'&&endHour!=12)
            endHour+=12;
        data.setTimeRanges(startHour, endHour);
        app.getFoolproofModule().updateControls(CSG_FOOLPROOF_SETTINGS);
        //ChangeTimeRangeTransaction transaction = new ChangeTimeRangeTransaction(data,data.getStartHour(),data.getEndHour()
        //        ,startHour,endHour);
        //app.processTransaction(transaction);
       
    }
}