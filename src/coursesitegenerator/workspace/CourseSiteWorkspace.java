/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.workspace;

import coursesitegenerator.CourseSiteGenerator;
import coursesitegenerator.CourseSitePropertyType;
import static coursesitegenerator.CourseSitePropertyType.*;
import static coursesitegenerator.CourseSitePropertyType.CSG_ADD_TA_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_FOOLPROOF_SETTINGS;
import static coursesitegenerator.CourseSitePropertyType.CSG_GRAD_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_TA_EDIT_DIALOG;
import static coursesitegenerator.CourseSitePropertyType.CSG_UNDERGRAD_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_ALL_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_EMAIL_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_EMAIL_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_LABEL;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_FRIDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_GRAD_UNDERGRAD_TAS_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_LEFT_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_MONDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_NUMBER_DEFAULT;
import static coursesitegenerator.CourseSitePropertyType.CSG_NUMBER_OPTIONS;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_HEADER_LABEL;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_HEADER_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_TA_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_RIGHT_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_SEMESTER_DEFAULT;
import static coursesitegenerator.CourseSitePropertyType.CSG_SEMESTER_OPTIONS;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_EXPORTDIR;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_EXPORTDIRTEXT;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_NUMBER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_SEMESTER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_SUBJECT;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_TITLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_YEAR;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_NUMBER_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_HOME;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_HOME_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_HWS;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_HWS_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_SCHEDULE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_SCHEDULE_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_SYLLABUS;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_SYLLABUS_CHECK;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PAGES_TITLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_SEMESTER_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_SUBJECT_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_TITLE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_YEAR_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SLOTS_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_COMBOBOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_DEFAULT;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_LABEL;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_OPTIONS;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_SUBJECT_DEFAULT;
import static coursesitegenerator.CourseSitePropertyType.CSG_SUBJECT_OPTIONS;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_HEADER_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_THURSDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_TUESDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_TYPE_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_WEDNESDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_YEAR_DEFAULT;
import static coursesitegenerator.CourseSitePropertyType.CSG_YEAR_OPTIONS;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import coursesitegenerator.data.Lecture;
import coursesitegenerator.data.Recitation;
import coursesitegenerator.data.ScheduleItem;
import coursesitegenerator.workspace.controller.CourseSiteGeneratorController;
import djf.components.AppWorkspaceComponent;
import djf.modules.AppFoolproofModule;
import djf.modules.AppGUIModule;
import static djf.modules.AppGUIModule.ENABLED;
import djf.ui.AppNodesBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import coursesitegenerator.data.TeachingAssistantPrototype;
import coursesitegenerator.data.TimeSlot;
import coursesitegenerator.dialogs.TADialog;
import coursesitegenerator.workspace.foolproof.CourseSiteFoolproofDesign;
import static coursesitegenerator.workspace.style.CSGStyle.CLASS_CSG_OFFICE_HOURS_TABLE_VIEW;
import properties_manager.PropertiesManager;
import static coursesitegenerator.workspace.style.CSGStyle.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author Jia Wei Zheng
 */
public class CourseSiteWorkspace extends AppWorkspaceComponent {

    public CourseSiteWorkspace(CourseSiteGenerator app) {
        super(app);

        // LAYOUT THE APP
        initLayout();

        // INIT THE EVENT HANDLERS
        initControllers();

        // 
        initFoolproofDesign();

        // INIT DIALOGS
        initDialogs();
    }

    private void initDialogs() {
        TADialog taDialog = new TADialog((CourseSiteGenerator) app);
        app.getGUIModule().addDialog(CSG_TA_EDIT_DIALOG, taDialog);
    }

    // THIS HELPER METHOD INITIALIZES ALL THE CONTROLS IN THE WORKSPACE
    private void initLayout(){
        // FIRST LOAD THE FONT FAMILIES FOR THE COMBO BOX
        PropertiesManager props = PropertiesManager.getPropertiesManager();

        // THIS WILL BUILD ALL OF OUR JavaFX COMPONENTS FOR US
        AppNodesBuilder csjBuilder = app.getGUIModule().getNodesBuilder();

        // INIT THE HEADER ON THE LEFT
        workspace = new BorderPane();
        /*
        Tab syllabusTab = new Tab();
        syllabusTab.setText("Syllabus");
        Tab meetingTab = new Tab();
        meetingTab.setText("Meeting Times");
        Tab officeTab = new Tab();
        officeTab.setText("Office Hours");
        Tab scheduleTab = new Tab();
        scheduleTab.setText("Schedule");
*/
        /*
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(siteTab);
        tabPane.getTabs().add(syllabusTab);
        tabPane.getTabs().add(meetingTab);
        tabPane.getTabs().add(officeTab);
        tabPane.getTabs().add(scheduleTab);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
*/
        TabPane tabPane = new TabPane();
        
        Tab siteTab = csjBuilder.buildTab(CSG_SITE_TAB, tabPane, CLASS_CSG_PANE, ENABLED);
        Tab syllabusTab = csjBuilder.buildTab(CSG_SYLLABUS_TAB, tabPane, CLASS_CSG_PANE, ENABLED);
        Tab meetingTab = csjBuilder.buildTab(CSG_MEETING_TAB, tabPane, CLASS_CSG_PANE, ENABLED);
        Tab officeTab = csjBuilder.buildTab(CSG_OFFICE_TAB, tabPane, CLASS_CSG_PANE, ENABLED);
        Tab scheduleTab = csjBuilder.buildTab(CSG_SCHEDULE_TAB, tabPane, CLASS_CSG_PANE, ENABLED);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.tabMinWidthProperty().bind(tabPane.widthProperty().multiply(1.0 / 5.5));
        
        GridPane sitePane = new GridPane();
        siteTab.setContent(sitePane);
        GridPane.setHgrow(sitePane, Priority.ALWAYS);
        GridPane syllabusPane = new GridPane();
        syllabusTab.setContent(syllabusPane);
        GridPane meetingPane = new GridPane();
        meetingTab.setContent(meetingPane);
        GridPane officePane = new GridPane();
        officeTab.setContent(officePane);
        GridPane.setHgrow(officePane, Priority.ALWAYS);
        GridPane schedulePane = new GridPane();
        scheduleTab.setContent(schedulePane);
        
        //Course Site Tab
        //VBox siteVBox = csjBuilder.buildVBox(CSG_SITE_PANE, sitePane, CLASS_CSG_PANE, ENABLED);
        //siteVBox.prefWidthProperty().bind(officePane.widthProperty());
        //siteVBox.prefHeightProperty().bind(officePane.heightProperty().multiply(1.0/4.0));
        ScrollPane siteScrollPane = new ScrollPane();
        siteScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        siteScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);//changeto AS_NEEDED LATER
        sitePane.getChildren().add(siteScrollPane);
        sitePane.prefWidthProperty().bind(tabPane.widthProperty());
        
        VBox siteVBox= new VBox();
        siteScrollPane.setContent(siteVBox);
        siteScrollPane.prefWidthProperty().bind(sitePane.widthProperty());
        siteScrollPane.prefHeightProperty().bind(sitePane.heightProperty());
        siteVBox.prefWidthProperty().bind(sitePane.widthProperty());
        siteVBox.prefHeightProperty().bind(sitePane.heightProperty());
        
