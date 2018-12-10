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
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_LAB_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_LECTURE_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_RECITATION_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_NO_TA_SELECTED_CONTENT;
import static coursesitegenerator.CourseSitePropertyType.CSG_NO_TA_SELECTED_TITLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_NUMBER_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_SUBJECT_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_STYLE_FAVICON;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_TA_EDIT_DIALOG;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import coursesitegenerator.data.Lecture;
import coursesitegenerator.data.Recitation;
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
import coursesitegenerator.transactions.AddLabTransaction;
import coursesitegenerator.transactions.AddLectureTransaction;
import coursesitegenerator.transactions.AddRecitationTransaction;
import coursesitegenerator.transactions.AddTA_Transaction;
import coursesitegenerator.transactions.ChangeAcedemicTransaction;
import coursesitegenerator.transactions.ChangeCSSTransaction;
import coursesitegenerator.transactions.ChangeDescriptionTransaction;
import coursesitegenerator.transactions.ChangeFaviconTransaction;
import coursesitegenerator.transactions.ChangeGradingNoteTransaction;
import coursesitegenerator.transactions.ChangeGradingcompTransaction;
import coursesitegenerator.transactions.ChangeHWSTransaction;
import coursesitegenerator.transactions.ChangeHomeTransaction;
import coursesitegenerator.transactions.ChangeInstructorEmailTransaction;
import coursesitegenerator.transactions.ChangeInstructorHomeTransaction;
import coursesitegenerator.transactions.ChangeInstructorNameTransaction;
import coursesitegenerator.transactions.ChangeInstructorOfficeHoursTransaction;
import coursesitegenerator.transactions.ChangeInstructorRoomTransaction;
import coursesitegenerator.transactions.ChangeLabTransaction;
import coursesitegenerator.transactions.ChangeLectureTransaction;
import coursesitegenerator.transactions.ChangeLeftFooterTransaction;
import coursesitegenerator.transactions.ChangeNavbarTransaction;
import coursesitegenerator.transactions.ChangeNumberTransaction;
import coursesitegenerator.transactions.ChangeOutcomesTransaction;
import coursesitegenerator.transactions.ChangePrereqTransaction;
import coursesitegenerator.transactions.ChangeRecitationTransaction;
import coursesitegenerator.transactions.ChangeRightFooterTransaction;
import coursesitegenerator.transactions.ChangeScheduleTransaction;
import coursesitegenerator.transactions.ChangeSemesterTransaction;
import coursesitegenerator.transactions.ChangeSpecialTransaction;
import coursesitegenerator.transactions.ChangeSubjectTransaction;
import coursesitegenerator.transactions.ChangeSyllabusTransaction;
import coursesitegenerator.transactions.ChangeTextbooksTransaction;
import coursesitegenerator.transactions.ChangeTimeRangeTransaction;
import coursesitegenerator.transactions.ChangeTitleTransaction;
import coursesitegenerator.transactions.ChangeTopicsTransaction;
import coursesitegenerator.transactions.ChangeYearTransaction;
import coursesitegenerator.transactions.EditTA_Transaction;
import coursesitegenerator.transactions.RemoveLabTransaction;
import coursesitegenerator.transactions.RemoveLectureTransaction;
import coursesitegenerator.transactions.RemoveRecitationTransaction;
import coursesitegenerator.transactions.RemoveTATransaction;
import coursesitegenerator.transactions.ToggleOfficeHours_Transaction;
import djf.components.AppFileComponent;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author Jia Wei Zheng
 */
public class CourseSiteGeneratorController {

    CourseSiteGenerator app;
    //public String oldStartTime="8:00am";
    //public String oldEndTime="11:00pm";
            
