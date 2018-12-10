package coursesitegenerator.data;

import javafx.collections.ObservableList;
import djf.components.AppDataComponent;
import djf.modules.AppGUIModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import coursesitegenerator.CourseSiteGenerator;
import static coursesitegenerator.CourseSitePropertyType.CSG_ALL_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_GRAD_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_LAB_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_LECTURE_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_RECITATION_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_EDIT_DATEPICKER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_END_DATEPICKER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_START_DATEPICKER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_TABLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_EXPORTDIRTEXT;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_INSTRUCTOR_EMAIL_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_INSTRUCTOR_HOMEPAGE_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_INSTRUCTOR_NAME_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_INSTRUCTOR_OFFICEHOURS_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_INSTRUCTOR_ROOM_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_NUMBER_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_HOME_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_HWS_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_SCHEDULE_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_SYLLABUS_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_SEMESTER_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_STYLE_CSS;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_SUBJECT_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_TITLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_YEAR_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_STYLE_FAVICON;
import static coursesitegenerator.CourseSitePropertyType.CSG_STYLE_LEFTFOOTER;
import static coursesitegenerator.CourseSitePropertyType.CSG_STYLE_NAVBAR;
import static coursesitegenerator.CourseSitePropertyType.CSG_STYLE_RIGHTFOOTER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_ACDEDEMIC_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_DESCRIPTION_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_DESCRIPTION_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_GRADEDCOMPONENTS_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_GRADEDCOMP_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_GRADINGNOTE_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_GRADINGNOTE_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_OUTCOMES_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_OUTCOMES_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_PREREQ_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_PREREQ_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_SPECIALASSISTANCE_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_SPECIAL_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_TEXTBOOKS_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_TEXTBOOKS_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_TOPICS_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_TOPICS_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_TABLE_VIEW;
import coursesitegenerator.data.TimeSlot.DayOfWeek;
import coursesitegenerator.workspace.CourseSiteWorkspace;
import static coursesitegenerator.workspace.style.CSGStyle.CLASS_CSG_BUTTON;
import static coursesitegenerator.workspace.style.CSGStyle.CLASS_CSG_TEXT_FIELD;
import static djf.modules.AppGUIModule.ENABLED;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This is the data component for TAManagerApp. It has all the data needed
 * to be set by the user via the User Interface and file I/O can set and get
 * all the data from this object
 * 
 * @author Jia Wei Zheng
 */
public class CourseSiteData implements AppDataComponent {

    // WE'LL NEED ACCESS TO THE APP TO NOTIFY THE GUI WHEN DATA CHANGES
    CourseSiteGenerator app;
    
    // THESE ARE ALL THE TEACHING ASSISTANTS
    HashMap<TAType, ArrayList<TeachingAssistantPrototype>> allTAs;

    // NOTE THAT THIS DATA STRUCTURE WILL DIRECTLY STORE THE
    // DATA IN THE ROWS OF THE TABLE VIEW
    ObservableList<TeachingAssistantPrototype> teachingAssistants;
    ObservableList<TimeSlot> officeHours;
    ObservableList<String> endHours;
    ObservableList<Lecture> lectures;
    ObservableList<Recitation> recitations;
    ObservableList<Lab> labs;
    ObservableList<ScheduleItem> scheduleList;


    // THESE ARE THE TIME BOUNDS FOR THE OFFICE HOURS GRID. NOTE
    // THAT THESE VALUES CAN BE DIFFERENT FOR DIFFERENT FILES, BUT
    // THAT OUR APPLICATION USES THE DEFAULT TIME VALUES AND PROVIDES
    // NO MEANS FOR CHANGING THESE VALUES
    int startHour;
    int endHour;
     
    // DEFAULT VALUES FOR START AND END HOURS IN MILITARY HOURS
    public static final int MIN_START_HOUR = 8;
    public static final int MAX_END_HOUR = 22;
    
    /*
    private static final FileInputStream defualtFaviconPath = new FileInputStream("./images/favicon.png");
    private static final FileInputStream defualtNavPath = new FileInputStream("./images/navbar.png");
    private static final FileInputStream defualtFaviconPath = new FileInputStream("./images/leftFooter.png");
    private static final FileInputStream defualtFaviconPath = new FileInputStream("./images/rightFooter.png");
    */
    
    private static final String defualtFaviconPath = ("./images/favicon.png");
    private static final String defualtNavPath =  ("./images/navbar.png");
    private static final String defualtLeftFooterPath =  ("./images/leftFooter.png");
    private static final String defualtRightFooterPath =  ("./images/rightFooter.png");
    private String faviconPath = ("./images/favicon.png");
    private String navbarPath =  ("./images/navbar.png");
    private String leftFooterPath =  ("./images/leftFooter.png");
    private String rightFooterPath =  ("./images/rightFooter.png");
    
    private String startTime="8:00am";
    private String endTime="10:00pm";
    private String subject="";
    private String number="";
    private String semester="";
    private String year="";
    private String title="";
    private String exportdir="";
    private boolean home=false;
    private boolean syllabus=false;
    private boolean schedule=false;
    private boolean hws=false;
    private String css="sea_wolf.css";
    private String instructorName="";
    private String instructorRoom="";
    private String instructorEmail="";
    private String instructorHomepage="";
    private String instructorOfficeHours="";
    