        //banner box
        GridPane siteBannerBox = csjBuilder.buildGridPane(CSG_SITE_BANNER_BOX, siteVBox, CLASS_CSG_BOX, ENABLED);
        siteBannerBox.prefHeightProperty().bind(officePane.heightProperty().multiply(1.0/6.0));
        siteBannerBox.prefWidthProperty().bind(officePane.widthProperty());
        //siteBannerBox.setPadding(Insets.EMPTY);
        Label bannerLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_BOX, null, CLASS_CSG_HEADER_LABEL, ENABLED);
        Label subjectLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_SUBJECT, null, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label semesterLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_SEMESTER, null, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label numberLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_NUMBER, null, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label yearLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_YEAR, null, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label titleLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_TITLE, null, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label exportdirLabel = csjBuilder.buildLabel(CSG_SITE_BANNER_EXPORTDIR, null, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label exportDirText = csjBuilder.buildLabel(CSG_SITE_BANNER_EXPORTDIRTEXT, null, CLASS_CSG_TEXT_LABEL, ENABLED);
        ComboBox subjectComboBox = csjBuilder.buildComboBox(CSG_SITE_SUBJECT_COMBOBOX, CSG_SUBJECT_OPTIONS, CSG_SUBJECT_DEFAULT, null, CLASS_CSG_COMBOBOX, ENABLED);
        subjectComboBox.setEditable(true);
        ComboBox semesterComboBox = csjBuilder.buildComboBox(CSG_SITE_SEMESTER_COMBOBOX, CSG_SEMESTER_OPTIONS, CSG_SEMESTER_DEFAULT, null, CLASS_CSG_COMBOBOX, ENABLED);
        semesterComboBox.setEditable(true);
        ComboBox numberComboBox = csjBuilder.buildComboBox(CSG_SITE_NUMBER_COMBOBOX, CSG_NUMBER_OPTIONS, CSG_NUMBER_DEFAULT, null, CLASS_CSG_COMBOBOX, ENABLED);
        numberComboBox.setEditable(true);
        ComboBox yearComboBox = csjBuilder.buildComboBox(CSG_SITE_YEAR_COMBOBOX, CSG_YEAR_OPTIONS, CSG_YEAR_DEFAULT, null, CLASS_CSG_COMBOBOX, ENABLED);
        yearComboBox.setEditable(true);
        TextField titleBox=csjBuilder.buildTextField(CSG_SITE_TITLE, null, CLASS_CSG_TEXT_FIELD, ENABLED);
        
        siteBannerBox.add(bannerLabel, 0, 0, 2, 2);
        siteBannerBox.add(subjectLabel, 0, 2, 1, 1);
        siteBannerBox.add(subjectComboBox, 1, 2, 1, 1);
        siteBannerBox.add(semesterLabel, 0, 4, 1, 1);
        siteBannerBox.add(semesterComboBox, 1, 4, 1, 1);
        siteBannerBox.add(numberLabel, 2, 2, 1, 1);
        siteBannerBox.add(numberComboBox, 3, 2, 1, 1);
        siteBannerBox.add(yearLabel, 2, 4, 1, 1);
        siteBannerBox.add(yearComboBox, 3, 4, 1, 1);
        siteBannerBox.add(titleLabel, 0, 6, 1, 1);
        siteBannerBox.add(titleBox, 1, 6,3,1);
        siteBannerBox.prefWidthProperty().bind(siteBannerBox.widthProperty());
        siteBannerBox.add(exportdirLabel, 0, 8, 1, 1);
        siteBannerBox.add(exportDirText,1,8);
        
        //pages box
        GridPane sitePagesBox = csjBuilder.buildGridPane(CSG_SITE_BANNER_BOX, siteVBox, CLASS_CSG_BOX, ENABLED);
        sitePagesBox.prefHeightProperty().bind(officePane.heightProperty().multiply(1.0 / 12.0));
        Label pagesLabel = csjBuilder.buildLabel(CSG_SITE_PAGES_TITLE, sitePagesBox,0,0,1,1, CLASS_CSG_HEADER_LABEL, ENABLED);
        Label pagesHomeLabel = csjBuilder.buildLabel(CSG_SITE_PAGES_HOME, sitePagesBox, 2, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label pagesSyllabusLabel = csjBuilder.buildLabel(CSG_SITE_PAGES_SYLLABUS, sitePagesBox, 4, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label pagesScheduleLabel = csjBuilder.buildLabel(CSG_SITE_PAGES_SCHEDULE, sitePagesBox, 6, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label pagesHWSLabel = csjBuilder.buildLabel(CSG_SITE_PAGES_HWS, sitePagesBox, 8, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        CheckBox homeCheckBox=csjBuilder.buildCheckBox(CSG_SITE_PAGES_HOME_CHECK, sitePagesBox, 1, 0, 1, 1, CLASS_CSG_CHECKBOX, ENABLED);
        CheckBox syllabusCheckBox = csjBuilder.buildCheckBox(CSG_SITE_PAGES_SYLLABUS_CHECK, sitePagesBox, 3, 0, 1, 1, CLASS_CSG_CHECKBOX, ENABLED);
        CheckBox scheduleCheckBox = csjBuilder.buildCheckBox(CSG_SITE_PAGES_SCHEDULE_CHECK, sitePagesBox, 5, 0, 1, 1, CLASS_CSG_CHECKBOX, ENABLED);
        CheckBox hwsCheckBox = csjBuilder.buildCheckBox(CSG_SITE_PAGES_HWS_CHECK, sitePagesBox, 7, 0, 1, 1, CLASS_CSG_CHECKBOX, ENABLED);
        
        //style
        GridPane siteStyleBox = csjBuilder.buildGridPane(CSG_SITE_STYLE_BOX, siteVBox, CLASS_CSG_BOX, ENABLED);
        siteStyleBox.prefHeightProperty().bind(officePane.heightProperty().multiply(1.0 / 4.0));
        Label styleLabel = csjBuilder.buildLabel(CSG_SITE_STYLE_TITLE, siteStyleBox, 0, 0, 1, 1, CLASS_CSG_HEADER_LABEL, ENABLED);
        Button faviconButton = csjBuilder.buildTextButton(CSG_SITE_STYLE_FAVICON, siteStyleBox, 0, 1, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button navbarButton = csjBuilder.buildTextButton(CSG_SITE_STYLE_NAVBAR, siteStyleBox, 0, 2, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button leftFooterButton = csjBuilder.buildTextButton(CSG_SITE_STYLE_LEFTFOOT, siteStyleBox, 0, 3, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button rightFooterButton = csjBuilder.buildTextButton(CSG_SITE_STYLE_RIGHTFOOT, siteStyleBox, 0, 4, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        
        try {
            FileInputStream input = new FileInputStream("./images/favicon.png");
            Image image = new Image(input);
            //ImageView faviconImage = new ImageView(image);
            //siteStyleBox.add(faviconImage, 1, 1, 1, 1 );
            ImageView faviconImage = csjBuilder.buildImageView(CSG_STYLE_FAVICON, siteStyleBox, 1, 1, 1, 1, CLASS_CSG_IMAGEVIEW, ENABLED, image);
            faviconImage.fitHeightProperty().bind(siteScrollPane.prefHeightProperty().multiply(1.0/20.0));
            
            FileInputStream input2 = new FileInputStream("./images/navbar.png");
            Image image2 = new Image(input2);
            //ImageView navbarImage = new ImageView(image2);
            //siteStyleBox.add(navbarImage, 1, 2, 1, 1 );
            ImageView navbarImage = csjBuilder.buildImageView(CSG_STYLE_NAVBAR, siteStyleBox, 1, 2, 1, 1, CLASS_CSG_IMAGEVIEW, ENABLED, image2);
            navbarImage.fitHeightProperty().bind(siteScrollPane.prefHeightProperty().multiply(1.0 / 20.0));

            
            FileInputStream input3 = new FileInputStream("./images/leftFooter.png");
            Image image3 = new Image(input3);
            //ImageView leftFooterImage = new ImageView(image3);
            //siteStyleBox.add(leftFooterImage, 1, 3, 1, 1 );
            ImageView leftFooterImage = csjBuilder.buildImageView(CSG_STYLE_LEFTFOOTER, siteStyleBox, 1, 3, 1, 1, CLASS_CSG_IMAGEVIEW, ENABLED, image3);
            leftFooterImage.fitHeightProperty().bind(siteScrollPane.prefHeightProperty().multiply(1.0 / 20.0));

            
            FileInputStream input4 = new FileInputStream("./images/rightFooter.png");
            Image image4 = new Image(input4);
            //ImageView rightFooterImage = new ImageView(image4);
            //siteStyleBox.add(rightFooterImage, 1, 4, 1, 1 );
            ImageView rightFooterImage = csjBuilder.buildImageView(CSG_STYLE_RIGHTFOOTER, siteStyleBox, 1, 4, 1, 1, CLASS_CSG_IMAGEVIEW, ENABLED, image4);
            rightFooterImage.fitHeightProperty().bind(siteScrollPane.prefHeightProperty().multiply(1.0 / 20.0));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CourseSiteWorkspace.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Label fontsColorsText = csjBuilder.buildLabel(CSG_SITE_STYLE_FONTSCOLORS, siteStyleBox, 0, 5, 1, 1, CLASS_CSG_TEXT_LABEL, ENABLED);
        ComboBox cssComboBox = csjBuilder.buildComboBox(CSG_SITE_STYLE_CSS, CSG_SITE_STYLE_CSS_OPTIONS, CSG_SITE_STYLE_CSS_DEFAULT, null, CLASS_CSG_COMBOBOX, ENABLED);
        cssComboBox.setEditable(true);
        siteStyleBox.add(cssComboBox, 1, 5, 1, 1);
        Label noteText = csjBuilder.buildLabel(CSG_SITE_STYLE_NOTE, siteStyleBox, 0, 6, 2, 1, CLASS_CSG_TEXT_LABEL, ENABLED);

        //instructor
        GridPane siteInstructorBox = csjBuilder.buildGridPane(CSG_SITE_INSTRUCTOR_BOX, siteVBox, CLASS_CSG_BOX, ENABLED);
        //siteInstructorBox.prefHeightProperty().bind(officePane.heightProperty().multiply(1.0 / 4.0));
        siteInstructorBox.prefWidthProperty().bind(sitePane.widthProperty());
        Label instructorLabel = csjBuilder.buildLabel(CSG_SITE_INSTRUCTOR_TITLE, siteInstructorBox, 0, 0, 1, 1, CLASS_CSG_HEADER_LABEL, ENABLED);
        Label instructorNameLabel = csjBuilder.buildLabel(CSG_SITE_INSTRUCTOR_NAME, siteInstructorBox, 0, 1, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label instructorRoomLabel = csjBuilder.buildLabel(CSG_SITE_INSTRUCTOR_ROOM, siteInstructorBox, 2, 1, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label instructorEmailLabel = csjBuilder.buildLabel(CSG_SITE_INSTRUCTOR_EMAIL, siteInstructorBox, 0, 2, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label instructorHomePageLabel = csjBuilder.buildLabel(CSG_SITE_INSTRUCTOR_HOMEPAGE, siteInstructorBox, 2, 2, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TextField nameField = csjBuilder.buildTextField(CSG_SITE_INSTRUCTOR_NAME_FIELD, siteInstructorBox, 1, 1, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
        TextField emailField = csjBuilder.buildTextField(CSG_SITE_INSTRUCTOR_ROOM_FIELD, siteInstructorBox, 1, 2, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
        TextField roomField = csjBuilder.buildTextField(CSG_SITE_INSTRUCTOR_EMAIL_FIELD, siteInstructorBox, 3, 1, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
        TextField homePageField = csjBuilder.buildTextField(CSG_SITE_INSTRUCTOR_HOMEPAGE_FIELD, siteInstructorBox, 3, 2, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
       
        Button instructorOfficeHoursButton = csjBuilder.buildTextButton(CSG_SITE_INSTRUCTOR_OFFICEHOURS_BUTTON, siteInstructorBox, 0, 4, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Label instructorOfficeHoursLabel = csjBuilder.buildLabel(CSG_SITE_INSTRUCTOR_OFFICEHOURS, siteInstructorBox, 1, 4, 1, 1, CLASS_CSG_HEADER_LABEL, ENABLED);
        TextArea officeHoursTextArea = csjBuilder.buildTextArea(CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD, siteInstructorBox, 0, 5, 5, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        officeHoursTextArea.prefWidthProperty().bind(officePane.widthProperty());
        officeHoursTextArea.prefHeightProperty().bind(officePane.heightProperty().multiply(1.0/8.0));
        officeHoursTextArea.setVisible(false);
        officeHoursTextArea.managedProperty().bind(officeHoursTextArea.visibleProperty());
                
        //syllabus Tab
        ScrollPane syllabusScrollPane = new ScrollPane();
        syllabusScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        syllabusScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);//changeto AS_NEEDED LATER
        syllabusPane.getChildren().add(syllabusScrollPane);

        VBox syllabusVBox = new VBox();
        GridPane syllabusGrid = csjBuilder.buildGridPane(CSG_SITE_BANNER_BOX, syllabusVBox, CLASS_CSG_BOX, ENABLED);
        syllabusScrollPane.setContent(syllabusVBox);
        syllabusScrollPane.prefWidthProperty().bind(syllabusPane.widthProperty());
        syllabusScrollPane.prefHeightProperty().bind(syllabusPane.heightProperty());
        syllabusVBox.prefWidthProperty().bind(syllabusPane.widthProperty());
        syllabusVBox.prefHeightProperty().bind(syllabusPane.heightProperty());
        Button descriptionButton = csjBuilder.buildTextButton(CSG_SYLLABUS_DESCRIPTION_BUTTON, syllabusGrid, 0, 0, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button topicsButton = csjBuilder.buildTextButton(CSG_SYLLABUS_TOPICS_BUTTON, syllabusGrid, 0, 2, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button prereqButton = csjBuilder.buildTextButton(CSG_SYLLABUS_PREREQ_BUTTON, syllabusGrid, 0, 4, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button outcomesButton = csjBuilder.buildTextButton(CSG_SYLLABUS_OUTCOMES_BUTTON, syllabusGrid, 0, 6, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button textbooksButton = csjBuilder.buildTextButton(CSG_SYLLABUS_TEXTBOOKS_BUTTON, syllabusGrid, 0, 8, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button gradedcompButton = csjBuilder.buildTextButton(CSG_SYLLABUS_GRADEDCOMP_BUTTON, syllabusGrid, 0, 10, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button gradingNoteButton = csjBuilder.buildTextButton(CSG_SYLLABUS_GRADINGNOTE_BUTTON, syllabusGrid, 0, 12, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button acedemicButton = csjBuilder.buildTextButton(CSG_SYLLABUS_ACDEDEMIC_BUTTON, syllabusGrid, 0, 14, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button specialButton = csjBuilder.buildTextButton(CSG_SYLLABUS_SPECIAL_BUTTON, syllabusGrid, 0, 16, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        TextArea descriptionTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_DESCRIPTION_BOX, syllabusGrid, 0, 1, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        descriptionTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //descriptionTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        //descriptionTextField.setPrefHeight(syllabusVBox.getHeight()/2.0);
        descriptionTextField.setVisible(true);
        descriptionTextField.managedProperty().bind(descriptionTextField.visibleProperty());
        TextArea topicsTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_TOPICS_BOX, syllabusGrid, 0, 3, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        topicsTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //topicsTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        topicsTextField.setVisible(false);
        topicsTextField.managedProperty().bind(topicsTextField.visibleProperty());
        TextArea prereqTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_PREREQ_BOX, syllabusGrid, 0, 5, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        prereqTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //prereqTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        prereqTextField.setVisible(false);
        prereqTextField.managedProperty().bind(prereqTextField.visibleProperty());
        TextArea outcomesTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_OUTCOMES_BOX, syllabusGrid, 0, 7, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        outcomesTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //outcomesTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        outcomesTextField.setVisible(false);
        outcomesTextField.managedProperty().bind(outcomesTextField.visibleProperty());
        TextArea textbooksTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_TEXTBOOKS_BOX, syllabusGrid, 0, 9, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        textbooksTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //textbooksTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        textbooksTextField.setVisible(false);
        textbooksTextField.managedProperty().bind(textbooksTextField.visibleProperty());
        TextArea gradingcompTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_GRADEDCOMPONENTS_BOX, syllabusGrid, 0, 11, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        gradingcompTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //gradingcompTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        gradingcompTextField.setVisible(false);
        gradingcompTextField.managedProperty().bind(gradingcompTextField.visibleProperty());
        TextArea gradingNoteTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_GRADINGNOTE_BOX, syllabusGrid, 0, 13, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        gradingNoteTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //gradingNoteTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        gradingNoteTextField.setVisible(false);
        gradingNoteTextField.managedProperty().bind(gradingNoteTextField.visibleProperty());
        TextArea acedemicTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX, syllabusGrid, 0, 15, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        acedemicTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //acedemicTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        acedemicTextField.setVisible(false);
        acedemicTextField.managedProperty().bind(acedemicTextField.visibleProperty());
        TextArea specialTextField = csjBuilder.buildTextArea(CSG_SYLLABUS_SPECIALASSISTANCE_BOX, syllabusGrid, 0, 17, 2, 1, CLASS_CSG_BIG_TEXT_FIELD, ENABLED);
        specialTextField.prefWidthProperty().bind(syllabusGrid.widthProperty());
        //specialTextField.prefHeightProperty().bind(syllabusVBox.heightProperty().multiply(1.0 / 4.0));
        specialTextField.setVisible(false);
        specialTextField.managedProperty().bind(specialTextField.visibleProperty());
        
        Label descriptionLabel = csjBuilder.buildLabel(CSG_SYLLABUS_DESCRIPTION, syllabusGrid, 1, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label topicsLabel = csjBuilder.buildLabel(CSG_SYLLABUS_TOPICS, syllabusGrid, 1, 2, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label prereqLabel = csjBuilder.buildLabel(CSG_SYLLABUS_PREREQ, syllabusGrid, 1, 4, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label outcomesLabel = csjBuilder.buildLabel(CSG_SYLLABUS_OUTCOMES, syllabusGrid, 1, 6, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label textbooksLabel = csjBuilder.buildLabel(CSG_SYLLABUS_TEXTBOOKS, syllabusGrid, 1, 8, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label gradedcompLabel = csjBuilder.buildLabel(CSG_SYLLABUS_GRADEDCOMP, syllabusGrid, 1, 10, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label gradingNoteLabel = csjBuilder.buildLabel(CSG_SYLLABUS_GRADINGNOTE, syllabusGrid, 1, 12, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label acedemicLabel = csjBuilder.buildLabel(CSG_SYLLABUS_ACAMEDIC, syllabusGrid, 1, 14, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label specialLabel = csjBuilder.buildLabel(CSG_SYLLABUS_SPECIAL, syllabusGrid, 1, 16, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        
        
        //Meeting Tab
        ScrollPane meetingScrollPane = new ScrollPane();
        meetingScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        meetingScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);//changeto AS_NEEDED LATER
        meetingPane.getChildren().add(meetingScrollPane);

        VBox meetingVBox = new VBox();
        GridPane meetingGrid = csjBuilder.buildGridPane(CSG_SITE_BANNER_BOX, meetingVBox, CLASS_CSG_BOX, ENABLED);
        meetingScrollPane.setContent(meetingVBox);
        meetingScrollPane.prefWidthProperty().bind(meetingPane.widthProperty());
        meetingScrollPane.prefHeightProperty().bind(meetingPane.heightProperty());
        meetingVBox.prefWidthProperty().bind(meetingPane.widthProperty());
        meetingVBox.prefHeightProperty().bind(meetingPane.heightProperty());
        //lecture table
        Button lectureAddButton = csjBuilder.buildTextButton(CSG_MEETING_LECTURE_ADD_BUTTON, meetingGrid, 0, 0, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button lectureRemoveButton = csjBuilder.buildTextButton(CSG_MEETING_LECTURE_REMOVE_BUTTON, meetingGrid, 1, 0, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Label lectureLabel = csjBuilder.buildLabel(CSG_MEETING_LECTURE_TITLE, meetingGrid, 2, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TableView<Lecture> lectureTable = csjBuilder.buildTableView(CSG_MEETING_LECTURE_TABLE, meetingGrid, 0, 1, 3, 1,CLASS_CSG_TABLE_VIEW, ENABLED);
        lectureTable.prefWidthProperty().bind(meetingPane.widthProperty());
        lectureTable.getSelectionModel().cellSelectionEnabledProperty().set(true);
        lectureTable.setEditable(true);
        TableColumn lectureSectionColumn = csjBuilder.buildTableColumn(CSG_MEETING_LECTURE_SECTION, lectureTable, CLASS_CSG_COLUMN);
        TableColumn lectureDaysColumn = csjBuilder.buildTableColumn(CSG_MEETING_LECTURE_DAYS, lectureTable, CLASS_CSG_COLUMN);
        TableColumn lectureTimeColumn = csjBuilder.buildTableColumn(CSG_MEETING_LECTURE_TIME, lectureTable, CLASS_CSG_CENTERED_COLUMN);
        TableColumn lectureRoomColumn = csjBuilder.buildTableColumn(CSG_MEETING_LECTURE_ROOM, lectureTable, CLASS_CSG_COLUMN);
        lectureSectionColumn.setCellValueFactory(new PropertyValueFactory<String, String>("section"));
        lectureDaysColumn.setCellValueFactory(new PropertyValueFactory<String, String>("days"));
        lectureTimeColumn.setCellValueFactory(new PropertyValueFactory<String, String>("time"));
        lectureRoomColumn.setCellValueFactory(new PropertyValueFactory<String, String>("room"));
        lectureSectionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lectureDaysColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lectureTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lectureRoomColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lectureSectionColumn.prefWidthProperty().bind(lectureTable.widthProperty().multiply(1.0 / 5.0));
        lectureDaysColumn.prefWidthProperty().bind(lectureTable.widthProperty().multiply(1.0 / 5.0));
        lectureTimeColumn.prefWidthProperty().bind(lectureTable.widthProperty().multiply(2.0 / 5.0));
        lectureRoomColumn.prefWidthProperty().bind(lectureTable.widthProperty().multiply(1.0 / 5.0));
        //recitation table
        Button recitationAddButton = csjBuilder.buildTextButton(CSG_MEETING_RECITATION_ADD_BUTTON, meetingGrid, 0, 2, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button recitationRemoveButton = csjBuilder.buildTextButton(CSG_MEETING_RECITATION_REMOVE_BUTTON, meetingGrid, 1, 2, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Label recitationLabel = csjBuilder.buildLabel(CSG_MEETING_RECITATION_TITLE, meetingGrid, 2, 2, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TableView<Recitation> recitationTable = csjBuilder.buildTableView(CSG_MEETING_RECITATION_TABLE, meetingGrid, 0, 3, 3, 1, CLASS_CSG_TABLE_VIEW, ENABLED);
        recitationTable.prefWidthProperty().bind(meetingPane.widthProperty());
        recitationTable.getSelectionModel().cellSelectionEnabledProperty().set(true);
        recitationTable.setEditable(true);
        TableColumn recitationSectionColumn = csjBuilder.buildTableColumn(CSG_MEETING_RECITATION_SECTION, recitationTable, CLASS_CSG_COLUMN);
        TableColumn recitationDayTimeColumn = csjBuilder.buildTableColumn(CSG_MEETING_RECITATION_DAYTIME, recitationTable, CLASS_CSG_COLUMN);
        TableColumn recitationRoomColumn = csjBuilder.buildTableColumn(CSG_MEETING_RECITATION_ROOM, recitationTable, CLASS_CSG_CENTERED_COLUMN);
        TableColumn recitationTA1Column = csjBuilder.buildTableColumn(CSG_MEETING_RECITATION_TA1, recitationTable, CLASS_CSG_COLUMN);
        TableColumn recitationTA2Column = csjBuilder.buildTableColumn(CSG_MEETING_RECITATION_TA2, recitationTable, CLASS_CSG_COLUMN);
        recitationSectionColumn.setCellValueFactory(new PropertyValueFactory<String, String>("section"));
        recitationDayTimeColumn.setCellValueFactory(new PropertyValueFactory<String, String>("daytime"));
        recitationRoomColumn.setCellValueFactory(new PropertyValueFactory<String, String>("room"));
        recitationTA1Column.setCellValueFactory(new PropertyValueFactory<String, String>("taone"));
        recitationTA2Column.setCellValueFactory(new PropertyValueFactory<String, String>("tatwo"));
        recitationSectionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        recitationDayTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        recitationRoomColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        recitationTA1Column.setCellFactory(TextFieldTableCell.forTableColumn());
        recitationTA2Column.setCellFactory(TextFieldTableCell.forTableColumn());
        recitationSectionColumn.prefWidthProperty().bind(recitationTable.widthProperty().multiply(1.0 / 5.0));
        recitationDayTimeColumn.prefWidthProperty().bind(recitationTable.widthProperty().multiply(1.0 / 5.0));
        recitationRoomColumn.prefWidthProperty().bind(recitationTable.widthProperty().multiply(1.0 / 5.0));
        recitationTA1Column.prefWidthProperty().bind(recitationTable.widthProperty().multiply(1.0 / 5.0));
        recitationTA2Column.prefWidthProperty().bind(recitationTable.widthProperty().multiply(1.0 / 5.0));
        //lab table
        Button labAddButton = csjBuilder.buildTextButton(CSG_MEETING_LAB_ADD_BUTTON, meetingGrid, 0, 4, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button labRemoveButton = csjBuilder.buildTextButton(CSG_MEETING_LAB_REMOVE_BUTTON, meetingGrid, 1, 4, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Label labLabel = csjBuilder.buildLabel(CSG_MEETING_LAB_TITLE, meetingGrid, 2, 4, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TableView<Lab> labTable = csjBuilder.buildTableView(CSG_MEETING_LAB_TABLE, meetingGrid, 0, 5, 3, 1, CLASS_CSG_TABLE_VIEW, ENABLED);
        labTable.prefWidthProperty().bind(meetingPane.widthProperty());
        labTable.getSelectionModel().cellSelectionEnabledProperty().set(true);
        labTable.setEditable(true);
        TableColumn labSectionColumn = csjBuilder.buildTableColumn(CSG_MEETING_LAB_SECTION, labTable, CLASS_CSG_COLUMN);
        TableColumn labDayTimeColumn = csjBuilder.buildTableColumn(CSG_MEETING_LAB_DAYTIME, labTable, CLASS_CSG_COLUMN);
        TableColumn labRoomColumn = csjBuilder.buildTableColumn(CSG_MEETING_LAB_ROOM, labTable, CLASS_CSG_CENTERED_COLUMN);
        TableColumn labTA1Column = csjBuilder.buildTableColumn(CSG_MEETING_LAB_TA1, labTable, CLASS_CSG_COLUMN);
        TableColumn labTA2Column = csjBuilder.buildTableColumn(CSG_MEETING_LAB_TA2, labTable, CLASS_CSG_COLUMN);
        labSectionColumn.setCellValueFactory(new PropertyValueFactory<String, String>("section"));
        labDayTimeColumn.setCellValueFactory(new PropertyValueFactory<String, String>("daytime"));
        labRoomColumn.setCellValueFactory(new PropertyValueFactory<String, String>("room"));
        labTA1Column.setCellValueFactory(new PropertyValueFactory<String, String>("taone"));
        labTA2Column.setCellValueFactory(new PropertyValueFactory<String, String>("tatwo"));
        labSectionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        labDayTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        labRoomColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        labTA1Column.setCellFactory(TextFieldTableCell.forTableColumn());
        labTA2Column.setCellFactory(TextFieldTableCell.forTableColumn());
        labSectionColumn.prefWidthProperty().bind(labTable.widthProperty().multiply(1.0 / 5.0));
        labDayTimeColumn.prefWidthProperty().bind(labTable.widthProperty().multiply(1.0 / 5.0));
        labRoomColumn.prefWidthProperty().bind(labTable.widthProperty().multiply(1.0 / 5.0));
        labTA1Column.prefWidthProperty().bind(labTable.widthProperty().multiply(1.0 / 5.0));
        labTA2Column.prefWidthProperty().bind(labTable.widthProperty().multiply(1.0 / 5.0));
        
        
        //Office Tab Tab
        VBox officeVBox = csjBuilder.buildVBox(CSG_OFFICE_PANE, officePane, CLASS_CSG_PANE, ENABLED);
        
        HBox tasHeaderBox = csjBuilder.buildHBox(CSG_OFFICE_TA_PANE, officeVBox, CLASS_CSG_BOX, ENABLED);
        csjBuilder.buildTextButton(CSG_OFFICE_REMOVE_BUTTON, tasHeaderBox, CLASS_CSG_BUTTON, ENABLED);
        csjBuilder.buildLabel(CourseSitePropertyType.CSG_TAS_HEADER_LABEL, tasHeaderBox, CLASS_CSG_HEADER_LABEL, ENABLED);
                
        officePane.setAlignment(Pos.CENTER);
        officeVBox.prefWidthProperty().bind(officePane.widthProperty());
        
        ToggleGroup tg = new ToggleGroup();
        csjBuilder.buildRadioButton(CSG_ALL_RADIO_BUTTON, tasHeaderBox, CLASS_CSG_RADIO_BUTTON, ENABLED, tg, true);
        csjBuilder.buildRadioButton(CSG_GRAD_RADIO_BUTTON, tasHeaderBox, CLASS_CSG_RADIO_BUTTON, ENABLED, tg, false);
        csjBuilder.buildRadioButton(CSG_UNDERGRAD_RADIO_BUTTON, tasHeaderBox, CLASS_CSG_RADIO_BUTTON, ENABLED, tg, false);

        TableView<TeachingAssistantPrototype> taTable = csjBuilder.buildTableView(CSG_TAS_TABLE_VIEW, officeVBox, CLASS_CSG_TABLE_VIEW, ENABLED);
        taTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        TableColumn nameColumn = csjBuilder.buildTableColumn(CSG_NAME_TABLE_COLUMN, taTable, CLASS_CSG_COLUMN);
        TableColumn emailColumn = csjBuilder.buildTableColumn(CSG_EMAIL_TABLE_COLUMN, taTable, CLASS_CSG_COLUMN);
        TableColumn slotsColumn = csjBuilder.buildTableColumn(CSG_SLOTS_TABLE_COLUMN, taTable, CLASS_CSG_CENTERED_COLUMN);
        TableColumn typeColumn = csjBuilder.buildTableColumn(CSG_TYPE_TABLE_COLUMN, taTable, CLASS_CSG_COLUMN);
        nameColumn.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<String, String>("email"));
        slotsColumn.setCellValueFactory(new PropertyValueFactory<String, String>("slots"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<String, String>("type"));
        
        nameColumn.prefWidthProperty().bind(taTable.widthProperty().multiply(1.0 / 5.0));
        emailColumn.prefWidthProperty().bind(taTable.widthProperty().multiply(2.0 / 5.0));
        slotsColumn.prefWidthProperty().bind(taTable.widthProperty().multiply(1.0 / 5.0));
        typeColumn.prefWidthProperty().bind(taTable.widthProperty().multiply(1.0 / 5.0));

        HBox taBox = csjBuilder.buildHBox(CSG_ADD_TA_PANE, officePane, CLASS_CSG_PANE, ENABLED);
        csjBuilder.buildTextField(CSG_NAME_TEXT_FIELD, taBox, CLASS_CSG_TEXT_FIELD, ENABLED);
        csjBuilder.buildTextField(CSG_EMAIL_TEXT_FIELD, taBox, CLASS_CSG_TEXT_FIELD, ENABLED);
        csjBuilder.buildTextButton(CSG_ADD_TA_BUTTON, taBox, CLASS_CSG_BUTTON, !ENABLED);

        officeVBox.getChildren().add(taBox);
        VBox.setVgrow(taTable, Priority.ALWAYS);

        HBox officeHoursHeaderBox = csjBuilder.buildHBox(CSG_OFFICE_HOURS_HEADER_PANE, officeVBox, CLASS_CSG_PANE, ENABLED);
        Label officeHoursLabel=csjBuilder.buildLabel(CSG_OFFICE_HOURS_HEADER_LABEL, officeHoursHeaderBox, CLASS_CSG_HEADER_LABEL, ENABLED);
        csjBuilder.buildLabel(CSG_START_TIME_LABEL, officeHoursHeaderBox, CLASS_CSG_HEADER_LABEL, ENABLED);
        ComboBox startTime = csjBuilder.buildComboBox(CSG_START_TIME_COMBOBOX, CSG_START_TIME_OPTIONS, CSG_START_TIME_DEFAULT, officeHoursHeaderBox, CLASS_CSG_COMBOBOX, ENABLED);
        startTime.setEditable(true);
        csjBuilder.buildLabel(CSG_END_TIME_LABEL, officeHoursHeaderBox, CLASS_CSG_HEADER_LABEL, ENABLED);
        ComboBox endTime = csjBuilder.buildComboBox(CSG_END_TIME_COMBOBOX, CSG_END_TIME_OPTIONS, CSG_END_TIME_DEFAULT, officeHoursHeaderBox, CLASS_CSG_COMBOBOX, ENABLED);
        endTime.setEditable(true);
        TableView<TimeSlot> officeHoursTable = csjBuilder.buildTableView(CSG_OFFICE_HOURS_TABLE_VIEW, officeVBox, CLASS_CSG_OFFICE_HOURS_TABLE_VIEW, ENABLED);
        officeHoursLabel.prefWidthProperty().bind(officePane.widthProperty().multiply(1.0 / 5.0));
        officeHoursHeaderBox.setAlignment(Pos.CENTER);
        
        setupOfficeHoursColumn(CSG_START_TIME_TABLE_COLUMN, officeHoursTable, CLASS_CSG_TIME_COLUMN, "startTime");
        setupOfficeHoursColumn(CSG_END_TIME_TABLE_COLUMN, officeHoursTable, CLASS_CSG_TIME_COLUMN, "endTime");
        setupOfficeHoursColumn(CSG_MONDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "monday");
        setupOfficeHoursColumn(CSG_TUESDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "tuesday");
        setupOfficeHoursColumn(CSG_WEDNESDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "wednesday");
        setupOfficeHoursColumn(CSG_THURSDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "thursday");
        setupOfficeHoursColumn(CSG_FRIDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "friday");

        officeVBox.prefHeightProperty().bind(officePane.heightProperty());
        tasHeaderBox.prefHeightProperty().bind(officeVBox.heightProperty().multiply(1.0/14.0));
        taTable.prefHeightProperty().bind(officeVBox.heightProperty().multiply(4.0/14.0));
        taBox.prefHeightProperty().bind(officeVBox.heightProperty().multiply(1.0/14.0));
        officeHoursHeaderBox.prefHeightProperty().bind(officeVBox.heightProperty().multiply(1.0/14.0));
        officeHoursTable.prefHeightProperty().bind(officeVBox.heightProperty().multiply(7.0/14.0));
        
        officeVBox.setVgrow(officeHoursTable, Priority.ALWAYS);

        //Schedule Tab
        ScrollPane scheduleScrollPane = new ScrollPane();
        scheduleScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scheduleScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);//changeto AS_NEEDED LATER
        schedulePane.getChildren().add(scheduleScrollPane);

        VBox scheduleVBox = new VBox();
        GridPane scheduleGrid = csjBuilder.buildGridPane(CSG_SITE_BANNER_BOX, scheduleVBox, CLASS_CSG_BOX, ENABLED);
        scheduleScrollPane.setContent(scheduleVBox);
        scheduleScrollPane.prefWidthProperty().bind(schedulePane.widthProperty());
        scheduleScrollPane.prefHeightProperty().bind(schedulePane.heightProperty());
        scheduleVBox.prefWidthProperty().bind(schedulePane.widthProperty());
        scheduleVBox.prefHeightProperty().bind(schedulePane.heightProperty());
        
        //calender box
        Label calenderLabel = csjBuilder.buildLabel(CSG_SCHEDULE_CALENDER_TITLE, scheduleGrid, 0, 0, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label startLabel = csjBuilder.buildLabel(CSG_SCHEDULE_STARTING_MONDAY, scheduleGrid, 0, 1, 1, 1, CLASS_CSG_TEXT_LABEL, ENABLED);
        Label endLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ENDING_FRIDAY, scheduleGrid, 2, 1, 1, 1, CLASS_CSG_TEXT_LABEL, ENABLED);
        DatePicker startDatePicker = csjBuilder.buildDatePicker(CSG_SCHEDULE_START_DATEPICKER, scheduleGrid, 1, 1, 1, 1, CLASS_CSG_DATEPICKER, ENABLED);
        DatePicker endDatePicker = csjBuilder.buildDatePicker(CSG_SCHEDULE_END_DATEPICKER, scheduleGrid, 3, 1, 1, 1, CLASS_CSG_DATEPICKER, ENABLED);
        //schedule box
        Button scheduleRemoveButton = csjBuilder.buildTextButton(CSG_SCHEDULE_REMOVE_SCHEDULE_ITEM_BUTTON, scheduleGrid, 0, 2, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Label scheduleLabel = csjBuilder.buildLabel(CSG_SCHEDULE_SCHEDULE_TITLE, scheduleGrid, 1, 2, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TableView<ScheduleItem> scheduleTable = csjBuilder.buildTableView(CSG_SCHEDULE_TABLE, scheduleGrid, 0, 3, 4, 1, CLASS_CSG_TABLE_VIEW, ENABLED);
        scheduleTable.prefWidthProperty().bind(schedulePane.widthProperty());
        scheduleTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        TableColumn scheduleSectionColumn = csjBuilder.buildTableColumn(CSG_SCHEDULE_SCHEDULE_TYPE, scheduleTable, CLASS_CSG_COLUMN);
        TableColumn scheduleDaysColumn = csjBuilder.buildTableColumn(CSG_SCHEDULE_SCHEDULE_DATE, scheduleTable, CLASS_CSG_COLUMN);
        TableColumn scheduleTimeColumn = csjBuilder.buildTableColumn(CSG_SCHEDULE_SCHEDULE_TITLECOL, scheduleTable, CLASS_CSG_CENTERED_COLUMN);
        TableColumn scheduleRoomColumn = csjBuilder.buildTableColumn(CSG_SCHEDULE_SCHEDULE_TOPIC, scheduleTable, CLASS_CSG_COLUMN);
        scheduleSectionColumn.setCellValueFactory(new PropertyValueFactory<String, String>("type"));
        scheduleDaysColumn.setCellValueFactory(new PropertyValueFactory<String, String>("date"));
        scheduleTimeColumn.setCellValueFactory(new PropertyValueFactory<String, String>("title"));
        scheduleRoomColumn.setCellValueFactory(new PropertyValueFactory<String, String>("topic"));
        scheduleSectionColumn.prefWidthProperty().bind(scheduleTable.widthProperty().multiply(1.0 / 5.0));
        scheduleDaysColumn.prefWidthProperty().bind(scheduleTable.widthProperty().multiply(1.0 / 5.0));
        scheduleTimeColumn.prefWidthProperty().bind(scheduleTable.widthProperty().multiply(1.0 / 5.0));
        scheduleRoomColumn.prefWidthProperty().bind(scheduleTable.widthProperty().multiply(2.0 / 5.0));
        //addedit box
        Label addEditLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ADDEDIT_TITLE, scheduleGrid, 0, 4, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        Label typeLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ADD_TYPE, scheduleGrid, 0, 5, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        ComboBox typeComboBox = csjBuilder.buildComboBox(CSG_SCHEDULE_TYPE_COMBOBOX, CSG_TYPE_OPTIONS, CSG_TYPE_DEFAULT, null, CLASS_CSG_COMBOBOX, ENABLED);
        scheduleGrid.add(typeComboBox, 1, 5, 1, 1);
        typeComboBox.setEditable(true);
        Label dateLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ADD_DATE, scheduleGrid, 0, 6, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        DatePicker editDatePicker = csjBuilder.buildDatePicker(CSG_SCHEDULE_EDIT_DATEPICKER, scheduleGrid, 1, 6, 1, 1, CLASS_CSG_DATEPICKER, ENABLED);
        Label scheduleTitleLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ADD_TITLE, scheduleGrid, 0, 7, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TextField titleField = csjBuilder.buildTextField(CSG_SCHEDULE_TITLE_FIELD, scheduleGrid, 1, 7, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
        Label topicLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ADD_TOPIC, scheduleGrid, 0, 8, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TextField topicField = csjBuilder.buildTextField(CSG_SCHEDULE_TOPIC_FIELD, scheduleGrid, 1, 8, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
        Label linkLabel = csjBuilder.buildLabel(CSG_SCHEDULE_ADD_LINK, scheduleGrid, 0, 9, 1, 1, CLASS_CSG_SUBHEADER_LABEL, ENABLED);
        TextField linkField = csjBuilder.buildTextField(CSG_SCHEDULE_LINK_FIELD, scheduleGrid, 1, 9, 1, 1, CLASS_CSG_TEXT_FIELD, ENABLED);
        Button addButton=csjBuilder.buildTextButton(CSG_SCHEDULE_ADD_BUTTON, scheduleGrid, 0, 10, 1, 1, CLASS_CSG_BUTTON, ENABLED);
        Button clearButton = csjBuilder.buildTextButton(CSG_SCHEDULE_ADD_CLEAR_BUTTON, scheduleGrid, 1, 10, 1, 1, CLASS_CSG_BUTTON, ENABLED);

        //load values for combo boxes
        subjectComboBox.getItems().clear();
        numberComboBox.getItems().clear();
        yearComboBox.getItems().clear();
        
        try {
            loadSubjectsAndNumbers();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        yearComboBox.getItems().add(Year.now().getValue());
        yearComboBox.getItems().add(Year.now().getValue()+1);
        yearComboBox.setValue(Year.now().getValue());

        ((BorderPane) workspace).setCenter(tabPane);


    }

    private void setupOfficeHoursColumn(Object columnId, TableView tableView, String styleClass, String columnDataProperty) {
        AppNodesBuilder builder = app.getGUIModule().getNodesBuilder();
        TableColumn<TeachingAssistantPrototype, String> column = builder.buildTableColumn(columnId, tableView, styleClass);
        column.setCellValueFactory(new PropertyValueFactory<TeachingAssistantPrototype, String>(columnDataProperty));
        column.prefWidthProperty().bind(tableView.widthProperty().multiply(1.0 / 7.0));
        column.setCellFactory(col -> {
            return new TableCell<TeachingAssistantPrototype, String>() {
                @Override
                protected void updateItem(String text, boolean empty) {
                    super.updateItem(text, empty);
                    if (text == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // CHECK TO SEE IF text CONTAINS THE NAME OF
                        // THE CURRENTLY SELECTED TA
                        setText(text);
                        TableView<TeachingAssistantPrototype> tasTableView = (TableView) app.getGUIModule().getGUINode(CSG_TAS_TABLE_VIEW);
                        TeachingAssistantPrototype selectedTA = tasTableView.getSelectionModel().getSelectedItem();
                        if (selectedTA == null) {
                            setStyle("");
                        } else if (text.contains(selectedTA.getName())) {
                            setStyle("-fx-background-color: yellow");
                        } else {
                            setStyle("");
                        }
                    }
                }
            };
        });
    }
    CourseSiteGeneratorController controller=null;
    public void initControllers() {
        
        controller = new CourseSiteGeneratorController((CourseSiteGenerator) app);
        AppGUIModule gui = app.getGUIModule();

        // FOOLPROOF DESIGN STUFF
        TextField nameTextField = ((TextField) gui.getGUINode(CSG_NAME_TEXT_FIELD));
        TextField emailTextField = ((TextField) gui.getGUINode(CSG_EMAIL_TEXT_FIELD));
        ComboBox subjectComboBox = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        ComboBox numberComboBox = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        ComboBox yearComboBox = (ComboBox) gui.getGUINode(CSG_SITE_YEAR_COMBOBOX);
        ComboBox semesterComboBox = (ComboBox) gui.getGUINode(CSG_SITE_SEMESTER_COMBOBOX);

        
        subjectComboBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!subjectComboBox.getValue().equals(data.getSubject())){
            if (subjectComboBox.getValue()!=""&&!subjectComboBox.getItems().contains(subjectComboBox.getValue()))
                try {
                    controller.addSubject((String)subjectComboBox.getValue());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            controller.changeSubject(subjectComboBox.getValue().toString());
            updateExportDir();
            }
        });
        
        numberComboBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!numberComboBox.getValue().equals(data.getNumber())){
            if (numberComboBox.getValue()!=""&&!numberComboBox.getItems().contains(numberComboBox.getValue())) 
                try {
                        controller.addNumber((String)numberComboBox.getValue());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            controller.changeNumber(numberComboBox.getValue().toString());
            updateExportDir();
            }
        });
        
        yearComboBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!yearComboBox.getValue().toString().equals(data.getYear().toString())){
                controller.changeYear(yearComboBox.getValue().toString());
                updateExportDir();
            }
        });
        
        semesterComboBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!semesterComboBox.getValue().equals(data.getSemester())){
                controller.changeSemester(semesterComboBox.getValue().toString());
                updateExportDir();
            }
        });
        
        ComboBox cssComboBox = (ComboBox) gui.getGUINode(CSG_SITE_STYLE_CSS);
        cssComboBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            try{
                    if (!cssComboBox.getValue().equals(data.getCSS())){
                controller.changeCSS(cssComboBox.getValue().toString());
            }
            }catch(NullPointerException ex){
                
            }
        });
        
        TextField titleTextField = ((TextField) gui.getGUINode(CSG_SITE_TITLE));
        //titleTextField.setOnAction(e -> {
        titleTextField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!titleTextField.getText().equals(data.getTitle())){
                controller.changeTitle(titleTextField.getText());
            }
        });
        
        TextField instructorNameField = ((TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_NAME_FIELD));
        instructorNameField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!instructorNameField.getText().equals(data.getInstructorName())){
                controller.changeInstructorName(instructorNameField.getText());
            }
        });
        
        TextField instructorLinkField = ((TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_HOMEPAGE_FIELD));
        instructorLinkField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!instructorLinkField.getText().equals(data.getInstructorHomepage())){
                controller.changeInstructorHome(instructorLinkField.getText());
            }
        });
        
        TextField instructorRoomField = ((TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_ROOM_FIELD));
        instructorRoomField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!instructorRoomField.getText().equals(data.getInstructorRoom())){
                controller.changeInstructorRoom(instructorRoomField.getText());
            }
        });
        
        TextField instructorEmailField = ((TextField) gui.getGUINode(CSG_SITE_INSTRUCTOR_EMAIL_FIELD));
        instructorEmailField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!instructorEmailField.getText().equals(data.getInstructorEmail())){
                controller.changeInstructorEmail(instructorEmailField.getText());
            }
        });

        TextArea instructorOfficeHoursField = ((TextArea) gui.getGUINode(CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD));
        instructorOfficeHoursField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!instructorOfficeHoursField.getText().equals(data.getInstructorOfficeHours())){
                controller.changeInstructorOfficeHours(instructorOfficeHoursField.getText());
            }
        });
        
        TextArea desctiptionText = (TextArea) gui.getGUINode(CSG_SYLLABUS_DESCRIPTION_BOX);
        desctiptionText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!desctiptionText.getText().equals(data.getDescription())){
                controller.changeDescription(desctiptionText.getText());
            }
        });
        TextArea topicsText = (TextArea) gui.getGUINode(CSG_SYLLABUS_TOPICS_BOX);
        topicsText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!topicsText.getText().equals(data.getTopics())){
                controller.changeTopics(topicsText.getText());
            }
        });
        TextArea prereqText = (TextArea) gui.getGUINode(CSG_SYLLABUS_PREREQ_BOX);
        prereqText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!prereqText.getText().equals(data.getPrereq())){
                controller.changePrereq(prereqText.getText());
            }
        });
        TextArea outcomesText = (TextArea) gui.getGUINode(CSG_SYLLABUS_OUTCOMES_BOX);
        outcomesText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!outcomesText.getText().equals(data.getOutcomes())){
                controller.changeOutcomes(outcomesText.getText());
            }
        });
        TextArea textbooksText = (TextArea) gui.getGUINode(CSG_SYLLABUS_TEXTBOOKS_BOX);
        textbooksText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!textbooksText.getText().equals(data.getTextbooks())){
                controller.changeTextbooks(textbooksText.getText());
            }
        });
        TextArea gradedcompText = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADEDCOMPONENTS_BOX);
        gradedcompText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!gradedcompText.getText().equals(data.getGradedcomp())){
                controller.changeGradedcomp(gradedcompText.getText());
            }
        });
        TextArea gradingNoteText = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADINGNOTE_BOX);
        gradingNoteText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!gradingNoteText.getText().equals(data.getGradingNote())){
                controller.changeGradingNote(gradingNoteText.getText());
            }
        });
        TextArea acedemicText = (TextArea) gui.getGUINode(CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX);
        acedemicText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!acedemicText.getText().equals(data.getAcedemic())){
                controller.changeAcedemic(acedemicText.getText());
            }
        });
        TextArea specialText = (TextArea) gui.getGUINode(CSG_SYLLABUS_SPECIALASSISTANCE_BOX);
        specialText.focusedProperty().addListener((obs, oldVal, newVal) -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if (!specialText.getText().equals(data.getSpecial())){
                controller.changeSpecial(specialText.getText());
            }
        });
        
        CheckBox homeCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_HOME_CHECK);
        CheckBox syllabusCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_SYLLABUS_CHECK);
        CheckBox scheduleCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_SCHEDULE_CHECK);
        CheckBox hwsCheckBox = (CheckBox) gui.getGUINode(CSG_SITE_PAGES_HWS_CHECK);

        homeCheckBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if ((homeCheckBox.isSelected()==data.getHome())==false){
                controller.changeHome(homeCheckBox.isSelected());
            }
        });
        
        syllabusCheckBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if ((syllabusCheckBox.isSelected()==data.getSyllabus())==false){
                controller.changeSyllabus(syllabusCheckBox.isSelected());
            }
        });
        scheduleCheckBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if ((scheduleCheckBox.isSelected()==data.getSchedule())==false){
                controller.changeSchedule(scheduleCheckBox.isSelected());
            }
        });
        hwsCheckBox.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if ((hwsCheckBox.isSelected()==data.getHWS())==false){
                controller.changeHWS(hwsCheckBox.isSelected());
            }
        });
        
        nameTextField.textProperty().addListener(e -> {
            controller.processTypeTA();
        });
        emailTextField.textProperty().addListener(e -> {
            controller.processTypeTA();
        });

        // FIRE THE ADD EVENT ACTION
        nameTextField.setOnAction(e -> {
            controller.processAddTA();
        });
        emailTextField.setOnAction(e -> {
            controller.processAddTA();
        });
        ((Button) gui.getGUINode(CSG_ADD_TA_BUTTON)).setOnAction(e -> {
            controller.processAddTA();
        });
        ((Button) gui.getGUINode(CSG_OFFICE_REMOVE_BUTTON)).setOnAction(e -> {
            controller.processRemoveTA();
        });

        TableView officeHoursTableView = (TableView) gui.getGUINode(CSG_OFFICE_HOURS_TABLE_VIEW);
        officeHoursTableView.getSelectionModel().setCellSelectionEnabled(true);
        officeHoursTableView.setOnMouseClicked(e -> {
            controller.processToggleOfficeHours();
        });

        // DON'T LET ANYONE SORT THE TABLES
        TableView tasTableView = (TableView) gui.getGUINode(CSG_TAS_TABLE_VIEW);
        for (int i = 0; i < officeHoursTableView.getColumns().size(); i++) {
            ((TableColumn) officeHoursTableView.getColumns().get(i)).setSortable(false);
        }
        for (int i = 0; i < tasTableView.getColumns().size(); i++) {
            ((TableColumn) tasTableView.getColumns().get(i)).setSortable(false);
        }

        tasTableView.setOnMouseClicked(e -> {
            app.getFoolproofModule().updateAll();
            if (e.getClickCount() == 2) {
                controller.processEditTA();
            }
            controller.processSelectTA();
        });

        RadioButton allRadio = (RadioButton) gui.getGUINode(CSG_ALL_RADIO_BUTTON);
        allRadio.setOnAction(e -> {
            controller.processSelectAllTAs();
        });
        RadioButton gradRadio = (RadioButton) gui.getGUINode(CSG_GRAD_RADIO_BUTTON);
        gradRadio.setOnAction(e -> {
            controller.processSelectGradTAs();
        });
        RadioButton undergradRadio = (RadioButton) gui.getGUINode(CSG_UNDERGRAD_RADIO_BUTTON);
        undergradRadio.setOnAction(e -> {
            controller.processSelectUndergradTAs();
        });
        ComboBox startTime = (ComboBox) gui.getGUINode(CSG_START_TIME_COMBOBOX);
        ComboBox endTime = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);

        startTime.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            if(startTime.getValue()!=null&&!startTime.getValue().toString().equals(data.getStartTime())){
                //controller.setOldStartTime(startTime.getValue().toString());
                controller.processSelectTimeRange();
            }
        });
        /*
        EventHandler<ActionEvent> handle = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseSiteData data = (CourseSiteData) app.getDataComponent();
                if (endTime.getValue() != null && !endTime.getValue().equals(data.getOldEndTime()) && startTime.getValue().equals(data.getOldStartTime())) {
                    controller.setOldEndTime(endTime.getValue().toString());
                    controller.processSelectTimeRange();
                }
            }
        };
        */
        endTime.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();

            //if (endTime.getValue()!=null&&!endTime.getValue().equals(data.getOldEndTime())&&startTime.getValue().equals(data.getOldStartTime())) {
            if (endTime.getValue()!=null&&!endTime.getValue().toString().equals(data.getEndTime())){
                //controller.setOldEndTime(endTime.getValue().toString());
                controller.processSelectTimeRange();
            }
            
        });
        Button officeHoursToggle = (Button) gui.getGUINode(CSG_SITE_INSTRUCTOR_OFFICEHOURS_BUTTON);
        officeHoursToggle.setOnAction(e -> {
            TextArea officeHoursTextArea = (TextArea) gui.getGUINode(CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD);
            officeHoursTextArea.setVisible(!officeHoursTextArea.isVisible());
            if( officeHoursToggle.getText().equals("+"))
                officeHoursToggle.setText("-");
            else
                officeHoursToggle.setText("+");
        });
        
        Button descriptionButton = (Button) gui.getGUINode(CSG_SYLLABUS_DESCRIPTION_BUTTON);
        descriptionButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_DESCRIPTION_BOX);
            text.setVisible(!text.isVisible());
            if( descriptionButton.getText().equals("+"))
                descriptionButton.setText("-");
            else
                descriptionButton.setText("+");
        });
        Button topicsButton = (Button) gui.getGUINode(CSG_SYLLABUS_TOPICS_BUTTON);
        topicsButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_TOPICS_BOX);
            text.setVisible(!text.isVisible());
            if( topicsButton.getText().equals("+"))
                topicsButton.setText("-");
            else
                topicsButton.setText("+");
        });
        Button prereqButton = (Button) gui.getGUINode(CSG_SYLLABUS_PREREQ_BUTTON);
        prereqButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_PREREQ_BOX);
            text.setVisible(!text.isVisible());
            if( prereqButton.getText().equals("+"))
                prereqButton.setText("-");
            else
                prereqButton.setText("+");
        });
        Button outcomesButton = (Button) gui.getGUINode(CSG_SYLLABUS_OUTCOMES_BUTTON);
        outcomesButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_OUTCOMES_BOX);
            text.setVisible(!text.isVisible());
            if( outcomesButton.getText().equals("+"))
                outcomesButton.setText("-");
            else
                outcomesButton.setText("+");
        });
        Button textbooksButton = (Button) gui.getGUINode(CSG_SYLLABUS_TEXTBOOKS_BUTTON);
        textbooksButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_TEXTBOOKS_BOX);
            text.setVisible(!text.isVisible());
            if( textbooksButton.getText().equals("+"))
                textbooksButton.setText("-");
            else
                textbooksButton.setText("+");
        });
        Button gradedcompButton = (Button) gui.getGUINode(CSG_SYLLABUS_GRADEDCOMP_BUTTON);
        gradedcompButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADEDCOMPONENTS_BOX);
            text.setVisible(!text.isVisible());
            if( gradedcompButton.getText().equals("+"))
                gradedcompButton.setText("-");
            else
                gradedcompButton.setText("+");
        });
        Button gradingNoteButton = (Button) gui.getGUINode(CSG_SYLLABUS_GRADINGNOTE_BUTTON);
        gradingNoteButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_GRADINGNOTE_BOX);
            text.setVisible(!text.isVisible());
            if( gradingNoteButton.getText().equals("+"))
                gradingNoteButton.setText("-");
            else
                gradingNoteButton.setText("+");
        });
        Button acedemicButton = (Button) gui.getGUINode(CSG_SYLLABUS_ACDEDEMIC_BUTTON);
        acedemicButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX);
            text.setVisible(!text.isVisible());
            if( acedemicButton.getText().equals("+"))
                acedemicButton.setText("-");
            else
                acedemicButton.setText("+");
        });
        Button specialButton = (Button) gui.getGUINode(CSG_SYLLABUS_SPECIAL_BUTTON);
        specialButton.setOnAction(e -> {
            TextArea text = (TextArea) gui.getGUINode(CSG_SYLLABUS_SPECIALASSISTANCE_BOX);
            text.setVisible(!text.isVisible());
            if( specialButton.getText().equals("+"))
                specialButton.setText("-");
            else
                specialButton.setText("+");
        });
        
        Button faviconButton= (Button) gui.getGUINode(CSG_SITE_STYLE_FAVICON);
        faviconButton.setOnAction(e -> {
            controller.changeFaviconImage();
        });
        Button navbarButton = (Button) gui.getGUINode(CSG_SITE_STYLE_NAVBAR);
        navbarButton.setOnAction(e -> {
            controller.changeNavbarImage();
        });
        Button leftFooterButton = (Button) gui.getGUINode(CSG_SITE_STYLE_LEFTFOOT);
        leftFooterButton.setOnAction(e -> {
            controller.changeLeftFooterImage();
        });
        Button rightFooter = (Button) gui.getGUINode(CSG_SITE_STYLE_RIGHTFOOT);
        rightFooter.setOnAction(e -> {
            controller.changeRightFooterImage();
        });

        Button lectureAdd = (Button) gui.getGUINode(CSG_MEETING_LECTURE_ADD_BUTTON);
        lectureAdd.setOnAction(e -> {
            controller.addLecture();
        });
        Button lectureRemove = (Button) gui.getGUINode(CSG_MEETING_LECTURE_REMOVE_BUTTON);
        lectureRemove.setOnAction(e -> {
            controller.removeLecture();
        });
        
        TableView<Lecture> lectureTable = (TableView) gui.getGUINode(CSG_MEETING_LECTURE_TABLE);
        TableColumn lectureSection = lectureTable.getColumns().get(0);
        TableColumn lectureDays = lectureTable.getColumns().get(1);
        TableColumn lectureTime = lectureTable.getColumns().get(2);
        TableColumn lectureRoom = lectureTable.getColumns().get(3);

        lectureSection.setOnEditCommit(t -> {
            CellEditEvent<Lecture, String> evt = (CellEditEvent<Lecture, String>) t;
            controller.editLecture("section",evt.getOldValue(),evt.getNewValue());
        });
        lectureDays.setOnEditCommit(t -> {
            CellEditEvent<Lecture, String> evt = (CellEditEvent<Lecture, String>) t;
            controller.editLecture("days", evt.getOldValue(), evt.getNewValue());
        });
        lectureTime.setOnEditCommit(t -> {
            CellEditEvent<Lecture, String> evt = (CellEditEvent<Lecture, String>) t;
            controller.editLecture("time", evt.getOldValue(), evt.getNewValue());
        });
        lectureRoom.setOnEditCommit(t -> {
            CellEditEvent<Lecture, String> evt = (CellEditEvent<Lecture, String>) t;
            controller.editLecture("room", evt.getOldValue(), evt.getNewValue());
        });
        
        
        Button recitationAdd = (Button) gui.getGUINode(CSG_MEETING_RECITATION_ADD_BUTTON);
        recitationAdd.setOnAction(e -> {
            controller.addRecitation();
        });
        Button recitationRemove = (Button) gui.getGUINode(CSG_MEETING_RECITATION_REMOVE_BUTTON);
        recitationRemove.setOnAction(e -> {
            controller.removeRecitation();
        });
        
        TableView<Recitation> recitationTable = (TableView) gui.getGUINode(CSG_MEETING_RECITATION_TABLE);
        TableColumn recitationSection = recitationTable.getColumns().get(0);
        TableColumn recitationDaytime = recitationTable.getColumns().get(1);
        TableColumn recitationTA1 = recitationTable.getColumns().get(3);
        TableColumn recitationTA2 = recitationTable.getColumns().get(4);
        TableColumn recitationRoom = recitationTable.getColumns().get(2);

        recitationSection.setOnEditCommit(t -> {
            CellEditEvent<Recitation, String> evt = (CellEditEvent<Recitation, String>) t;
            controller.editRecitation("section", evt.getOldValue(), evt.getNewValue());
        });
        recitationDaytime.setOnEditCommit(t -> {
            CellEditEvent<Recitation, String> evt = (CellEditEvent<Recitation, String>) t;
            controller.editRecitation("daytime", evt.getOldValue(), evt.getNewValue());
        });
        recitationTA1.setOnEditCommit(t -> {
            CellEditEvent<Recitation, String> evt = (CellEditEvent<Recitation, String>) t;
            controller.editRecitation("ta1", evt.getOldValue(), evt.getNewValue());
        });
        recitationTA2.setOnEditCommit(t -> {
            CellEditEvent<Recitation, String> evt = (CellEditEvent<Recitation, String>) t;
            controller.editRecitation("ta2", evt.getOldValue(), evt.getNewValue());
        });
        recitationRoom.setOnEditCommit(t -> {
            CellEditEvent<Recitation, String> evt = (CellEditEvent<Recitation, String>) t;
            controller.editRecitation("room", evt.getOldValue(), evt.getNewValue());
        });
        
        Button labAdd = (Button) gui.getGUINode(CSG_MEETING_LAB_ADD_BUTTON);
        labAdd.setOnAction(e -> {
            controller.addLab();
        });
        Button labRemove = (Button) gui.getGUINode(CSG_MEETING_LAB_REMOVE_BUTTON);
        labRemove.setOnAction(e -> {
            controller.removeLab();
        });
        
        TableView<Lab> labTable = (TableView) gui.getGUINode(CSG_MEETING_LAB_TABLE);
        TableColumn labSection = labTable.getColumns().get(0);
        TableColumn labDaytime = labTable.getColumns().get(1);
        TableColumn labTA1 = labTable.getColumns().get(3);
        TableColumn labTA2 = labTable.getColumns().get(4);
        TableColumn labRoom = labTable.getColumns().get(2);

        labSection.setOnEditCommit(t -> {
            CellEditEvent<Lab, String> evt = (CellEditEvent<Lab, String>) t;
            controller.editLab("section", evt.getOldValue(), evt.getNewValue());
        });
        labDaytime.setOnEditCommit(t -> {
            CellEditEvent<Lab, String> evt = (CellEditEvent<Lab, String>) t;
            controller.editLab("daytime", evt.getOldValue(), evt.getNewValue());
        });
        labTA1.setOnEditCommit(t -> {
            CellEditEvent<Lab, String> evt = (CellEditEvent<Lab, String>) t;
            controller.editLab("ta1", evt.getOldValue(), evt.getNewValue());
        });
        labTA2.setOnEditCommit(t -> {
            CellEditEvent<Lab, String> evt = (CellEditEvent<Lab, String>) t;
            controller.editLab("ta2", evt.getOldValue(), evt.getNewValue());
        });
        labRoom.setOnEditCommit(t -> {
            CellEditEvent<Lab, String> evt = (CellEditEvent<Lab, String>) t;
            controller.editLab("room", evt.getOldValue(), evt.getNewValue());
        });
        
        DatePicker startDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_START_DATEPICKER);
        startDatePicker.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            try{
            if (!startDatePicker.getValue().equals(data.getStartDate())) {
                controller.changeStartDate(startDatePicker.getValue());
            }
            }catch(NullPointerException ex){
            }
        });
        DatePicker endDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_END_DATEPICKER);
        endDatePicker.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            try{
            if (!endDatePicker.getValue().equals(data.getEndDate())) {
                controller.changeEndDate(endDatePicker.getValue());
            }
            }catch(NullPointerException ex){
            }
        });
        DatePicker editDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_EDIT_DATEPICKER);
        editDatePicker.setOnAction(e -> {
            CourseSiteData data = (CourseSiteData) app.getDataComponent();
            try{
            if (!editDatePicker.getValue().equals(data.getEditDate())) {
                controller.changeEditDate(editDatePicker.getValue());
            }
            }catch(NullPointerException ex){
            }
        });
        Button addButton = (Button)gui.getGUINode(CSG_SCHEDULE_ADD_BUTTON);
        Button clearButton = (Button)gui.getGUINode(CSG_SCHEDULE_ADD_CLEAR_BUTTON);
        addButton.setOnAction(e -> {
            controller.addEditScheduleItem();
        });
        clearButton.setOnAction(e -> {
            controller.clearScheduleItem();
        });
        
        TableView scheduleTable = (TableView) gui.getGUINode(CSG_SCHEDULE_TABLE);
        scheduleTable.setOnMouseClicked(e -> {
            controller.fillInScheduleInfo();
        });
        Button removeButton = (Button) gui.getGUINode(CSG_SCHEDULE_REMOVE_SCHEDULE_ITEM_BUTTON);
        removeButton.setOnAction(e -> {
            controller.removeScheduleItem();
        });

        
    }
    /*
    AppGUIModule gui = app.getGUIModule();
    ComboBox endTime = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
    ComboBox startTime = (ComboBox) gui.getGUINode(CSG_START_TIME_COMBOBOX);
    EventHandler<ActionEvent> handle = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseSiteData data = (CourseSiteData) app.getDataComponent();
                if (endTime.getValue() != null && !endTime.getValue().equals(data.getOldEndTime()) && startTime.getValue().equals(data.getOldStartTime())) {
                    controller.setOldEndTime(endTime.getValue().toString());
                    controller.processSelectTimeRange();
                }
            }
        };
    public void disableEndTimes(){
         ComboBox endTime = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
        endTime.setOnAction(null);
        
    }
    
    public void reenableEndTimes(){
         ComboBox endTime = (ComboBox) gui.getGUINode(CSG_END_TIME_COMBOBOX);
        endTime.setOnAction(handle);
    }
*/
    public void initFoolproofDesign() {
        AppGUIModule gui = app.getGUIModule();
        AppFoolproofModule foolproofSettings = app.getFoolproofModule();
        foolproofSettings.registerModeSettings(CSG_FOOLPROOF_SETTINGS,
                new CourseSiteFoolproofDesign((CourseSiteGenerator) app));
    }

    @Override
    public void processWorkspaceKeyEvent(KeyEvent ke) {
        // WE AREN'T USING THIS FOR THIS APPLICATION
    }

    @Override
    public void showNewDialog() {
        // WE AREN'T USING THIS FOR THIS APPLICATION
    }
    
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
        InputStream is = new FileInputStream(jsonFilePath);
        JsonReader jsonReader = Json.createReader(is);
        JsonObject json = jsonReader.readObject();
        jsonReader.close();
        is.close();
        return json;
    }
    public void loadSubjectsAndNumbers() throws IOException{
        AppGUIModule gui = app.getGUIModule();
        ComboBox subjectTextField = (ComboBox) gui.getGUINode(CSG_SITE_SUBJECT_COMBOBOX);
        ComboBox numberTextField = (ComboBox) gui.getGUINode(CSG_SITE_NUMBER_COMBOBOX);
        JsonObject json = loadJSONFile("./options/options.json");
        JsonArray jsonSubjectsArray = json.getJsonArray("subjects");
        for (JsonValue jsonSubject : jsonSubjectsArray) {
            String subject = jsonSubject.toString();
            subject=subject.replaceAll("\"", "");
            subjectTextField.getItems().add(subject);
        }
        JsonArray jsonNumbersArray = json.getJsonArray("numbers");
        for (JsonValue jsonNumber : jsonNumbersArray) {
            String number = jsonNumber.toString();
            number=number.replaceAll("\"", "");
            numberTextField.getItems().add(number);
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
        }
        
    }
}


