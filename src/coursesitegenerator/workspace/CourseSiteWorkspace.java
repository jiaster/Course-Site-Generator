/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.workspace;

import coursesitegenerator.CourseSiteGenerator;
import coursesitegenerator.CourseSitePropertyType;
import static coursesitegenerator.CourseSitePropertyType.CSG_ADD_TA_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_ADD_TA_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_FOOLPROOF_SETTINGS;
import static coursesitegenerator.CourseSitePropertyType.CSG_GRAD_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_TA_EDIT_DIALOG;
import static coursesitegenerator.CourseSitePropertyType.CSG_UNDERGRAD_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_ALL_RADIO_BUTTON;
import static coursesitegenerator.CourseSitePropertyType.CSG_EMAIL_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_EMAIL_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_END_TIME_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_FRIDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_GRAD_UNDERGRAD_TAS_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_LEFT_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_MEETING_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_MONDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_NAME_TEXT_FIELD;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_HEADER_LABEL;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_HEADER_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_HOURS_TABLE_VIEW;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_OFFICE_TA_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_RIGHT_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_BANNER_BOX;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_SITE_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_SLOTS_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_START_TIME_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_SYLLABUS_TAB;
import static coursesitegenerator.CourseSitePropertyType.CSG_TAS_HEADER_PANE;
import static coursesitegenerator.CourseSitePropertyType.CSG_THURSDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_TUESDAY_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_TYPE_TABLE_COLUMN;
import static coursesitegenerator.CourseSitePropertyType.CSG_WEDNESDAY_TABLE_COLUMN;
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
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Jiaster
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
    private void initLayout() {
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
        
        BorderPane sitePane = new BorderPane();
        siteTab.setContent(sitePane);
        BorderPane syllabusPane = new BorderPane();
        syllabusTab.setContent(syllabusPane);
        BorderPane meetingPane = new BorderPane();
        meetingTab.setContent(meetingPane);
        BorderPane officePane = new BorderPane();
        officeTab.setContent(officePane);
        BorderPane schedulePane = new BorderPane();
        scheduleTab.setContent(schedulePane);
        
        
        VBox siteVBox = csjBuilder.buildVBox(CSG_SITE_PANE, sitePane, CLASS_CSG_PANE, ENABLED);
        GridPane siteBannerBox = csjBuilder.buildGridPane(CSG_SITE_BANNER_BOX, siteVBox, CLASS_CSG_BOX, ENABLED);
        csjBuilder.buildLabel(CourseSitePropertyType.CSG_SITE_BANNER_BOX, siteBannerBox, CLASS_CSG_HEADER_LABEL, ENABLED);
        
        HBox tasHeaderBox = csjBuilder.buildHBox(CSG_OFFICE_TA_PANE, officePane, CLASS_CSG_BOX, ENABLED);
        csjBuilder.buildLabel(CourseSitePropertyType.CSG_TAS_HEADER_LABEL, tasHeaderBox, CLASS_CSG_HEADER_LABEL, ENABLED);
        
        HBox typeHeaderBox = csjBuilder.buildHBox(CSG_GRAD_UNDERGRAD_TAS_PANE, tasHeaderBox, CLASS_CSG_RADIO_BOX, ENABLED);
        ToggleGroup tg = new ToggleGroup();
        csjBuilder.buildRadioButton(CSG_ALL_RADIO_BUTTON, typeHeaderBox, CLASS_CSG_RADIO_BUTTON, ENABLED, tg, true);
        csjBuilder.buildRadioButton(CSG_GRAD_RADIO_BUTTON, typeHeaderBox, CLASS_CSG_RADIO_BUTTON, ENABLED, tg, false);
        csjBuilder.buildRadioButton(CSG_UNDERGRAD_RADIO_BUTTON, typeHeaderBox, CLASS_CSG_RADIO_BUTTON, ENABLED, tg, false);

        // MAKE THE TABLE AND SETUP THE DATA MODEL
        TableView<TeachingAssistantPrototype> taTable = csjBuilder.buildTableView(CSG_TAS_TABLE_VIEW, officePane, CLASS_CSG_TABLE_VIEW, ENABLED);
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


        // ADD BOX FOR ADDING A TA
        HBox taBox = csjBuilder.buildHBox(CSG_ADD_TA_PANE, officePane, CLASS_CSG_PANE, ENABLED);
        csjBuilder.buildTextField(CSG_NAME_TEXT_FIELD, taBox, CLASS_CSG_TEXT_FIELD, ENABLED);
        csjBuilder.buildTextField(CSG_EMAIL_TEXT_FIELD, taBox, CLASS_CSG_TEXT_FIELD, ENABLED);
        csjBuilder.buildTextButton(CSG_ADD_TA_BUTTON, taBox, CLASS_CSG_BUTTON, !ENABLED);

        // MAKE SURE IT'S THE TABLE THAT ALWAYS GROWS IN THE LEFT PANE
        VBox.setVgrow(taTable, Priority.ALWAYS);

        // INIT THE HEADER ON THE RIGHT
        VBox rightPane = csjBuilder.buildVBox(CSG_RIGHT_PANE, null, CLASS_CSG_PANE, ENABLED);
        HBox officeHoursHeaderBox = csjBuilder.buildHBox(CSG_OFFICE_HOURS_HEADER_PANE, rightPane, CLASS_CSG_PANE, ENABLED);
        csjBuilder.buildLabel(CSG_OFFICE_HOURS_HEADER_LABEL, officeHoursHeaderBox, CLASS_CSG_HEADER_LABEL, ENABLED);

        // SETUP THE OFFICE HOURS TABLE
        TableView<TimeSlot> officeHoursTable = csjBuilder.buildTableView(CSG_OFFICE_HOURS_TABLE_VIEW, rightPane, CLASS_CSG_OFFICE_HOURS_TABLE_VIEW, ENABLED);
        setupOfficeHoursColumn(CSG_START_TIME_TABLE_COLUMN, officeHoursTable, CLASS_CSG_TIME_COLUMN, "startTime");
        setupOfficeHoursColumn(CSG_END_TIME_TABLE_COLUMN, officeHoursTable, CLASS_CSG_TIME_COLUMN, "endTime");
        setupOfficeHoursColumn(CSG_MONDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "monday");
        setupOfficeHoursColumn(CSG_TUESDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "tuesday");
        setupOfficeHoursColumn(CSG_WEDNESDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "wednesday");
        setupOfficeHoursColumn(CSG_THURSDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "thursday");
        setupOfficeHoursColumn(CSG_FRIDAY_TABLE_COLUMN, officeHoursTable, CLASS_CSG_DAY_OF_WEEK_COLUMN, "friday");

        // MAKE SURE IT'S THE TABLE THAT ALWAYS GROWS IN THE LEFT PANE
        VBox.setVgrow(officeHoursTable, Priority.ALWAYS);

        // BOTH PANES WILL NOW GO IN A SPLIT PANE
        //SplitPane sPane = new SplitPane(leftPane, rightPane);
        //sPane.setDividerPositions(.4);



        


        // AND PUT EVERYTHING IN THE WORKSPACE
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

    public void initControllers() {
        
        CourseSiteGeneratorController controller = new CourseSiteGeneratorController((CourseSiteGenerator) app);
        AppGUIModule gui = app.getGUIModule();

        // FOOLPROOF DESIGN STUFF
        TextField nameTextField = ((TextField) gui.getGUINode(CSG_NAME_TEXT_FIELD));
        TextField emailTextField = ((TextField) gui.getGUINode(CSG_EMAIL_TEXT_FIELD));

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


    }

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
}