    private String description="";
    private String topics = "";
    private String prereq = "";
    private String outcomes = "";
    private String textbooks = "";
    private String gradedcomp = "";
    private String gradingNote = "";
    private String acedemic = "";
    private String special = "";

    private LocalDate startDate = null;
    private LocalDate endDate = null;
    private LocalDate editDate = null;

    

    //public String oldStartTime="8:00am";
    //public String oldEndTime="11:00pm";

    /**
     * This constructor will setup the required data structures for
     * use, but will have to wait on the office hours grid, since
     * it receives the StringProperty objects from the Workspace.
     * 
     * @param initApp The application this data manager belongs to. 
     */
    public CourseSiteData(CourseSiteGenerator initApp) {
        // KEEP THIS FOR LATER
        app = initApp;
        AppGUIModule gui = app.getGUIModule();

        // SETUP THE DATA STRUCTURES
        allTAs = new HashMap();
        allTAs.put(TAType.Graduate, new ArrayList());
        allTAs.put(TAType.Undergraduate, new ArrayList());
        
        // GET THE LIST OF TAs FOR THE LEFT TABLE
        TableView<TeachingAssistantPrototype> taTableView = (TableView)gui.getGUINode(CSG_TAS_TABLE_VIEW);
        teachingAssistants = taTableView.getItems();
        
        TableView<Lecture> lectureTableView = (TableView)gui.getGUINode(CSG_MEETING_LECTURE_TABLE);
        lectures = lectureTableView.getItems();
        TableView<Recitation> recitationTableView = (TableView)gui.getGUINode(CSG_MEETING_RECITATION_TABLE);
        recitations = recitationTableView.getItems();
        TableView<Lab> labTableView = (TableView)gui.getGUINode(CSG_MEETING_LAB_TABLE);
        labs = labTableView.getItems();
        TableView<ScheduleItem> scheduleTable = (TableView) gui.getGUINode(CSG_SCHEDULE_TABLE);
        scheduleList = scheduleTable.getItems();
        
        // THESE ARE THE DEFAULT OFFICE HOURS
        startHour = MIN_START_HOUR;
        endHour = MAX_END_HOUR;
        
        resetOfficeHours();
    }
    
    // ACCESSOR METHODS
    
    public String getSubject(){
        return subject;
    }
    public String getNumber(){
        return number;
    }
    public String getSemester(){
        return semester;
    }
    public String getYear(){
        return year;
    }
    public String getTitle(){
        return title;
    }
    public String getExportdir(){
        return exportdir;
    }
    public boolean getHome(){
        return home;
    }
    public boolean getSyllabus(){
        return syllabus;
    }
    public boolean getSchedule(){
        return schedule;
    }
    public boolean getHWS(){
        return hws;
    }
    public String getCSS(){
        return css;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }
    public LocalDate getEditDate(){
        return editDate;
    }
    public String getInstructorName(){
        return instructorName;
    }
    public String getInstructorRoom(){
        return instructorRoom;
    }
    public String getInstructorEmail(){
        return instructorEmail;
    }
    public String getInstructorHomepage(){
        return instructorHomepage;
    }
    public String getInstructorOfficeHours(){
        return instructorOfficeHours;
    }
    
    public String getDescription() {
        return description;
    }
    public String getTopics() {
        return topics;
    }
    public String getPrereq() {
        return prereq;
    }
    public String getOutcomes() {
        return outcomes;
    }
    public String getTextbooks() {
        return textbooks;
    }
    public String getGradedcomp() {
        return gradedcomp;
    }
    public String getGradingNote() {
        return gradingNote;
    }
    public String getAcedemic() {
        return acedemic;
    }
    public String getSpecial() {
        return special;
    }
    
    public int getStartHour() {
        return startHour;
    }
    public void changeNumber(String newNumber){
        number=newNumber;
        AppGUIModule gui = app.getGUIModule();
        ComboBox combo = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        combo.setValue(newNumber);

    }
    public void changeSubject(String newSubject){
        subject=newSubject;
        AppGUIModule gui = app.getGUIModule();
        ComboBox combo = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        combo.setValue(newSubject);
    }
    
    public void changeSemester(String newSemester){
        semester=newSemester;
        AppGUIModule gui = app.getGUIModule();
        ComboBox combo = (ComboBox) gui.getGUINode(CSG_SITE_SEMESTER_COMBOBOX);
        combo.setValue(newSemester);
    }
    
    public void changeCSS(String newCSS){
        css=newCSS;
        AppGUIModule gui = app.getGUIModule();
        ComboBox css = (ComboBox) gui.getGUINode(CSG_SITE_STYLE_CSS);
        css.setValue(newCSS);
    }
    
    public void changeTitle(String newTitle){
        title=newTitle;
        AppGUIModule gui = app.getGUIModule();
        TextField text = (TextField) gui.getGUINode(CSG_SITE_TITLE);
        text.setText(newTitle);
    }
    
