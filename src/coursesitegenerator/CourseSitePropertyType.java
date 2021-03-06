package coursesitegenerator;

/**
 * This class provides the properties that are needed to be loaded for
 * setting up To Do List Maker workspace controls including language-dependent
 * text.
 * 
 * @author Jia Wei Zheng
 * @version 1.0
 */
public enum CourseSitePropertyType {

    
    /* THESE ARE THE NODES IN OUR APP */
    // FOR SIMPLE OK/CANCEL DIALOG BOXES
    CSG_OK_PROMPT,
    CSG_CANCEL_PROMPT,

    // THESE ARE FOR TEXT PARTICULAR TO THE APP'S WORKSPACE CONTROLS
    CSG_LEFT_PANE,
    CSG_TAS_HEADER_PANE,
    CSG_TAS_HEADER_LABEL,
    CSG_GRAD_UNDERGRAD_TAS_PANE,
    CSG_ALL_RADIO_BUTTON,
    CSG_GRAD_RADIO_BUTTON,
    CSG_UNDERGRAD_RADIO_BUTTON,
    CSG_TAS_HEADER_TEXT_FIELD,
    CSG_TAS_TABLE_VIEW,
    CSG_NAME_TABLE_COLUMN,
    CSG_EMAIL_TABLE_COLUMN,
    CSG_SLOTS_TABLE_COLUMN,
    CSG_TYPE_TABLE_COLUMN,

    CSG_ADD_TA_PANE,
    CSG_NAME_TEXT_FIELD,
    CSG_EMAIL_TEXT_FIELD,
    CSG_ADD_TA_BUTTON,

    CSG_RIGHT_PANE,
    CSG_OFFICE_HOURS_HEADER_PANE,
    CSG_OFFICE_HOURS_HEADER_LABEL,
    CSG_OFFICE_HOURS_TABLE_VIEW,
    CSG_START_TIME_TABLE_COLUMN,
    CSG_END_TIME_TABLE_COLUMN,
    CSG_MONDAY_TABLE_COLUMN,
    CSG_TUESDAY_TABLE_COLUMN,
    CSG_WEDNESDAY_TABLE_COLUMN,
    CSG_THURSDAY_TABLE_COLUMN,
    CSG_FRIDAY_TABLE_COLUMN,
    CSG_DAYS_OF_WEEK,
    CSG_FOOLPROOF_SETTINGS,
    
    // FOR THE EDIT DIALOG
    CSG_TA_EDIT_DIALOG,
    CSG_TA_DIALOG_GRID_PANE,
    CSG_TA_DIALOG_HEADER_LABEL, 
    CSG_TA_DIALOG_NAME_LABEL,
    CSG_TA_DIALOG_NAME_TEXT_FIELD,
    CSG_TA_DIALOG_EMAIL_LABEL,
    CSG_TA_DIALOG_EMAIL_TEXT_FIELD,
    CSG_TA_DIALOG_TYPE_LABEL,
    CSG_TA_DIALOG_TYPE_BOX,
    CSG_TA_DIALOG_GRAD_RADIO_BUTTON,
    CSG_TA_DIALOG_UNDERGRAD_RADIO_BUTTON,
    CSG_TA_DIALOG_OK_BOX,
    CSG_TA_DIALOG_OK_BUTTON, 
    CSG_TA_DIALOG_CANCEL_BUTTON, 
    
    // THESE ARE FOR ERROR MESSAGES PARTICULAR TO THE APP
    CSG_NO_TA_SELECTED_TITLE, CSG_NO_TA_SELECTED_CONTENT,
    
    CSG_SITE_TAB,
    CSG_SYLLABUS_TAB,
    CSG_MEETING_TAB,
    CSG_OFFICE_TAB,
    CSG_SCHEDULE_TAB,
    
    CSG_SITE_PANE,
    CSG_SYLLABUS_PANE,
    CSG_MEETING_PANE,
    CSG_OFFICE_PANE,
    CSG_SCHEDULE_PANE,
    
