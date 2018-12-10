/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursesitegenerator.files;

import coursesitegenerator.CourseSiteGenerator;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_END_DATEPICKER;
import static coursesitegenerator.CourseSitePropertyType.CSG_SCHEDULE_START_DATEPICKER;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import coursesitegenerator.data.CourseSiteData;
import coursesitegenerator.data.Lab;
import coursesitegenerator.data.Lecture;
import coursesitegenerator.data.Recitation;
import coursesitegenerator.data.ScheduleItem;
import coursesitegenerator.data.TAType;
import coursesitegenerator.data.TeachingAssistantPrototype;
import coursesitegenerator.data.TimeSlot;
import static djf.AppPropertyType.APP_EXPORT_PAGE;
import static djf.AppPropertyType.APP_PATH_WEB;
import static djf.AppPropertyType.HELP_DIALOG_ERROR_CONTENT;
import static djf.AppPropertyType.HELP_DIALOG_ERROR_TITLE;
import djf.modules.AppGUIModule;
import djf.ui.dialogs.AppDialogsFacade;
import djf.ui.dialogs.AppWebDialog;
import java.io.File;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.EnumSet;
import javafx.scene.control.DatePicker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.json.stream.JsonParser;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jia Wei Zheng
 */
public class CourseSiteFiles implements AppFileComponent {
    // THIS IS THE APP ITSELF
    CourseSiteGenerator app;
    
    // THESE ARE USED FOR IDENTIFYING JSON TYPES
    static final String JSON_GRAD_TAS = "grad_tas";
    static final String JSON_UNDERGRAD_TAS = "undergrad_tas";
    static final String JSON_NAME = "name";
    static final String JSON_EMAIL = "email";
    static final String JSON_TYPE = "type";
    static final String JSON_OFFICE_HOURS = "officeHours";
    static final String JSON_START_HOUR = "startHour";
    static final String JSON_END_HOUR = "endHour";
    static final String JSON_START_TIME = "time";
    static final String JSON_DAY_OF_WEEK = "day";
    static final String JSON_MONDAY = "monday";
    static final String JSON_TUESDAY = "tuesday";
    static final String JSON_WEDNESDAY = "wednesday";
    static final String JSON_THURSDAY = "thursday";
    static final String JSON_FRIDAY = "friday";
    static final String JSON_SUBJECT = "subject";
    static final String JSON_SEMESTER = "semester";
    static final String JSON_NUMBER = "number";
    static final String JSON_YEAR = "year";
    static final String JSON_TITLE = "title";
    //static final String JSON_EXPORTDIR = "exportdir";
    static final String JSON_HOME = "home";
    static final String JSON_SYLLABUS = "syllabus";
    static final String JSON_SCHEDULE = "schedule";
    static final String JSON_HWS = "hws";
    static final String JSON_FAVICON = "favicon";
    static final String JSON_NAVBAR = "navbar";
    static final String JSON_LEFTFOOTER = "leftfooter";
    static final String JSON_RIGHTFOOTER = "rightfooter";
    static final String JSON_CSS = "css";
    static final String JSON_ROOM = "room";
    static final String JSON_INSTRUCTOR = "instructor";
    static final String JSON_HOMEPAGE = "link";
    static final String JSON_OFFICEHOURS = "hours";
    static final String JSON_DESCRIPTION = "description";
    static final String JSON_PAGES = "pages";
    static final String JSON_TOPICS = "topics";
    static final String JSON_PREREQ = "prereq";
    static final String JSON_OUTCOMES = "outcomes";
    static final String JSON_TEXTBOOKS = "textbooks";
    static final String JSON_GRADEDCOMPONENTS = "gradedcomponents";
    static final String JSON_GRADINGNOTE = "gradingnote";
    static final String JSON_ACADEMIC = "academic";
    static final String JSON_SPECIAL = "special";
    static final String JSON_STARTTIME = "starttime";
    static final String JSON_ENDTIME = "endtime";
    static final String JSON_LOGOS = "logos";
    static final String JSON_HREF = "href";
    static final String JSON_SRC = "src";
    static final String JSON_LINK = "link";
    static final String JSON_MONTH = "month";
    static final String JSON_DAY = "day";
    static final String JSON_TOPIC = "topic";
    static final String JSON_STARTINGMONDAYMONTH = "startingMondayMonth";
    static final String JSON_STARTINGMONDAYDAY = "startingMondayDay";
    static final String JSON_ENDINGFRIDAYMONTH = "endingFridayMonth";
    static final String JSON_ENDINGFRIDAYDAY = "endingFridayDay";
    static final String JSON_HOLIDAYS = "holidays";
    static final String JSON_LECTURES = "lectures";
    static final String JSON_REFERENCES = "references";
    static final String JSON_RECITATIONS = "recitations";
    static final String JSON_SECTION = "section";
    static final String JSON_DAYTIME = "day_time";
    static final String JSON_LOCATION = "location";
    static final String JSON_TA1 = "ta_1";
    static final String JSON_TA2 = "ta_2";
    static final String JSON_DAYS = "days";
    static final String JSON_TIME = "time";
    static final String JSON_LABS = "labs";
    static final String JSON_SECTIONS_LECTURES = "sectionLectures";
    static final String JSON_SECTIONS_RECITATIONS = "sectionRecitations";
    static final String JSON_SCHEDULE_HWS = "HWS";
    static final String JSON_PREREQUISITES = "prerequisites";
    static final String JSON_ACADEMICDISHONESTY = "academicDishonesty";
    static final String JSON_SPECIALASSISTANCE = "specialAssistance";
    static final String JSON_GRADEDCOMPONENTSX = "gradedComponents";
    static final String JSON_GRADINGNOTEX = "gradingNote";
    static final String JSON_BOTTOM_LEFT = "bottom_left";
    static final String JSON_BOTTOM_RIGHT = "bottom_right";