    public void changeYear(String newYear){
        year = newYear;
        AppGUIModule gui = app.getGUIModule();
        ComboBox combo = (ComboBox) gui.getGUINode(CSG_SITE_YEAR_COMBOBOX);
        combo.setValue(newYear);
    }
    public void changeHome(boolean newHome){
        home=newHome;
        AppGUIModule gui = app.getGUIModule();
        CheckBox homeCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_HOME_CHECK);
        homeCheckBox.setSelected(newHome);
    }
    public void changeSyllabus(boolean newSyllabus){
        syllabus=newSyllabus;
        AppGUIModule gui = app.getGUIModule();
        CheckBox syllabusCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_SYLLABUS_CHECK);
        syllabusCheckBox.setSelected(newSyllabus);
    }
    public void changeSchedule(boolean newSchedule){
        schedule=newSchedule;
        AppGUIModule gui = app.getGUIModule();
        CheckBox scheduleCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_SCHEDULE_CHECK);
        scheduleCheckBox.setSelected(newSchedule);
    }
    public void changeHWS(boolean newHWS){
        hws=newHWS;
        AppGUIModule gui = app.getGUIModule();
        CheckBox homeCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_HWS_CHECK);
        homeCheckBox.setSelected(newHWS);
    }
    
    public void changeInstructorEmail(String email){
        instructorEmail=email;
        AppGUIModule gui = app.getGUIModule();
        TextField text = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_EMAIL_FIELD);
        text.setText(email);
    }
    public void changeInstructorHome(String home){
        instructorHomepage=home;
        AppGUIModule gui = app.getGUIModule();
        TextField text = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_HOMEPAGE_FIELD);
        text.setText(home);
    }
    public void changeInstructorName(String name){
        instructorName=name;
        AppGUIModule gui = app.getGUIModule();
        TextField text = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_NAME_FIELD);
        text.setText(name);
    }
    public void changeInstructorOfficeHours(String officeHours){
        instructorOfficeHours=officeHours;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD);
        text.setText(officeHours);
    }
    public void changeInstructorRoom(String room){
        instructorRoom=room;
        AppGUIModule gui = app.getGUIModule();
        TextField text = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_ROOM_FIELD);
        text.setText(room);
    }
    
    public void changeDescription(String newDescription){
        description=newDescription;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_DESCRIPTION_BOX);
        text.setText(newDescription);
    }
    public void changeTopics(String newTopics){
        topics=newTopics;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_TOPICS_BOX);
        text.setText(newTopics);
    }
    public void changePrereq(String newPrereq){
        prereq=newPrereq;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_PREREQ_BOX);
        text.setText(newPrereq);
    }
    public void changeOutcomes(String newOutcomes){
        outcomes=newOutcomes;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_OUTCOMES_BOX);
        text.setText(newOutcomes);
    }
    public void changeTextbooks(String newTextbooks){
        textbooks=newTextbooks;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_TEXTBOOKS_BOX);
        text.setText(newTextbooks);
    }
    public void changeGradedcomp(String newGradedcomp){
        gradedcomp=newGradedcomp;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADEDCOMPONENTS_BOX);
        text.setText(newGradedcomp);
    }
    public void changeGradingNote(String newGradingNote){
        gradingNote=newGradingNote;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADINGNOTE_BOX);
        text.setText(newGradingNote);
    }
    public void changeAcedemic(String newAcedemic){
        acedemic=newAcedemic;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX);
        text.setText(newAcedemic);
    }
    public void changeSpecial(String newSpecial){
        special=newSpecial;
        AppGUIModule gui = app.getGUIModule();
        TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_SPECIALASSISTANCE_BOX);
        text.setText(newSpecial);
    }
    public void changeStartDate(LocalDate date){
        startDate=date;
        AppGUIModule gui = app.getGUIModule();
        DatePicker startDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_START_DATEPICKER);
        startDatePicker.setValue(date);
    }
    public void changeEndDate(LocalDate date){
        endDate=date;
        AppGUIModule gui = app.getGUIModule();
        DatePicker endDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_END_DATEPICKER);
        endDatePicker.setValue(date);
    }
    public void changeEditDate(LocalDate date){
        editDate=date;
        AppGUIModule gui = app.getGUIModule();
        DatePicker editDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_EDIT_DATEPICKER);
        editDatePicker.setValue(date);
    }
    /*
    public String getOldStartTime() {
        return oldStartTime;
    }

    public String getOldEndTime() {
        return oldEndTime;
    }

    public void setOldStartTime(String time) {
        oldStartTime = time;
    }

    public void setOldEndTime(String time) {
        oldEndTime = time;
    }
*/
    
    public void setFaviconPath(String path){
        faviconPath=path;
    }
    public void setNavbarPath(String path) {
        navbarPath = path;
    }
    public void setLeftFooterPath(String path) {
        leftFooterPath = path;
    }
    public void setRightFooterPath(String path) {
        rightFooterPath = path;
    }
    public String getFaviconPath() {
        return faviconPath;
    }
    public String getNavbarPath () {
        return navbarPath;
    }
    public String getLeftFooterPath() {
        return leftFooterPath;
    }
    public String getRightFooterPath() {
        return rightFooterPath;
    }
    public void setFavicon(){
        AppGUIModule gui = app.getGUIModule();
        ImageView faviconImage = (ImageView) gui.getGUINode(CSG_STYLE_FAVICON);
        try {
            FileInputStream input2 = new FileInputStream(faviconPath);
            Image image= new Image(input2);
            faviconImage.setImage(image);
        } catch (FileNotFoundException ex) {
            Image image= new Image(faviconPath);
            faviconImage.setImage(image);
        }
    }
    public void setNavbar() {
        AppGUIModule gui = app.getGUIModule();
        ImageView navbarImage = (ImageView) gui.getGUINode(CSG_STYLE_NAVBAR);
        try {
            FileInputStream input2 = new FileInputStream(navbarPath);
            Image image = new Image(input2);
            navbarImage.setImage(image);
        } catch (FileNotFoundException ex) {
            Image image = new Image(navbarPath);
            navbarImage.setImage(image);
        }
    }
    public void setLeftFooter() {
        AppGUIModule gui = app.getGUIModule();
        ImageView leftFooterImage = (ImageView) gui.getGUINode(CSG_STYLE_LEFTFOOTER);
        try {
            FileInputStream input2 = new FileInputStream(leftFooterPath);
            Image image = new Image(input2);
            leftFooterImage.setImage(image);
        } catch (FileNotFoundException ex) {
            Image image = new Image(leftFooterPath);
            leftFooterImage.setImage(image);
        }
    }
    public void setRightFooter() {
        AppGUIModule gui = app.getGUIModule();
        ImageView rightFooterImage = (ImageView) gui.getGUINode(CSG_STYLE_RIGHTFOOTER);
        try {
            FileInputStream input2 = new FileInputStream(rightFooterPath);
            Image image = new Image(input2);
            rightFooterImage.setImage(image);
        } catch (FileNotFoundException ex) {
            Image image = new Image(rightFooterPath);
            rightFooterImage.setImage(image);
        }
    }
    
    public int getEndHour() {
        return endHour;
    }
    
    public ObservableList<String> getEndTimes(){
        return endHours;
    }
    // PRIVATE HELPER METHODS
    
    private void sortTAs() {
        Collections.sort(teachingAssistants);
    }
    
    private void resetSite(){//TODO add all fields
        AppGUIModule gui = app.getGUIModule();
        ComboBox subjectComboBox = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        ComboBox semesterComboBox = (ComboBox) gui.getGUINode(CSG_SITE_SEMESTER_COMBOBOX);
        ComboBox numberComboBox = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        ComboBox yearComboBox = (ComboBox) gui.getGUINode(CSG_SITE_YEAR_COMBOBOX);
        changeSubject("");
        changeSemester("");
        changeNumber("");
        yearComboBox.setValue(Year.now().getValue());
        TextField titleField = (TextField) gui.getGUINode(CSG_SITE_TITLE);
        titleField.setText("");
        Label exportDirText = (Label) gui.getGUINode(CSG_SITE_BANNER_EXPORTDIRTEXT);
        exportDirText.setText(".\\export");
        CheckBox homeCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_HOME_CHECK);
        CheckBox syllabusCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_SYLLABUS_CHECK);
        CheckBox scheduleCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_SCHEDULE_CHECK);
        CheckBox hwsCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_HWS_CHECK);
        homeCheckBox.setSelected(false);
        syllabusCheckBox.setSelected(false);
        scheduleCheckBox.setSelected(false);
        hwsCheckBox.setSelected(false);
        
        resetImages();
        
        ComboBox cssComboBox = (ComboBox) gui.getGUINode(CSG_SITE_STYLE_CSS);
        cssComboBox.getItems().clear();
        File folder = new File("./work/css");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                cssComboBox.getItems().add(file.getName());
            }
        }
        changeCSS("sea_wolf.css");
        
        TextField nameField =(TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_NAME_FIELD);
        TextField emailField = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_ROOM_FIELD);
        TextField roomField = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_EMAIL_FIELD);
        TextField homePageField = (TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_HOMEPAGE_FIELD);
        TextArea officeHoursTextField = (TextArea) gui.getGUINode(CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD);
        
        nameField.clear();
        emailField.clear();
        roomField.clear();
        homePageField.clear();
        officeHoursTextField.clear();
        officeHoursTextField.setVisible(false);
        Button instructorOfficeHoursButton = (Button) gui.getGUINode(CSG_SITE_INSTRUCTOR_OFFICEHOURS_BUTTON);
        instructorOfficeHoursButton.setText("+");
    }
    
    public void resetImages(){
        AppGUIModule gui = app.getGUIModule();

        ImageView faviconImage = (ImageView) gui.getGUINode(CSG_STYLE_FAVICON);
        ImageView navbarImage = (ImageView) gui.getGUINode(CSG_STYLE_NAVBAR);
        ImageView leftFooterImage = (ImageView) gui.getGUINode(CSG_STYLE_LEFTFOOTER);
        ImageView rightFooterImage = (ImageView) gui.getGUINode(CSG_STYLE_RIGHTFOOTER);
        
        try {
            FileInputStream input = new FileInputStream(defualtFaviconPath);
            Image image = new Image(input);
            faviconImage.setImage(image);
            FileInputStream input2 = new FileInputStream(defualtNavPath);
            Image image2 = new Image(input2);
            navbarImage.setImage(image2);
            FileInputStream input3 = new FileInputStream(defualtLeftFooterPath);
            Image image3 = new Image(input3);
            leftFooterImage.setImage(image3);
            FileInputStream input4 = new FileInputStream(defualtRightFooterPath);
            Image image4 = new Image(input4);
            rightFooterImage.setImage(image4);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CourseSiteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetSyllabus(){
        AppGUIModule gui = app.getGUIModule();
        Button descriptionButton = (Button) gui.getGUINode(CSG_SYLLABUS_DESCRIPTION_BUTTON);
        Button topicsButton = (Button) gui.getGUINode(CSG_SYLLABUS_TOPICS_BUTTON);
        Button prereqButton = (Button) gui.getGUINode(CSG_SYLLABUS_PREREQ_BUTTON);
        Button outcomesButton = (Button) gui.getGUINode(CSG_SYLLABUS_OUTCOMES_BUTTON);
        Button textbooksButton = (Button) gui.getGUINode(CSG_SYLLABUS_TEXTBOOKS_BUTTON);
        Button gradedcompButton = (Button) gui.getGUINode(CSG_SYLLABUS_GRADEDCOMP_BUTTON);
        Button gradingNoteButton = (Button) gui.getGUINode(CSG_SYLLABUS_GRADINGNOTE_BUTTON);
        Button acedemicButton = (Button) gui.getGUINode(CSG_SYLLABUS_ACDEDEMIC_BUTTON);
        Button specialButton = (Button) gui.getGUINode(CSG_SYLLABUS_SPECIAL_BUTTON);
        TextArea descriptionTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_DESCRIPTION_BOX);
        TextArea topicsTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_TOPICS_BOX);
        TextArea prereqTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_PREREQ_BOX);
        TextArea outcomesTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_OUTCOMES_BOX);
        TextArea textbooksTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_TEXTBOOKS_BOX);
        TextArea gradingcompTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADEDCOMPONENTS_BOX);
        TextArea gradingNoteTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADINGNOTE_BOX);
        TextArea acedemicTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX);
        TextArea specialTextField = (TextArea) gui.getGUINode(CSG_SYLLABUS_SPECIALASSISTANCE_BOX);
        
        descriptionTextField.setVisible(true);
        topicsTextField.setVisible(false);
        prereqTextField.setVisible(false);
        outcomesTextField.setVisible(false);
        textbooksTextField.setVisible(false);
        gradingcompTextField.setVisible(false);
        gradingNoteTextField.setVisible(false);
        acedemicTextField.setVisible(false);
        specialTextField.setVisible(false);

        descriptionTextField.clear();
        topicsTextField.clear();
        prereqTextField.clear();
        outcomesTextField.clear();
        textbooksTextField.clear();
        gradingcompTextField.clear();
        gradingNoteTextField.clear();
        acedemicTextField.clear();
        specialTextField.clear();
        
        descriptionButton.setText("-");
        topicsButton.setText("+");
        prereqButton.setText("+");
        outcomesButton.setText("+");
        textbooksButton.setText("+");
        gradedcompButton.setText("+");
        gradingNoteButton.setText("+");
        acedemicButton.setText("+");
        specialButton.setText("+");
    }
    
    private void resetOfficeHours() {
        //THIS WILL STORE OUR OFFICE HOURS
        
        AppGUIModule gui = app.getGUIModule();
        TableView<TimeSlot> officeHoursTableView = (TableView)gui.getGUINode(CSG_OFFICE_HOURS_TABLE_VIEW);
        officeHours = officeHoursTableView.getItems(); 
        officeHours.clear();
        for (int i = startHour; i <= endHour; i++) {
            TimeSlot timeSlot = new TimeSlot(   this.getTimeString(i, true),
                                                this.getTimeString(i, false));
            officeHours.add(timeSlot);
            
            TimeSlot halfTimeSlot = new TimeSlot(   this.getTimeString(i, false),
                                                    this.getTimeString(i+1, true));
            officeHours.add(halfTimeSlot);
        }
        ComboBox startTimeComboBox = (ComboBox) gui.getGUINode(CSG_START_TIME_COMBOBOX);
        ComboBox endTimeComboBox = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
        startTimeComboBox.setValue(startHour+":00am");
        endTimeComboBox.setValue(endHour-12+":00pm");
        //endHours=(endTimeComboBox.getItems());
        endHours=FXCollections.observableArrayList(endTimeComboBox.getItems());
        //System.out.println(endHours);
    }
        private void resetSchedule() {
            startDate=null;
            endDate=null;
            editDate=null;
            
        }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mma");
    
    public void setTimeRanges (int start, int end){
        AppGUIModule gui = app.getGUIModule();
        ComboBox startTimeBox = (ComboBox) gui.getGUINode(CSG_START_TIME_COMBOBOX);
        ComboBox endTimeBox = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
        //System.out.println("start: " +start+"end: "+end);
        if(start>=end)
            return;
        
        FilteredList<TimeSlot> filteredTimeslots = new FilteredList<>(officeHours, p -> true);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mma");
        filteredTimeslots.setPredicate(slot -> {
            int slotTime=Integer.parseInt(slot.getStartTime().substring(0,slot.getStartTime().indexOf(":")));
            if (slot.getStartTime().charAt(slot.getStartTime().length() - 2) == 'p' && slotTime != 12) {
                slotTime += 12;
            }
            //System.out.println(slotTime);
            if (slotTime>=start && slotTime<end)
                return true;
            else 
                return false;
        });

        TableView<TimeSlot> officeHoursTableView = (TableView) gui.getGUINode(CSG_OFFICE_HOURS_TABLE_VIEW);
        SortedList<TimeSlot> sortedTime = new SortedList<>(filteredTimeslots);
        sortedTime.comparatorProperty().bind(officeHoursTableView.comparatorProperty());
        officeHoursTableView.setItems(sortedTime);
        
        if(start<12){
            startTime=start+":00am";
            startTimeBox.setValue(start+":00am");
            startHour=Integer.parseInt(startTime.substring(0, startTime.indexOf(":")));
            //oldStartTime=start+":00am";
        }
        else if (start == 12){
            startTime=start+":00pm";
            startTimeBox.setValue(start + ":00pm");
            startHour=Integer.parseInt(startTime.substring(0, startTime.indexOf(":")));
            //oldStartTime=start+":00pm";
        }
        else{
            startTime=start-12+":00pm";
            startTimeBox.setValue(start-12+":00pm");
            startHour=Integer.parseInt(startTime.substring(0, startTime.indexOf(":")));
            startHour+=12;
//oldStartTime=start-12+":00pm";
        }
        if (end < 12) {
            endTime=start+":00am";
            endTimeBox.setValue(end + ":00am");
            endHour=Integer.parseInt(endTime.substring(0, endTime.indexOf(":")));
            //oldEndTime=start+":00am";
        }
        else if(end==12){
            endTime=start+":00pm";
            endTimeBox.setValue(end + ":00pm");
            endHour=Integer.parseInt(endTime.substring(0, endTime.indexOf(":")));
            //oldEndTime=start+":00pm";
        }
        else {
            endTime=end-12 + ":00pm";
            endTimeBox.setValue(end-12 + ":00pm");
            endHour=Integer.parseInt(endTime.substring(0, endTime.indexOf(":")));
            endHour+=12;
//oldEndTime=start+":00pm";
        }
        
        
        
        //startHour=start;
        //endHour=end;
    }
    
    public String getStartTime(){
        return startTime;
    }
    public String getEndTime(){
        return endTime;
    }
    
    
    private String getTimeString(int militaryHour, boolean onHour) {
        String minutesText = "00";
        if (!onHour) {
            minutesText = "30";
        }

        // FIRST THE START AND END CELLS
        int hour = militaryHour;
        if (hour > 12) {
            hour -= 12;
        }
        String cellText = "" + hour + ":" + minutesText;
        if (militaryHour < 12) {
            cellText += "am";
        } else {
            cellText += "pm";
        }
        return cellText;
    }
    
    // METHODS TO OVERRIDE
        
    /**
     * Called each time new work is created or loaded, it resets all data
     * and data structures such that they can be used for new values.
     */
    @Override
    public void reset() {
        startHour = MIN_START_HOUR;
        endHour = MAX_END_HOUR;
        teachingAssistants.clear();
        allTAs.forEach((key,value)->value.clear());
        lectures.clear();
        recitations.clear();
        labs.clear();
        scheduleList.clear();
        
        
        for (TimeSlot timeSlot : officeHours) {
            timeSlot.reset();
        }
        resetSite();
        resetSyllabus();
    }
    
    // SERVICE METHODS
    
    public void initHours(String startHourText, String endHourText) {
        int initStartHour = Integer.parseInt(startHourText);
        int initEndHour = Integer.parseInt(endHourText);
        if (initStartHour <= initEndHour) {
            // THESE ARE VALID HOURS SO KEEP THEM
            // NOTE THAT THESE VALUES MUST BE PRE-VERIFIED
            startHour = initStartHour;
            endHour = initEndHour;
        }
        resetOfficeHours();
    }
    
    public void addTA(TeachingAssistantPrototype ta) {
        if (!hasTA(ta)) {
            TAType taType = TAType.valueOf(ta.getType());
            ArrayList<TeachingAssistantPrototype> tas = allTAs.get(taType);
            tas.add(ta);
            this.updateTAs();
        }
    }

    public void addTA(TeachingAssistantPrototype ta, HashMap<TimeSlot, ArrayList<DayOfWeek>> officeHours) {
        addTA(ta);
        for (TimeSlot timeSlot : officeHours.keySet()) {
            ArrayList<DayOfWeek> days = officeHours.get(timeSlot);
            for (DayOfWeek dow : days) {
                timeSlot.addTA(dow, ta);
            }
        }
    }
    
    public void removeTA(TeachingAssistantPrototype ta) {
        // REMOVE THE TA FROM THE LIST OF TAs
        TAType taType = TAType.valueOf(ta.getType());
        allTAs.get(taType).remove(ta);
        
        // REMOVE THE TA FROM ALL OF THEIR OFFICE HOURS
        for (TimeSlot timeSlot : officeHours) {
            timeSlot.removeTA(ta);
        }
        
        // AND REFRESH THE TABLES
        this.updateTAs();
    }

    public void removeTA(TeachingAssistantPrototype ta, HashMap<TimeSlot, ArrayList<DayOfWeek>> officeHours) {
        removeTA(ta);
        for (TimeSlot timeSlot : officeHours.keySet()) {
            ArrayList<DayOfWeek> days = officeHours.get(timeSlot);
            for (DayOfWeek dow : days) {
                timeSlot.removeTA(dow, ta);
            }
        }    
    }
    public void addScheduleItem(ScheduleItem item){
        scheduleList.add(item);
    }
    
    public void removeScheduleItem(ScheduleItem item){
        scheduleList.remove(item);
    }
    
    public DayOfWeek getColumnDayOfWeek(int columnNumber) {
        return TimeSlot.DayOfWeek.values()[columnNumber-2];
    }

    public TeachingAssistantPrototype getTAWithName(String name) {
        Iterator<TeachingAssistantPrototype> taIterator = teachingAssistants.iterator();
        while (taIterator.hasNext()) {
            TeachingAssistantPrototype ta = taIterator.next();
            if (ta.getName().equals(name))
                return ta;
        }
        return null;
    }

    public TeachingAssistantPrototype getTAWithEmail(String email) {
        Iterator<TeachingAssistantPrototype> taIterator = teachingAssistants.iterator();
        while (taIterator.hasNext()) {
            TeachingAssistantPrototype ta = taIterator.next();
            if (ta.getEmail().equals(email))
                return ta;
        }
        return null;
    }

    public TimeSlot getTimeSlot(String startTime) {
        Iterator<TimeSlot> timeSlotsIterator = officeHours.iterator();
        while (timeSlotsIterator.hasNext()) {
            TimeSlot timeSlot = timeSlotsIterator.next();
            String timeSlotStartTime = timeSlot.getStartTime().replace(":", "_");
            if (timeSlotStartTime.equals(startTime))
                return timeSlot;
        }
        return null;
    }

    public TAType getSelectedType() {
        RadioButton allRadio = (RadioButton)app.getGUIModule().getGUINode(CSG_ALL_RADIO_BUTTON);
        if (allRadio.isSelected())
            return TAType.All;
        RadioButton gradRadio = (RadioButton)app.getGUIModule().getGUINode(CSG_GRAD_RADIO_BUTTON);
        if (gradRadio.isSelected())
            return TAType.Graduate;
        else
            return TAType.Undergraduate;
    }

    public TeachingAssistantPrototype getSelectedTA() {
        AppGUIModule gui = app.getGUIModule();
        TableView<TeachingAssistantPrototype> tasTable = (TableView)gui.getGUINode(CSG_TAS_TABLE_VIEW);
        return tasTable.getSelectionModel().getSelectedItem();
    }
    
    public HashMap<TimeSlot, ArrayList<DayOfWeek>> getTATimeSlots(TeachingAssistantPrototype ta) {
        HashMap<TimeSlot, ArrayList<DayOfWeek>> timeSlots = new HashMap();
        for (TimeSlot timeSlot : officeHours) {
            if (timeSlot.hasTA(ta)) {
                ArrayList<DayOfWeek> daysForTA = timeSlot.getDaysForTA(ta);
                timeSlots.put(timeSlot, daysForTA);
            }
        }
        return timeSlots;
    }
    
    private boolean hasTA(TeachingAssistantPrototype testTA) {
        return allTAs.get(TAType.Graduate).contains(testTA)
                ||
                allTAs.get(TAType.Undergraduate).contains(testTA);
    }
    
    public boolean isTASelected() {
        AppGUIModule gui = app.getGUIModule();
        TableView tasTable = (TableView)gui.getGUINode(CSG_TAS_TABLE_VIEW);
        return tasTable.getSelectionModel().getSelectedItem() != null;
    }

    public boolean isLegalNewTA(String name, String email) {
        if ((name.trim().length() > 0)
                && (email.trim().length() > 0)) {
            // MAKE SURE NO TA ALREADY HAS THE SAME NAME
            TAType type = this.getSelectedType();
            TeachingAssistantPrototype testTA = new TeachingAssistantPrototype(name, email, type);
            if (this.teachingAssistants.contains(testTA))
                return false;
            if (this.isLegalNewEmail(email)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isLegalNewName(String testName) {
        if (testName.trim().length() > 0) {
            for (TeachingAssistantPrototype testTA : this.teachingAssistants) {
                if (testTA.getName().equals(testName))
                    return false;
            }
            return true;
        }
        return false;
    }
    
    public boolean isLegalNewEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        if (matcher.find()) {
            for (TeachingAssistantPrototype ta : this.teachingAssistants) {
                if (ta.getEmail().equals(email.trim()))
                    return false;
            }
            return true;
        }
        else return false;
    }
    
    public boolean isDayOfWeekColumn(int columnNumber) {
        return columnNumber >= 2;
    }
    
    public boolean isTATypeSelected() {
        AppGUIModule gui = app.getGUIModule();
        RadioButton allRadioButton = (RadioButton)gui.getGUINode(CSG_ALL_RADIO_BUTTON);
        return !allRadioButton.isSelected();
    }
    
    public boolean isValidTAEdit(TeachingAssistantPrototype taToEdit, String name, String email) {
        if (!taToEdit.getName().equals(name)) {
            if (!this.isLegalNewName(name))
                return false;
        }
        if (!taToEdit.getEmail().equals(email)) {
            if (!this.isLegalNewEmail(email))
                return false;
        }
        return true;
    }

    public boolean isValidNameEdit(TeachingAssistantPrototype taToEdit, String name) {
        if (!taToEdit.getName().equals(name)) {
            if (!this.isLegalNewName(name))
                return false;
        }
        return true;
    }

    public boolean isValidEmailEdit(TeachingAssistantPrototype taToEdit, String email) {
        if (!taToEdit.getEmail().equals(email)) {
            if (!this.isLegalNewEmail(email))
                return false;
        }
        return true;
    }    

    public void updateTAs() {
        TAType type = getSelectedType();
        selectTAs(type);
    }
    
    public void changeTimeRange(LocalTime startTime, LocalTime endTime){
        officeHours.clear();
        Iterator<TimeSlot> timeSlotIt = this.officeHoursIterator();
        while (timeSlotIt.hasNext()) {
            TimeSlot timeslot = timeSlotIt.next();
            if (timeslot.getLocalTime().isAfter(startTime)&&timeslot.getLocalTime().isBefore(endTime)) {
                officeHours.add(timeslot);
            }
        }

    }
    
    public void selectTAs(TAType type) {
        teachingAssistants.clear();
        Iterator<TeachingAssistantPrototype> tasIt = this.teachingAssistantsIterator();
        while (tasIt.hasNext()) {
            TeachingAssistantPrototype ta = tasIt.next();
            if (type.equals(TAType.All)) {
                teachingAssistants.add(ta);
            }
            else if (ta.getType().equals(type.toString())) {
                teachingAssistants.add(ta);
            }
        }
        
        // SORT THEM BY NAME
        sortTAs();

        // CLEAR ALL THE OFFICE HOURS
        Iterator<TimeSlot> officeHoursIt = officeHours.iterator();
        while (officeHoursIt.hasNext()) {
            TimeSlot timeSlot = officeHoursIt.next();
            timeSlot.filter(type);
        }
        
        app.getFoolproofModule().updateAll();
    }
    
    public Iterator<TimeSlot> officeHoursIterator() {
        return officeHours.iterator();
    }

    public Iterator<TeachingAssistantPrototype> teachingAssistantsIterator() {
        return new AllTAsIterator();
    }
    public Iterator<ScheduleItem> scheduleIterator() {
        return scheduleList.iterator();
    }
    public Iterator<Lecture> lectureIterator() {
        return lectures.iterator();
    }
    public Iterator<Recitation> recitationIterator() {
        return recitations.iterator();
    }
    public Iterator<Lab> labIterator() {
        return labs.iterator();
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }
    
    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
    }
    
    public void addRecitation(Recitation recitation) {
        recitations.add(recitation);
    }

    public void removeRecitation(Recitation recitation) {
        recitations.remove(recitation);
    }
    
    public void addLab(Lab lab) {
        labs.add(lab);
    }

    public void removeLab(Lab lab) {
        labs.remove(lab);
    }
    
    private class AllTAsIterator implements Iterator {
        Iterator gradIt = allTAs.get(TAType.Graduate).iterator();
        Iterator undergradIt = allTAs.get(TAType.Undergraduate).iterator();

        public AllTAsIterator() {}
        
        @Override
        public boolean hasNext() {
            if (gradIt.hasNext() || undergradIt.hasNext())
                return true;
            else
                return false;                
        }

        @Override
        public Object next() {
            if (gradIt.hasNext())
                return gradIt.next();
            else if (undergradIt.hasNext())
                return undergradIt.next();
            else
                return null;
        }
    }
    public void updateExportDir(){
        AppGUIModule gui = app.getGUIModule();
        ComboBox subjectComboBox = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        ComboBox semesterComboBox = (ComboBox) gui.getGUINode(CSG_SITE_SEMESTER_COMBOBOX);
        ComboBox numberComboBox = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        ComboBox yearComboBox = (ComboBox) gui.getGUINode(CSG_SITE_YEAR_COMBOBOX);
        Label exportDir = (Label) gui.getGUINode(CSG_SITE_BANNER_EXPORTDIRTEXT);
        
        String pre = ".\\export";
        String post = "\\public_html";
        if (subjectComboBox.getValue()!=null&&numberComboBox.getValue()!=null&&semesterComboBox.getValue()!=null&&yearComboBox.getValue()!=null){
            String mid = subjectComboBox.getValue().toString()+"_"+numberComboBox.getValue()+"_"+semesterComboBox.getValue()+"_"+yearComboBox.getValue();
            exportDir.setText(pre+"\\"+mid+post);
            exportdir=exportDir.getText();
        }
        
    }
    public void refreshTables(){
        AppGUIModule gui = app.getGUIModule();
        TableView<Lecture> lectureTable = (TableView) gui.getGUINode(CSG_MEETING_LECTURE_TABLE);
        TableView<Recitation> recitationTable = (TableView) gui.getGUINode(CSG_MEETING_RECITATION_TABLE);
        TableView<Lab> labTable = (TableView) gui.getGUINode(CSG_MEETING_LAB_TABLE);
        TableView<ScheduleItem> scheduleTable = (TableView) gui.getGUINode(CSG_SCHEDULE_TABLE);
        lectureTable.refresh();
        recitationTable.refresh();
        labTable.refresh();
        scheduleTable.refresh();
    }
    
}