    CSG_SITE_BANNER_BOX,
    CSG_SITE_PAGES_BOX,
    CSG_SITE_STYLE_BOX,
    CSG_SITE_INSTRUCTOR_BOX,
    CSG_SITE_BANNER_SUBJECT,
    CSG_SITE_BANNER_NUMBER,
    CSG_SITE_BANNER_SEMESTER,
    CSG_SITE_BANNER_YEAR,
    CSG_SITE_BANNER_TITLE,
    CSG_SITE_BANNER_EXPORTDIR,
    CSG_SITE_SUBJECT_COMBOBOX,
    CSG_SITE_SEMESTER_COMBOBOX,
    CSG_SITE_NUMBER_COMBOBOX,
    CSG_SITE_YEAR_COMBOBOX,
    CSG_SUBJECT_OPTIONS,
    CSG_SUBJECT_DEFAULT,
    CSG_SEMESTER_OPTIONS,
    CSG_SEMESTER_DEFAULT,
    CSG_NUMBER_OPTIONS,
    CSG_NUMBER_DEFAULT,
    CSG_YEAR_OPTIONS,
    CSG_YEAR_DEFAULT,
    CSG_SITE_TITLE,
    CSG_SITE_BANNER_EXPORTDIRTEXT,
    CSG_SITE_PAGES_TITLE,
    CSG_SITE_PAGES_HOME,
    CSG_SITE_PAGES_SYLLABUS,
    CSG_SITE_PAGES_SCHEDULE,
    CSG_SITE_PAGES_HWS,
    CSG_SITE_PAGES_HOME_CHECK,
    CSG_SITE_PAGES_SYLLABUS_CHECK,
    CSG_SITE_PAGES_SCHEDULE_CHECK,
    CSG_SITE_PAGES_HWS_CHECK,
    CSG_SITE_STYLE_TITLE,
    CSG_SITE_STYLE_FAVICON,
    CSG_SITE_STYLE_NAVBAR,
    CSG_SITE_STYLE_LEFTFOOT,
    CSG_SITE_STYLE_RIGHTFOOT,
    CSG_SITE_STYLE_FONTSCOLORS,
    CSG_SITE_STYLE_CSS,
    CSG_SITE_STYLE_NOTE,
    CSG_SITE_STYLE_CSS_OPTIONS,
    CSG_SITE_STYLE_CSS_DEFAULT,
    CSG_SITE_INSTRUCTOR_TITLE,
    CSG_SITE_INSTRUCTOR_NAME,
    CSG_SITE_INSTRUCTOR_EMAIL,
    CSG_SITE_INSTRUCTOR_ROOM,
    CSG_SITE_INSTRUCTOR_HOMEPAGE,
    CSG_SITE_INSTRUCTOR_OFFICEHOURS,
    CSG_SITE_INSTRUCTOR_OFFICEHOURS_BUTTON,
    CSG_SITE_INSTRUCTOR_OFFICEHOURSFIELD,
    CSG_SITE_INSTRUCTOR_NAME_FIELD,
    CSG_SITE_INSTRUCTOR_EMAIL_FIELD,
    CSG_SITE_INSTRUCTOR_ROOM_FIELD,
    CSG_SITE_INSTRUCTOR_HOMEPAGE_FIELD,
    
    CSG_SYLLABUS_DESCRIPTION_BOX,
    CSG_SYLLABUS_TOPICS_BOX,
    CSG_SYLLABUS_PREREQ_BOX,
    CSG_SYLLABUS_OUTCOMES_BOX,
    CSG_SYLLABUS_TEXTBOOKS_BOX,
    CSG_SYLLABUS_GRADEDCOMPONENTS_BOX,
    CSG_SYLLABUS_GRADINGNOTE_BOX,
    CSG_SYLLABUS_ACEDEMICDISHONESTY_BOX,
    CSG_SYLLABUS_SPECIALASSISTANCE_BOX,
    CSG_SYLLABUS_DESCRIPTION_BUTTON,
    CSG_SYLLABUS_TOPICS_BUTTON,
    CSG_SYLLABUS_PREREQ_BUTTON,
    CSG_SYLLABUS_OUTCOMES_BUTTON,
    CSG_SYLLABUS_TEXTBOOKS_BUTTON,
    CSG_SYLLABUS_GRADEDCOMP_BUTTON,
    CSG_SYLLABUS_GRADINGNOTE_BUTTON,
    CSG_SYLLABUS_ACDEDEMIC_BUTTON,
    CSG_SYLLABUS_SPECIAL_BUTTON,
    CSG_SYLLABUS_DESCRIPTION,
    CSG_SYLLABUS_TOPICS,
    CSG_SYLLABUS_PREREQ,
    CSG_SYLLABUS_OUTCOMES,
    CSG_SYLLABUS_TEXTBOOKS,
    CSG_SYLLABUS_GRADEDCOMP,
    CSG_SYLLABUS_GRADINGNOTE,
    CSG_SYLLABUS_ACAMEDIC,
    CSG_SYLLABUS_SPECIAL,
    