    public CourseSiteFiles(CourseSiteGenerator initApp) {
        app = initApp;
    }

    @Override
    public void loadData(AppDataComponent data, String filePath) throws IOException {
	// CLEAR THE OLD DATA OUT
	CourseSiteData dataManager = (CourseSiteData)data;
        dataManager.reset();

	// LOAD THE JSON FILE WITH ALL THE DATA
	JsonObject json = loadJSONFile(filePath);

	// LOAD THE START AND END HOURS
	String startHour = json.getString(JSON_START_HOUR);
        String endHour = json.getString(JSON_END_HOUR);
        dataManager.initHours(startHour, endHour);
        
        // LOAD ALL THE GRAD TAs
        loadTAs(dataManager, json, JSON_GRAD_TAS);
        loadTAs(dataManager, json, JSON_UNDERGRAD_TAS);

        // AND THEN ALL THE OFFICE HOURS
        JsonArray jsonOfficeHoursArray = json.getJsonArray(JSON_OFFICE_HOURS);
        for (int i = 0; i < jsonOfficeHoursArray.size(); i++) {
            JsonObject jsonOfficeHours = jsonOfficeHoursArray.getJsonObject(i);
            String startTime = jsonOfficeHours.getString(JSON_START_TIME);
            TimeSlot.DayOfWeek dow = TimeSlot.DayOfWeek.valueOf(jsonOfficeHours.getString(JSON_DAY_OF_WEEK));
            String name = jsonOfficeHours.getString(JSON_NAME);
            TeachingAssistantPrototype ta = dataManager.getTAWithName(name);
            TimeSlot timeSlot = dataManager.getTimeSlot(startTime);
            timeSlot.toggleTA(dow, ta);
        }
        
        
        JsonArray lecturesArray = json.getJsonArray(JSON_SECTIONS_LECTURES);
        for (int i = 0; i < lecturesArray.size(); i++) {
            JsonObject lectureJSON = lecturesArray.getJsonObject(i);
            Lecture lecture = new Lecture(lectureJSON.getString("section"),lectureJSON.getString("days"),lectureJSON.getString("time"),lectureJSON.getString("room"));
            dataManager.addLecture(lecture);
        }
        JsonArray labArray = json.getJsonArray(JSON_LABS);
        for (int i = 0; i < labArray.size(); i++) {
            JsonObject labJSON = labArray.getJsonObject(i);
            Lab lab = new Lab(labJSON.getString("section"),labJSON.getString("day_time"),labJSON.getString("location"),labJSON.getString("ta_1"),labJSON.getString("ta_2"));
            dataManager.addLab(lab);
        }
        JsonArray recitationArray = json.getJsonArray(JSON_SECTIONS_RECITATIONS);
        for (int i = 0; i < recitationArray.size(); i++) {
            JsonObject recitationJSON = recitationArray.getJsonObject(i);
            Recitation recitation = new Recitation(recitationJSON.getString("section"),recitationJSON.getString("day_time"),recitationJSON.getString("location"),recitationJSON.getString("ta_1"),recitationJSON.getString("ta_2"));
            dataManager.addRecitation(recitation);
        }
        
        JsonArray scheduleHolidayArray = json.getJsonArray(JSON_HOLIDAYS);
        for (int i = 0; i < scheduleHolidayArray.size(); i++) {
            JsonObject holidayJSON = scheduleHolidayArray.getJsonObject(i);
            ScheduleItem item = new ScheduleItem(holidayJSON.getString("month"), holidayJSON.getString("day"),"Holidays", holidayJSON.getString("title"), holidayJSON.getString("link"), holidayJSON.getString("topic"));
            dataManager.addScheduleItem(item);
        }
        JsonArray scheduleLecturesArray = json.getJsonArray(JSON_LECTURES);
        for (int i = 0; i < scheduleLecturesArray.size(); i++) {
            JsonObject lecJSON = scheduleLecturesArray.getJsonObject(i);
            ScheduleItem item = new ScheduleItem(lecJSON.getString("month"), lecJSON.getString("day"), "Lectures", lecJSON.getString("title"), lecJSON.getString("link"), lecJSON.getString("topic"));
            dataManager.addScheduleItem(item);
        }
        JsonArray referencesArray = json.getJsonArray(JSON_REFERENCES);
        for (int i = 0; i < referencesArray.size(); i++) {
            JsonObject refJSON = referencesArray.getJsonObject(i);
            ScheduleItem item = new ScheduleItem(refJSON.getString("month"), refJSON.getString("day"), "References", refJSON.getString("title"), refJSON.getString("link"), refJSON.getString("topic"));
            dataManager.addScheduleItem(item);
        }
        JsonArray scheduleRecitationArray = json.getJsonArray(JSON_RECITATIONS);
        for (int i = 0; i < scheduleRecitationArray.size(); i++) {
            JsonObject recJSON = scheduleRecitationArray.getJsonObject(i);
            ScheduleItem item = new ScheduleItem(recJSON.getString("month"), recJSON.getString("day"), "Recitations", recJSON.getString("title"), recJSON.getString("link"), recJSON.getString("topic"));
            dataManager.addScheduleItem(item);
        }
        JsonArray hwsArray = json.getJsonArray(JSON_SCHEDULE_HWS);
        for (int i = 0; i < hwsArray.size(); i++) {
            JsonObject hwJSON = hwsArray.getJsonObject(i);
            ScheduleItem item = new ScheduleItem(hwJSON.getString("month"), hwJSON.getString("day"), "HW", hwJSON.getString("title"), hwJSON.getString("link"), hwJSON.getString("topic"));
            dataManager.addScheduleItem(item);
        }
        AppGUIModule gui = app.getGUIModule();
        DatePicker startDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_START_DATEPICKER);
        DatePicker endDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_END_DATEPICKER);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        LocalDate startDate= LocalDate.of( year , Integer.parseInt(json.getString("startingMondayMonth")) , Integer.parseInt(json.getString("startingMondayDay")) );
        LocalDate endDate = LocalDate.of( year , Integer.parseInt(json.getString("endingFridayMonth")) , Integer.parseInt(json.getString("endingFridayDay")) );
        startDatePicker.setValue(startDate);
        endDatePicker.setValue(endDate);
       
        dataManager.changeSubject(json.getString(JSON_SUBJECT));
        dataManager.changeNumber(json.getString(JSON_NUMBER));
        dataManager.changeSemester(json.getString(JSON_SEMESTER));
        dataManager.changeYear(json.getString(JSON_YEAR));
        dataManager.changeTitle(json.getString(JSON_TITLE));
        dataManager.updateExportDir();

        dataManager.changeHome(json.getBoolean(JSON_HOME));
        dataManager.changeSyllabus(json.getBoolean(JSON_SYLLABUS));
        dataManager.changeSchedule(json.getBoolean(JSON_SCHEDULE));
        dataManager.changeHWS(json.getBoolean(JSON_HWS));
        
        dataManager.setFaviconPath(json.getString(JSON_FAVICON));
        dataManager.setFavicon();
        dataManager.setNavbarPath(json.getString(JSON_NAVBAR));
        dataManager.setNavbar();
        dataManager.setLeftFooterPath(json.getString(JSON_LEFTFOOTER));
        dataManager.setLeftFooter();
        dataManager.setRightFooterPath(json.getString(JSON_RIGHTFOOTER));
        dataManager.setRightFooter();
        
        dataManager.changeCSS(json.getString(JSON_CSS));
        
        JsonObject instructor = json.getJsonObject(JSON_INSTRUCTOR);
        dataManager.changeInstructorName(instructor.getString(JSON_NAME));
        dataManager.changeInstructorEmail(instructor.getString(JSON_EMAIL));
        dataManager.changeInstructorHome(instructor.getString(JSON_HOMEPAGE));
        dataManager.changeInstructorRoom(instructor.getString(JSON_ROOM));
        dataManager.changeInstructorOfficeHours(instructor.getString(JSON_OFFICEHOURS));
        
        dataManager.changeDescription(json.getString(JSON_DESCRIPTION));
        dataManager.changeTopics(json.getString(JSON_TOPICS));
        dataManager.changePrereq(json.getString(JSON_PREREQ));
        dataManager.changeOutcomes(json.getString(JSON_OUTCOMES));
        dataManager.changeTextbooks(json.getString(JSON_TEXTBOOKS));
        dataManager.changeGradedcomp(json.getString(JSON_GRADEDCOMPONENTS));
        dataManager.changeGradingNote(json.getString(JSON_GRADINGNOTE));
        dataManager.changeAcedemic(json.getString(JSON_ACADEMIC));
        dataManager.changeSpecial(json.getString(JSON_SPECIAL));
        
        String start= json.getString(JSON_STARTTIME);
        int startH=Integer.parseInt(start.substring(0,start.indexOf(":")));
        if (start.contains("p")&&!start.contains("12"))
            startH+=12;
        
        String end= json.getString(JSON_ENDTIME);
        int endH=Integer.parseInt(end.substring(0,end.indexOf(":")));
        if (end.contains("p")&&!end.contains("12"))
            endH+=12;
        
        dataManager.setTimeRanges(startH,endH);
    }
    
    private void loadTAs(CourseSiteData data, JsonObject json, String tas) {
        JsonArray jsonTAArray = json.getJsonArray(tas);
        for (int i = 0; i < jsonTAArray.size(); i++) {
            JsonObject jsonTA = jsonTAArray.getJsonObject(i);
            String name = jsonTA.getString(JSON_NAME);
            String email = jsonTA.getString(JSON_EMAIL);
            TAType type = TAType.valueOf(jsonTA.getString(JSON_TYPE));
            TeachingAssistantPrototype ta = new TeachingAssistantPrototype(name, email, type);
            data.addTA(ta);
        }     
    }
      
    // HELPER METHOD FOR LOADING DATA FROM A JSON FORMAT
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
	InputStream is = new FileInputStream(jsonFilePath);
	JsonReader jsonReader = Json.createReader(is);
	JsonObject json = jsonReader.readObject();
	jsonReader.close();
	is.close();
	return json;
    }

    @Override
    public void saveData(AppDataComponent data, String filePath) throws IOException {
	CourseSiteData dataManager = (CourseSiteData)data;
	JsonArrayBuilder gradTAsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder undergradTAsArrayBuilder = Json.createArrayBuilder();
	Iterator<TeachingAssistantPrototype> tasIterator = dataManager.teachingAssistantsIterator();
        while (tasIterator.hasNext()) {
            TeachingAssistantPrototype ta = tasIterator.next();
	    JsonObject taJson = Json.createObjectBuilder()
		    .add(JSON_NAME, ta.getName())
		    .add(JSON_EMAIL, ta.getEmail())
                    .add(JSON_TYPE, ta.getType().toString()).build();
            if (ta.getType().equals(TAType.Graduate.toString()))
                gradTAsArrayBuilder.add(taJson);
            else
                undergradTAsArrayBuilder.add(taJson);
	}
        JsonArray gradTAsArray = gradTAsArrayBuilder.build();
	JsonArray undergradTAsArray = undergradTAsArrayBuilder.build();

	// NOW BUILD THE OFFICE HOURS JSON OBJCTS TO SAVE
	JsonArrayBuilder officeHoursArrayBuilder = Json.createArrayBuilder();
        Iterator<TimeSlot> timeSlotsIterator = dataManager.officeHoursIterator();
        while (timeSlotsIterator.hasNext()) {
            TimeSlot timeSlot = timeSlotsIterator.next();
            for (int i = 0; i < TimeSlot.DayOfWeek.values().length; i++) {
                TimeSlot.DayOfWeek dow = TimeSlot.DayOfWeek.values()[i];
                tasIterator = timeSlot.getTAsIterator(dow);
                while (tasIterator.hasNext()) {
                    TeachingAssistantPrototype ta = tasIterator.next();
                    JsonObject tsJson = Json.createObjectBuilder()
                        .add(JSON_START_TIME, timeSlot.getStartTime().replace(":", "_"))
                        .add(JSON_DAY_OF_WEEK, dow.toString())
                        .add(JSON_NAME, ta.getName()).build();
                    officeHoursArrayBuilder.add(tsJson);
                }
            }
	}
	JsonArray officeHoursArray = officeHoursArrayBuilder.build();
        
        JsonObject instructor = Json.createObjectBuilder()
                .add(JSON_NAME, dataManager.getInstructorName())
                .add(JSON_EMAIL, dataManager.getInstructorEmail())
                .add(JSON_ROOM, dataManager.getInstructorRoom())
                .add(JSON_HOMEPAGE, dataManager.getInstructorHomepage())
                .add(JSON_OFFICEHOURS, dataManager.getInstructorOfficeHours())
                .build();
        
        JsonArrayBuilder lecturesSectionsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder labsSectionsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder recitationSectionsArrayBuilder = Json.createArrayBuilder();
	Iterator<Lecture> lectureIterator = dataManager.lectureIterator();
	Iterator<Recitation> recitationIterator = dataManager.recitationIterator();
	Iterator<Lab> labIterator = dataManager.labIterator();

        while (lectureIterator.hasNext()) {
            Lecture lecture = lectureIterator.next();
	    JsonObject lectureJSON = Json.createObjectBuilder()
		    .add(JSON_SECTION, ""+lecture.getSection())
		    .add(JSON_DAYS, ""+lecture.getDays())
                    .add(JSON_TIME, lecture.getTime())
                    .add(JSON_ROOM, lecture.getRoom())
                    .build();
                lecturesSectionsArrayBuilder.add(lectureJSON);
	}
        JsonArray lecturesSectionArray = lecturesSectionsArrayBuilder.build();

        while (recitationIterator.hasNext()) {
            Recitation recitation = recitationIterator.next();
	    JsonObject recitationJSON = Json.createObjectBuilder()
		    .add(JSON_SECTION, ""+recitation.getSection())
		    .add(JSON_DAYTIME, ""+recitation.getDaytime())
                    .add(JSON_LOCATION, recitation.getRoom())
                    .add(JSON_TA1, recitation.getTaone())
                    .add(JSON_TA2, recitation.getTatwo())
                    .build();
                recitationSectionsArrayBuilder.add(recitationJSON);
	}
        JsonArray recitationSectionArray = recitationSectionsArrayBuilder.build();
        
        while (labIterator.hasNext()) {
            Lab lab = labIterator.next();
	    JsonObject labJSON = Json.createObjectBuilder()
		    .add(JSON_SECTION, ""+lab.getSection())
		    .add(JSON_DAYTIME, ""+lab.getDaytime())
                    .add(JSON_LOCATION, lab.getRoom())
                    .add(JSON_TA1, lab.getTaone())
                    .add(JSON_TA2, lab.getTatwo())
                    .build();
                labsSectionsArrayBuilder.add(labJSON);
	}
        JsonArray labSectionArray = labsSectionsArrayBuilder.build();
        
        
        JsonArrayBuilder holidaysArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder lecturesArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder referencesArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder recitationsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder hwsArrayBuilder = Json.createArrayBuilder();
	Iterator<ScheduleItem> scheduleIterator = dataManager.scheduleIterator();
        while (scheduleIterator.hasNext()) {
            ScheduleItem sc = scheduleIterator.next();
            LocalDate date = LocalDate.parse(sc.getDate());
	    JsonObject scheduleJson = Json.createObjectBuilder()
		    .add(JSON_MONTH, ""+date.getMonthValue())
		    .add(JSON_DAY, ""+date.getDayOfMonth())
                    .add(JSON_TITLE, sc.getTitle())
                    .add(JSON_LINK, sc.getLink())
                    .add(JSON_TOPIC, sc.getTopic())
                    .build();
            if (sc.getType().equals("Holidays"))
                holidaysArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("Lectures"))
                lecturesArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("References"))
                referencesArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("Recitations"))
                recitationsArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("HW"))
                hwsArrayBuilder.add(scheduleJson);
	}
        JsonArray holidayArray = holidaysArrayBuilder.build();
        JsonArray lecturesArray = lecturesArrayBuilder.build();
        JsonArray referencesArray = referencesArrayBuilder.build();
        JsonArray recitationsArray = recitationsArrayBuilder.build();
        JsonArray hwArray = hwsArrayBuilder.build();
        AppGUIModule gui = app.getGUIModule();
        DatePicker startDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_START_DATEPICKER);
        DatePicker endDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_END_DATEPICKER);
        
        
	// THEN PUT IT ALL TOGETHER IN A JsonObject
	JsonObject dataManagerJSO = Json.createObjectBuilder()
                .add(JSON_SUBJECT, ""+dataManager.getSubject())
                .add(JSON_NUMBER, ""+dataManager.getNumber())
                .add(JSON_SEMESTER, ""+dataManager.getSemester())
                .add(JSON_YEAR, ""+dataManager.getYear())
                .add(JSON_TITLE, ""+dataManager.getTitle())
                .add(JSON_HOME, dataManager.getHome())
                .add(JSON_SYLLABUS, dataManager.getSyllabus())
                .add(JSON_SCHEDULE, dataManager.getSchedule())
                .add(JSON_HWS, dataManager.getHWS())
                .add(JSON_FAVICON,""+dataManager.getFaviconPath())
                .add(JSON_NAVBAR, "" + dataManager.getNavbarPath())
                .add(JSON_LEFTFOOTER, "" + dataManager.getLeftFooterPath())
                .add(JSON_RIGHTFOOTER, "" + dataManager.getRightFooterPath())
                .add(JSON_CSS, dataManager.getCSS())
                .add(JSON_INSTRUCTOR, instructor)
                .add(JSON_DESCRIPTION, "" + dataManager.getDescription())
                .add(JSON_TOPICS, "" + dataManager.getTopics())
                .add(JSON_PREREQ, "" + dataManager.getPrereq())
                .add(JSON_OUTCOMES, "" + dataManager.getOutcomes())
                .add(JSON_TEXTBOOKS, "" + dataManager.getTextbooks())
                .add(JSON_GRADEDCOMPONENTS, "" + dataManager.getGradedcomp())
                .add(JSON_GRADINGNOTE, "" + dataManager.getGradingNote())
                .add(JSON_ACADEMIC, "" + dataManager.getAcedemic())
                .add(JSON_SPECIAL, "" + dataManager.getSpecial())
		.add(JSON_START_HOUR, "" + 8)
		.add(JSON_END_HOUR, "" + 23)
                .add(JSON_STARTTIME, ""+dataManager.getStartTime())
                .add(JSON_ENDTIME, ""+dataManager.getEndTime())
                .add(JSON_GRAD_TAS, gradTAsArray)
                .add(JSON_UNDERGRAD_TAS, undergradTAsArray)
                .add(JSON_OFFICE_HOURS, officeHoursArray)
                .add(JSON_SECTIONS_LECTURES, lecturesSectionArray)
                .add(JSON_LABS, labSectionArray)
                .add(JSON_SECTIONS_RECITATIONS, recitationSectionArray)
                .add(JSON_STARTINGMONDAYMONTH, "" + startDatePicker.getValue().getMonthValue())
                .add(JSON_STARTINGMONDAYDAY, "" + startDatePicker.getValue().getDayOfMonth())
                .add(JSON_ENDINGFRIDAYMONTH, "" + endDatePicker.getValue().getMonthValue())
                .add(JSON_ENDINGFRIDAYDAY, "" + endDatePicker.getValue().getDayOfMonth())
                .add(JSON_HOLIDAYS, holidayArray)
                .add(JSON_LECTURES, lecturesArray)
                .add(JSON_REFERENCES, referencesArray)
                .add(JSON_RECITATIONS, recitationsArray)
                .add(JSON_SCHEDULE_HWS, hwArray)
		.build();
	
	// AND NOW OUTPUT IT TO A JSON FILE WITH PRETTY PRINTING
	Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	StringWriter sw = new StringWriter();
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(dataManagerJSO);
	jsonWriter.close();

	// INIT THE WRITER
	OutputStream os = new FileOutputStream(filePath);
	JsonWriter jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(dataManagerJSO);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(filePath);
	pw.write(prettyPrinted);
	pw.close();
    }
    
    // IMPORTING/EXPORTING DATA IS USED WHEN WE READ/WRITE DATA IN AN
    // ADDITIONAL FORMAT USEFUL FOR ANOTHER PURPOSE, LIKE ANOTHER APPLICATION

    @Override
    public void importData(AppDataComponent data, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void copyFolder(File src, File dest)
    	throws IOException{
    	if(src.isDirectory()){
    		if(!dest.exists()){
    		   dest.mkdir();
    		}
    		String files[] = src.list();
    		for (String file : files) {
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   copyFolder(srcFile,destFile);
    		}
    	}else{
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
    	        byte[] buffer = new byte[1024];
    	        int length;
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
    	        in.close();
    	        out.close();
    	}
    }
    @Override
    public void exportData(AppDataComponent data, String filePath) throws IOException {
        CourseSiteData dataManager = (CourseSiteData) data;
        String exportPath=dataManager.getExportdir();
        String templatePath="./export/template";
        File srcDir = new File(templatePath);
        File destDir = new File(exportPath);
        System.out.println(exportPath);
        if (!destDir.exists()) {
            Files.createDirectories(Paths.get(destDir.getPath()));
        }
        try {
                copyFolder(srcDir, destDir);
            } catch (IOException e) {
        }
        
	JsonArrayBuilder gradTAsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder undergradTAsArrayBuilder = Json.createArrayBuilder();
	Iterator<TeachingAssistantPrototype> tasIterator = dataManager.teachingAssistantsIterator();
        while (tasIterator.hasNext()) {
            TeachingAssistantPrototype ta = tasIterator.next();
	    JsonObject taJson = Json.createObjectBuilder()
		    .add(JSON_NAME, ta.getName())
		    .add(JSON_EMAIL, ta.getEmail())
                    .add(JSON_TYPE, ta.getType().toString()).build();
            if (ta.getType().equals(TAType.Graduate.toString()))
                gradTAsArrayBuilder.add(taJson);
            else
                undergradTAsArrayBuilder.add(taJson);
	}
        JsonArray gradTAsArray = gradTAsArrayBuilder.build();
	JsonArray undergradTAsArray = undergradTAsArrayBuilder.build();

	JsonArrayBuilder officeHoursArrayBuilder = Json.createArrayBuilder();
        Iterator<TimeSlot> timeSlotsIterator = dataManager.officeHoursIterator();
        while (timeSlotsIterator.hasNext()) {
            TimeSlot timeSlot = timeSlotsIterator.next();
            for (int i = 0; i < TimeSlot.DayOfWeek.values().length; i++) {
                TimeSlot.DayOfWeek dow = TimeSlot.DayOfWeek.values()[i];
                tasIterator = timeSlot.getTAsIterator(dow);
                while (tasIterator.hasNext()) {
                    TeachingAssistantPrototype ta = tasIterator.next();
                    JsonObject tsJson = Json.createObjectBuilder()
                        .add(JSON_START_TIME, timeSlot.getStartTime().replace(":", "_"))
                        .add(JSON_DAY_OF_WEEK, dow.toString())
                        .add(JSON_NAME, ta.getName()).build();
                    officeHoursArrayBuilder.add(tsJson);
                }
            }
	}
	JsonArray officeHoursArray = officeHoursArrayBuilder.build();
        
        JsonReader jsonReader = Json.createReader(new StringReader(dataManager.getInstructorOfficeHours()));
        JsonArray instructorHours = jsonReader.readArray();
        jsonReader.close();
        
        JsonObject instructor = Json.createObjectBuilder()
                .add(JSON_NAME, dataManager.getInstructorName())
                .add(JSON_EMAIL, dataManager.getInstructorEmail())
                .add(JSON_ROOM, dataManager.getInstructorRoom())
                .add(JSON_HOMEPAGE, dataManager.getInstructorHomepage())
                .add(JSON_OFFICEHOURS, instructorHours)
                .build();
        
        JsonObject dataManagerJSO = Json.createObjectBuilder()
		.add(JSON_START_HOUR, "" + 8)
		.add(JSON_END_HOUR, "" + 23)
                .add(JSON_INSTRUCTOR, instructor)
                .add(JSON_GRAD_TAS, gradTAsArray)
                .add(JSON_UNDERGRAD_TAS, undergradTAsArray)
                .add(JSON_OFFICE_HOURS, officeHoursArray)
                .build();
        
        Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	StringWriter sw = new StringWriter();
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(dataManagerJSO);
	jsonWriter.close();

	// INIT THE WRITER
	OutputStream os = new FileOutputStream(destDir+"/js/OfficeHoursData.json");
	JsonWriter jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(dataManagerJSO);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(destDir+"/js/OfficeHoursData.json");
	pw.write(prettyPrinted);
	pw.close();

        JsonObject favicon=Json.createObjectBuilder()
                .add(JSON_HREF, dataManager.getFaviconPath())
                .add(JSON_SRC, dataManager.getFaviconPath())
                .build();
        JsonObject navbar=Json.createObjectBuilder()
                .add(JSON_HREF, "")
                .add(JSON_SRC, dataManager.getNavbarPath())
                .build();
        JsonObject leftFooter=Json.createObjectBuilder()
                .add(JSON_HREF, "")
                .add(JSON_SRC, dataManager.getLeftFooterPath())
                .build();
        JsonObject rightFooter=Json.createObjectBuilder()
                .add(JSON_HREF, "")
                .add(JSON_SRC, dataManager.getRightFooterPath())
                .build();
                
        JsonObject logos=Json.createObjectBuilder()
                .add(JSON_FAVICON, favicon)
                .add(JSON_NAVBAR, navbar)
                .add(JSON_BOTTOM_LEFT, leftFooter)
                .add(JSON_BOTTOM_RIGHT, rightFooter)
                .build();
        
        JsonArrayBuilder pagesBuilder = Json.createArrayBuilder();
        JsonObject homeJSON = Json.createObjectBuilder()
                        .add(JSON_NAME, "Home")
                        .add(JSON_LINK, "index.html")
                        .build();
        pagesBuilder.add(homeJSON);
        JsonObject syllabusJSON = Json.createObjectBuilder()
                        .add(JSON_NAME, "Syllabus")
                        .add(JSON_LINK, "syllabus.html")
                        .build();
        pagesBuilder.add(syllabusJSON);
        JsonObject scheduleJSON = Json.createObjectBuilder()
                        .add(JSON_NAME, "Schedule")
                        .add(JSON_LINK, "schedule.html")
                        .build();
        pagesBuilder.add(scheduleJSON);
        JsonObject hwsJSON = Json.createObjectBuilder()
                        .add(JSON_NAME, "HWs")
                        .add(JSON_LINK, "hws.html")
                        .build();
        pagesBuilder.add(hwsJSON);
        
        JsonArray pagesArray = pagesBuilder.build();         
        
        JsonObject pageData = Json.createObjectBuilder()
                .add(JSON_SUBJECT, ""+dataManager.getSubject())
                .add(JSON_NUMBER, ""+dataManager.getNumber())
                .add(JSON_SEMESTER, ""+dataManager.getSemester())
                .add(JSON_YEAR, ""+dataManager.getYear())
                .add(JSON_TITLE, ""+dataManager.getTitle())
                .add(JSON_LOGOS, logos)
                .add(JSON_INSTRUCTOR, instructor)
                .add(JSON_PAGES,pagesArray)
		.build();
	
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	writerFactory = Json.createWriterFactory(properties);
	sw = new StringWriter();
	jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(pageData);
	jsonWriter.close();

	// INIT THE WRITER
	os = new FileOutputStream(destDir+"/js/PageData.json");
	jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(pageData);
	prettyPrinted = sw.toString();
	pw = new PrintWriter(destDir+"/js/PageData.json");
	pw.write(prettyPrinted);
	pw.close();
        
        
        JsonArrayBuilder holidaysArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder lecturesArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder referencesArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder recitationsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder hwsArrayBuilder = Json.createArrayBuilder();
	Iterator<ScheduleItem> scheduleIterator = dataManager.scheduleIterator();
        while (scheduleIterator.hasNext()) {
            ScheduleItem sc = scheduleIterator.next();
            LocalDate date = LocalDate.parse(sc.getDate());
	    JsonObject scheduleJson = Json.createObjectBuilder()
		    .add(JSON_MONTH, ""+date.getMonthValue())
		    .add(JSON_DAY, ""+date.getDayOfMonth())
                    .add(JSON_TITLE, sc.getTitle())
                    .add(JSON_LINK, sc.getLink())
                    .add(JSON_TOPIC, sc.getTopic())
                    .build();
            if (sc.getType().equals("Holidays"))
                holidaysArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("Lectures"))
                lecturesArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("References"))
                referencesArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("Recitations"))
                recitationsArrayBuilder.add(scheduleJson);
            else if (sc.getType().equals("HW"))
                hwsArrayBuilder.add(scheduleJson);
	}
        JsonArray holidayArray = holidaysArrayBuilder.build();
        JsonArray lecturesArray = lecturesArrayBuilder.build();
        JsonArray referencesArray = referencesArrayBuilder.build();
        JsonArray recitationsArray = recitationsArrayBuilder.build();
        JsonArray hwArray = hwsArrayBuilder.build();
        AppGUIModule gui = app.getGUIModule();
        DatePicker startDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_START_DATEPICKER);
        DatePicker endDatePicker = (DatePicker) gui.getGUINode(CSG_SCHEDULE_END_DATEPICKER);
        JsonObject scheduleData = Json.createObjectBuilder()
                .add(JSON_STARTINGMONDAYMONTH, ""+startDatePicker.getValue().getMonthValue())
                .add(JSON_STARTINGMONDAYDAY, ""+startDatePicker.getValue().getDayOfMonth())
                .add(JSON_ENDINGFRIDAYMONTH, ""+endDatePicker.getValue().getMonthValue())
                .add(JSON_ENDINGFRIDAYDAY, ""+endDatePicker.getValue().getDayOfMonth())
                .add(JSON_HOLIDAYS, holidayArray)
                .add(JSON_LECTURES, lecturesArray)
                .add(JSON_REFERENCES, referencesArray)
                .add(JSON_RECITATIONS,recitationsArray)
                .add(JSON_HWS,hwArray)
		.build();
	
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	writerFactory = Json.createWriterFactory(properties);
	sw = new StringWriter();
	jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(scheduleData);
	jsonWriter.close();

	// INIT THE WRITER
	os = new FileOutputStream(destDir+"/js/ScheduleData.json");
	jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(scheduleData);
	prettyPrinted = sw.toString();
	pw = new PrintWriter(destDir+"/js/ScheduleData.json");
	pw.write(prettyPrinted);
	pw.close();
        
        
        JsonArrayBuilder lecturesSectionsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder labsSectionsArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder recitationSectionsArrayBuilder = Json.createArrayBuilder();
	Iterator<Lecture> lectureIterator = dataManager.lectureIterator();
	Iterator<Recitation> recitationIterator = dataManager.recitationIterator();
	Iterator<Lab> labIterator = dataManager.labIterator();

        while (lectureIterator.hasNext()) {
            Lecture lecture = lectureIterator.next();
	    JsonObject lectureJSON = Json.createObjectBuilder()
		    .add(JSON_SECTION, ""+lecture.getSection())
		    .add(JSON_DAYS, ""+lecture.getDays())
                    .add(JSON_TIME, lecture.getTime())
                    .add(JSON_ROOM, lecture.getRoom())
                    .build();
                lecturesSectionsArrayBuilder.add(lectureJSON);
	}
        JsonArray lecturesSectionArray = lecturesSectionsArrayBuilder.build();

        while (recitationIterator.hasNext()) {
            Recitation recitation = recitationIterator.next();
	    JsonObject recitationJSON = Json.createObjectBuilder()
		    .add(JSON_SECTION, ""+recitation.getSection())
		    .add(JSON_DAYTIME, ""+recitation.getDaytime())
                    .add(JSON_LOCATION, recitation.getRoom())
                    .add(JSON_TA1, recitation.getTaone())
                    .add(JSON_TA2, recitation.getTatwo())
                    .build();
                recitationSectionsArrayBuilder.add(recitationJSON);
	}
        JsonArray recitationSectionArray = recitationSectionsArrayBuilder.build();
        
        while (labIterator.hasNext()) {
            Lab lab = labIterator.next();
	    JsonObject labJSON = Json.createObjectBuilder()
		    .add(JSON_SECTION, ""+lab.getSection())
		    .add(JSON_DAYTIME, ""+lab.getDaytime())
                    .add(JSON_LOCATION, lab.getRoom())
                    .add(JSON_TA1, lab.getTaone())
                    .add(JSON_TA2, lab.getTatwo())
                    .build();
                labsSectionsArrayBuilder.add(labJSON);
	}
        JsonArray labSectionArray = labsSectionsArrayBuilder.build();
        JsonObject sectionsData = Json.createObjectBuilder()
                .add(JSON_LECTURES, lecturesSectionArray)
                .add(JSON_LABS, labSectionArray)
                .add(JSON_RECITATIONS, recitationSectionArray)
		.build();
	
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	writerFactory = Json.createWriterFactory(properties);
	sw = new StringWriter();
	jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(sectionsData);
	jsonWriter.close();

	// INIT THE WRITER
	os = new FileOutputStream(destDir+"/js/SectionsData.json");
	jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(sectionsData);
	prettyPrinted = sw.toString();
	pw = new PrintWriter(destDir+"/js/SectionsData.json");
	pw.write(prettyPrinted);
	pw.close();
        
        jsonReader = Json.createReader(new StringReader(dataManager.getTopics()));
        JsonArray topics = jsonReader.readArray();
        jsonReader.close();
        jsonReader = Json.createReader(new StringReader(dataManager.getOutcomes()));
        JsonArray outcomes = jsonReader.readArray();
        jsonReader.close();
        jsonReader = Json.createReader(new StringReader(dataManager.getTextbooks()));
        JsonArray textbooks = jsonReader.readArray();
        jsonReader.close();
        jsonReader = Json.createReader(new StringReader(dataManager.getGradedcomp()));
        JsonArray gradedcomp = jsonReader.readArray();
        jsonReader.close();
        
        JsonObject syllabusData = Json.createObjectBuilder()
                .add(JSON_DESCRIPTION, "" + dataManager.getDescription())
                .add(JSON_TOPICS, topics)
                .add(JSON_PREREQUISITES, "" + dataManager.getPrereq())
                .add(JSON_OUTCOMES, outcomes)
                .add(JSON_TEXTBOOKS, textbooks)
                .add(JSON_GRADEDCOMPONENTSX, gradedcomp)
                .add(JSON_GRADINGNOTEX, dataManager.getGradingNote())
                .add(JSON_ACADEMICDISHONESTY, dataManager.getAcedemic())
                .add(JSON_SPECIALASSISTANCE, dataManager.getSpecial())
                .build();

        properties.put(JsonGenerator.PRETTY_PRINTING, true);
        writerFactory = Json.createWriterFactory(properties);
        sw = new StringWriter();
        jsonWriter = writerFactory.createWriter(sw);
        jsonWriter.writeObject(syllabusData);
        jsonWriter.close();

        // INIT THE WRITER
        os = new FileOutputStream(destDir + "/js/SyllabusData.json");
        jsonFileWriter = Json.createWriter(os);
        jsonFileWriter.writeObject(syllabusData);
        prettyPrinted = sw.toString();
        pw = new PrintWriter(destDir + "/js/SyllabusData.json");
        pw.write(prettyPrinted);
        pw.close();
        
        AppWebDialog dialog = new AppWebDialog(app);
        try {
            //dialog.showInternetDialog("http://127.0.0.1:8887/index.html");
            dialog.showWebDialog(destDir+"/index.html");
        } catch (MalformedURLException murle) {
            AppDialogsFacade.showMessageDialog(app.getGUIModule().getWindow(), HELP_DIALOG_ERROR_TITLE, HELP_DIALOG_ERROR_CONTENT);
        }
    }
}