    public CourseSiteGeneratorController(CourseSiteGenerator initApp) {
        app = initApp;
    }
    /*
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
    */
    
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
        //data.setTimeRanges(startHour, endHour);
        app.getFoolproofModule().updateControls(CSG_FOOLPROOF_SETTINGS);
        ChangeTimeRangeTransaction transaction = new ChangeTimeRangeTransaction(data,data.getStartHour(),data.getEndHour()
                ,startHour,endHour);
        app.processTransaction(transaction);
       
    }
    /*
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
        InputStream is = new FileInputStream(jsonFilePath);
        JsonReader jsonReader = Json.createReader(is);
        JsonObject json = jsonReader.readObject();
        jsonReader.close();
        is.close();
        return json;
    }
    public void setSubject() throws IOException{
        AppGUIModule gui = app.getGUIModule();
        ComboBox subjectTextField = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        JsonObject json = loadJSONFile("./options/site");
        JsonArray jsonSubjectsArray = json.getJsonArray("subjects");
        for (int i = 0; i < jsonSubjectsArray.size(); i++) {
            JsonObject jsonSubject = jsonSubjectsArray.getJsonObject(i);
            System.out.println(jsonSubject);
        }
        
    }
*/
    public void addSubject(String subject) throws FileNotFoundException{
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ComboBox subjectTextField = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        ObservableList<String> subjectList = subjectTextField.getItems();
        JsonArrayBuilder subjectsArrayBuilder = Json.createArrayBuilder();
        for (String s : subjectList){
            subjectsArrayBuilder.add(s);
        }
        subjectsArrayBuilder.add(subject);
        JsonArray subjects = subjectsArrayBuilder.build();
        subjectList.add(subject);
        
        ComboBox numberTextField = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        ObservableList<String> numberList = numberTextField.getItems();
        JsonArrayBuilder numbersArrayBuilder = Json.createArrayBuilder();
        for (String num : numberList) {
            numbersArrayBuilder.add(num);
        }
        JsonArray numbers = numbersArrayBuilder.build();

        JsonObject dataManagerJSO = Json.createObjectBuilder()
                .add("subjects", subjects)
                .add("numbers", numbers)
                .build();
        
        
        Map<String, Object> properties = new HashMap<>(1);
        properties.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
        StringWriter sw = new StringWriter();
        JsonWriter jsonWriter = writerFactory.createWriter(sw);
        jsonWriter.writeObject(dataManagerJSO);
        jsonWriter.close();

        // INIT THE WRITER
        OutputStream os = new FileOutputStream("./options/options.json");
        JsonWriter jsonFileWriter = Json.createWriter(os);
        jsonFileWriter.writeObject(dataManagerJSO);
        String prettyPrinted = sw.toString();
        PrintWriter pw = new PrintWriter("./options/options.json");
        pw.write(prettyPrinted);
        pw.close();
        
    }
    public void addNumber(String number) throws FileNotFoundException{
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ComboBox subjectTextField = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        ObservableList<String> subjectList = subjectTextField.getItems();
        JsonArrayBuilder subjectsArrayBuilder = Json.createArrayBuilder();
        for (String s : subjectList) {
            subjectsArrayBuilder.add(s);
        }
        JsonArray subjects = subjectsArrayBuilder.build();

        ComboBox numberTextField = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        ObservableList<String> numberList = numberTextField.getItems();
        JsonArrayBuilder numbersArrayBuilder = Json.createArrayBuilder();
        for (String num : numberList) {
            numbersArrayBuilder.add(num);
        }
        numbersArrayBuilder.add(number);
        JsonArray numbers = numbersArrayBuilder.build();
        numberList.add(number);

        JsonObject dataManagerJSO = Json.createObjectBuilder()
                .add("subjects", subjects)
                .add("numbers", numbers)
                .build();

        Map<String, Object> properties = new HashMap<>(1);
        properties.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
        StringWriter sw = new StringWriter();
        JsonWriter jsonWriter = writerFactory.createWriter(sw);
        jsonWriter.writeObject(dataManagerJSO);
        jsonWriter.close();

        // INIT THE WRITER
        OutputStream os = new FileOutputStream("./options/options.json");
        JsonWriter jsonFileWriter = Json.createWriter(os);
        jsonFileWriter.writeObject(dataManagerJSO);
        String prettyPrinted = sw.toString();
        PrintWriter pw = new PrintWriter("./options/options.json");
        pw.write(prettyPrinted);
        pw.close();
        
    }
    public void changeNumber(String number){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeNumberTransaction change= new ChangeNumberTransaction(data,data.getNumber() ,number);
        app.processTransaction(change);
        //data.changeNumber(number);
    }
    //private Desktop desktop = Desktop.getDesktop();
    
    public void changeSubject(String subject) {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeSubjectTransaction change = new ChangeSubjectTransaction(data, data.getSubject(), subject);
        app.processTransaction(change);
        //data.changeNumber(number);
    }
    public void changeYear(String year) {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeYearTransaction change = new ChangeYearTransaction(data, data.getYear(), year);
        app.processTransaction(change);
        //data.changeNumber(number);
    }
    public void changeSemester(String semester) {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeSemesterTransaction change = new ChangeSemesterTransaction(data, data.getSemester(), semester);
        app.processTransaction(change);
        //data.changeNumber(number);
    }
    
    public void changeTitle(String title){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeTitleTransaction change = new ChangeTitleTransaction(data, data.getTitle(), title);
        app.processTransaction(change);
    }
    
    public void changeHome(boolean home){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeHomeTransaction change = new ChangeHomeTransaction(data, data.getHome(), home);
        app.processTransaction(change);

    }
    
    public void changeSyllabus(boolean syllabus){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeSyllabusTransaction change = new ChangeSyllabusTransaction(data, data.getSyllabus(), syllabus);
        app.processTransaction(change);

    }
    
    public void changeSchedule(boolean schedule){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeScheduleTransaction change = new ChangeScheduleTransaction(data, data.getSchedule(), schedule);
        app.processTransaction(change);

    }
    
    public void changeHWS(boolean hws){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeHWSTransaction change = new ChangeHWSTransaction(data, data.getHWS(), hws);
        app.processTransaction(change);

    }
    
    public void changeFaviconImage(){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        FileChooser fileChooser = new FileChooser();
        /*
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG Files", "*.txt"),
                new FileChooser.ExtensionFilter("PNG Files", "*.htm"),
                new FileChooser.ExtensionFilter("BMP Files", "*.htm")
        );
*/
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            //openFile(file); 
            //System.out.print(file.toURI().toString());
            //Image image = new Image(file.toURI().toString());
            //ImageView faviconImage = (ImageView) gui.getGUINode(CSG_STYLE_FAVICON);
            //faviconImage.setImage(image);
            ChangeFaviconTransaction change= new ChangeFaviconTransaction(data,
                    data.getFaviconPath(), file.toURI().toString());
            app.processTransaction(change);
        }
    }
    public void changeNavbarImage() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            ChangeNavbarTransaction change = new ChangeNavbarTransaction(data,
                    data.getNavbarPath(), file.toURI().toString());
            app.processTransaction(change);
        }
    }
    public void changeLeftFooterImage() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            ChangeLeftFooterTransaction change = new ChangeLeftFooterTransaction(data,
                    data.getLeftFooterPath(), file.toURI().toString());
            app.processTransaction(change);
        }
    }
    public void changeRightFooterImage() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            ChangeRightFooterTransaction change = new ChangeRightFooterTransaction(data,
                    data.getRightFooterPath(), file.toURI().toString());
            app.processTransaction(change);
        }
    }
    public void changeCSS(String css){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeCSSTransaction change = new ChangeCSSTransaction(data, data.getCSS(), css);
        app.processTransaction(change);
    }
    
    public void changeInstructorName(String name){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeInstructorNameTransaction change = new ChangeInstructorNameTransaction(data, data.getInstructorName(), name);
        app.processTransaction(change);
    }
    
    public void changeInstructorHome(String home){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeInstructorHomeTransaction change = new ChangeInstructorHomeTransaction(data, data.getInstructorHomepage(), home);
        app.processTransaction(change);
    }
    
    public void changeInstructorRoom(String room){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeInstructorRoomTransaction change = new ChangeInstructorRoomTransaction(data, data.getInstructorRoom(), room);
        app.processTransaction(change);
    }
    
    public void changeInstructorEmail(String email){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeInstructorEmailTransaction change = new ChangeInstructorEmailTransaction(data, data.getInstructorEmail(), email);
        app.processTransaction(change);
    }
    
    public void changeInstructorOfficeHours(String officeHours){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeInstructorOfficeHoursTransaction change = new ChangeInstructorOfficeHoursTransaction(data, data.getInstructorOfficeHours(), officeHours);
        app.processTransaction(change);
    }
    
    public void changeDescription(String description){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeDescriptionTransaction change = new ChangeDescriptionTransaction(data, data.getDescription(), description);
        app.processTransaction(change);
    }
    public void changeTopics(String topics){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeTopicsTransaction change = new ChangeTopicsTransaction(data, data.getTopics(), topics);
        app.processTransaction(change);
    }
    public void changePrereq(String prereq){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangePrereqTransaction change = new ChangePrereqTransaction(data, data.getPrereq(), prereq);
        app.processTransaction(change);
    }
    public void changeOutcomes(String outcomes){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeOutcomesTransaction change = new ChangeOutcomesTransaction(data, data.getOutcomes(), outcomes);
        app.processTransaction(change);
    }
    public void changeTextbooks(String textbooks){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeTextbooksTransaction change = new ChangeTextbooksTransaction(data, data.getTextbooks(), textbooks);
        app.processTransaction(change);
    }
    public void changeGradedcomp(String gradingcomp){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeGradingcompTransaction change = new ChangeGradingcompTransaction(data, data.getGradedcomp(), gradingcomp);
        app.processTransaction(change);
    }
    public void changeGradingNote(String gradingNote){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeGradingNoteTransaction change = new ChangeGradingNoteTransaction(data, data.getGradingNote(), gradingNote);
        app.processTransaction(change);
    }
    public void changeAcedemic(String acedemic){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeAcedemicTransaction change = new ChangeAcedemicTransaction(data, data.getAcedemic(), acedemic);
        app.processTransaction(change);
    }
    public void changeSpecial(String special){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        ChangeSpecialTransaction change = new ChangeSpecialTransaction(data, data.getSpecial(), special);
        app.processTransaction(change);
    }
    public void addLecture() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        Lecture lecture = new Lecture();
        AddLectureTransaction newLecture = new AddLectureTransaction(data, lecture);
        app.processTransaction(newLecture);
    }
    public void editLecture(String type, String oldVal, String newVal){
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TableView<Lecture> lectureTable = (TableView) gui.getGUINode(CSG_MEETING_LECTURE_TABLE);
        Lecture lecture = lectureTable.getSelectionModel().getSelectedItem();
        ChangeLectureTransaction editLecture = new ChangeLectureTransaction(data, lecture, type, oldVal, newVal);
        app.processTransaction(editLecture);
    }
    public void removeLecture() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TableView<Lecture> lectureTable = (TableView) gui.getGUINode(CSG_MEETING_LECTURE_TABLE);
        Lecture lecture = lectureTable.getSelectionModel().getSelectedItem();
        RemoveLectureTransaction remove = new RemoveLectureTransaction(data, lecture);
        app.processTransaction(remove);
    }
    public void addRecitation() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        Recitation recitation = new Recitation();
        AddRecitationTransaction newRecitation = new AddRecitationTransaction(data, recitation);
        app.processTransaction(newRecitation);
    }
    public void editRecitation(String type, String oldVal, String newVal) {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TableView<Recitation> recitationTable = (TableView) gui.getGUINode(CSG_MEETING_RECITATION_TABLE);
        Recitation recitation = recitationTable.getSelectionModel().getSelectedItem();
        ChangeRecitationTransaction editRecitation = new ChangeRecitationTransaction(data, recitation, type, oldVal, newVal);
        app.processTransaction(editRecitation);
    }
    public void removeRecitation( ) {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TableView<Recitation> recitationTable = (TableView) gui.getGUINode(CSG_MEETING_RECITATION_TABLE);
        Recitation recitation = recitationTable.getSelectionModel().getSelectedItem();
        RemoveRecitationTransaction remove = new RemoveRecitationTransaction(data, recitation);
        app.processTransaction(remove);
    }
    public void addLab() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        Lab lab = new Lab();
        AddLabTransaction newLab = new AddLabTransaction(data, lab);
        app.processTransaction(newLab);
    }
    public void editLab(String type, String oldVal, String newVal) {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TableView<Lab> labTable = (TableView) gui.getGUINode(CSG_MEETING_LAB_TABLE);
        Lab lab = labTable.getSelectionModel().getSelectedItem();
        ChangeLabTransaction editLab = new ChangeLabTransaction(data, lab, type, oldVal, newVal);
        app.processTransaction(editLab);
    }
    public void removeLab() {
        AppGUIModule gui = app.getGUIModule();
        CourseSiteData data = (CourseSiteData) app.getDataComponent();
        TableView<Lab> labTable = (TableView) gui.getGUINode(CSG_MEETING_LAB_TABLE);
        Lab lab = labTable.getSelectionModel().getSelectedItem();
        RemoveLabTransaction remove = new RemoveLabTransaction(data, lab);
        app.processTransaction(remove);
    }
    
    /*
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(CourseSiteGeneratorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
}