    CSG_MEETING_LECTURE_ADD_BUTTON,
    CSG_MEETING_LECTURE_REMOVE_BUTTON,
    CSG_MEETING_LECTURE_TITLE,
    CSG_MEETING_LECTURE_SECTION,
    CSG_MEETING_LECTURE_DAYS,
    CSG_MEETING_LECTURE_TIME,
    CSG_MEETING_LECTURE_ROOM,
    CSG_MEETING_RECITATION_ADD_BUTTON,
    CSG_MEETING_RECITATION_REMOVE_BUTTON,
    CSG_MEETING_RECITATION_TITLE,
    CSG_MEETING_RECITATION_SECTION,
    CSG_MEETING_RECITATION_DAYTIME,
    CSG_MEETING_RECITATION_ROOM,
    CSG_MEETING_RECITATION_TA1,
    CSG_MEETING_RECITATION_TA2,
    CSG_MEETING_LAB_ADD_BUTTON,
    CSG_MEETING_LAB_REMOVE_BUTTON,
    CSG_MEETING_LAB_TITLE,
    CSG_MEETING_LAB_SECTION,
    CSG_MEETING_LAB_DAYTIME,
    CSG_MEETING_LAB_ROOM,
    CSG_MEETING_LAB_TA1,
    CSG_MEETING_LAB_TA2,
    CSG_MEETING_LECTURE_TABLE,
    CSG_MEETING_RECITATION_TABLE,
    CSG_MEETING_LAB_TABLE,
    
    CSG_SCHEDULE_CALENDER_TITLE,
    CSG_SCHEDULE_STARTING_MONDAY,
    CSG_SCHEDULE_ENDING_FRIDAY,
    CSG_SCHEDULE_REMOVE_SCHEDULE_ITEM_BUTTON,
    CSG_SCHEDULE_SCHEDULE_TITLE,
    CSG_SCHEDULE_SCHEDULE_TYPE,
    CSG_SCHEDULE_SCHEDULE_DATE,
    CSG_SCHEDULE_SCHEDULE_TITLECOL,
    CSG_SCHEDULE_SCHEDULE_TOPIC,
    CSG_SCHEDULE_ADDEDIT_TITLE,
    CSG_SCHEDULE_ADD_TYPE,
    CSG_SCHEDULE_ADD_DATE,
    CSG_SCHEDULE_ADD_TITLE,
    CSG_SCHEDULE_ADD_TOPIC,
    CSG_SCHEDULE_ADD_LINK,
    CSG_SCHEDULE_ADD_BUTTON,
    CSG_SCHEDULE_ADD_CLEAR_BUTTON,
    CSG_SCHEDULE_START_DATEPICKER,
    CSG_SCHEDULE_END_DATEPICKER,
    CSG_SCHEDULE_EDIT_DATEPICKER,
    CSG_SCHEDULE_TABLE,
    CSG_SCHEDULE_TYPE_COMBOBOX,
    CSG_SCHEDULE_TITLE_FIELD,
    CSG_SCHEDULE_TOPIC_FIELD,
    CSG_SCHEDULE_LINK_FIELD,
    
    
    CSG_OFFICE_REMOVE_BUTTON,
    
    CSG_OFFICE_TA_PANE,
    CSG_START_TIME_COMBOBOX,
    CSG_END_TIME_COMBOBOX,
    CSG_START_TIME_OPTIONS,
    CSG_START_TIME_DEFAULT,
    CSG_END_TIME_OPTIONS,
    CSG_END_TIME_DEFAULT,
    CSG_START_TIME_LABEL,
    CSG_END_TIME_LABEL,
    CSG_TYPE_OPTIONS,
    CSG_TYPE_DEFAULT,

    CSG_STYLE_FAVICON,
    CSG_STYLE_NAVBAR,
    CSG_STYLE_LEFTFOOTER,
    CSG_STYLE_RIGHTFOOTER

}
