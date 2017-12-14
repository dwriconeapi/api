package org.ricone.api.xPress.request.changesSince;

import org.ricone.api.core.model.EventLog;
import org.ricone.api.core.model.EventObject;
import org.ricone.api.core.model.EventType;
import org.ricone.api.xPress.model.*;
import org.ricone.api.xPress.request.xCalendar.XCalendarMapper;
import org.ricone.api.xPress.request.xContact.XContactMapper;
import org.ricone.api.xPress.request.xCourse.XCourseMapper;
import org.ricone.api.xPress.request.xLea.XLeaMapper;
import org.ricone.api.xPress.request.xRoster.XRosterMapper;
import org.ricone.api.xPress.request.xSchool.XSchoolMapper;
import org.ricone.api.xPress.request.xStaff.XStaffMapper;
import org.ricone.api.xPress.request.xStudent.XStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("XEventLogMapper")
public class XEventLogMapper {

    @Autowired
    private XLeaMapper xLeaMapper;

    @Autowired
    private XSchoolMapper xSchoolMapper;

    @Autowired
    private XCalendarMapper xCalendarMapper;

    @Autowired
    private XCourseMapper xCourseMapper;

    @Autowired
    private XRosterMapper xRosterMapper;

    @Autowired
    private XStaffMapper xStaffMapper;

    @Autowired
    private XStudentMapper xStudentMapper;

    @Autowired
    private XContactMapper xContactMapper;

    public XChangesSinceResponse convert(List<EventLog> instance) {
        List<XChangeSince> list = new ArrayList<>();
        for(EventLog eventLog : instance)
        {
            XChangeSince xChangeSince = map(eventLog);
            if (xChangeSince != null) {
                list.add(xChangeSince);
            }
        }

        XChangesSinceResponse response = new XChangesSinceResponse();
        XChangesSince xChangesSince = new XChangesSince();
        xChangesSince.setXChangeSince(list);

        response.setXChangesSince(xChangesSince);
        return response;
    }

    private XChangeSince map(EventLog eventLog) {

        XChangeSince xChangeSince = new XChangeSince();
        xChangeSince.setRefId(eventLog.getEventRefId());
        //xChangeSince.setEventObject(eventLog.getObject());
        xChangeSince.setEventType(eventLog.getEventType());
        xChangeSince.setEventDate(eventLog.getEventTimestamp().toString());

        if(eventLog.getObject().equals(EventObject.LEA)){
            mapXLea(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.SCHOOL)){
            mapXSchool(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.CALENDAR)){
            mapXCalendar(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.COURSE)){
            mapXCourse(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.ROSTER)){
            mapXRoster(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.STAFF)){
            mapXStaff(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.STUDENT)){
            mapXStudent(xChangeSince, eventLog);
        }
        else  if(eventLog.getObject().equals(EventObject.CONTACT)){
            mapXContact(xChangeSince, eventLog);
        }
        return xChangeSince;
    }

    private void mapXLea(XChangeSince xChangeSince, EventLog eventLog) {
        XLea xLea;
        if(eventLog.getLea() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xLea = xLeaMapper.map(eventLog.getLea(), null);
        }
        else {
            xLea = new XLea(eventLog.getObjectRefId());
        }
        xChangeSince.setXLea(xLea);
    }

    private void mapXSchool(XChangeSince xChangeSince, EventLog eventLog) {
        XSchool xSchool;
        if(eventLog.getSchool() != null & !eventLog.getEventType().equals(EventType.DELETE)) {
            xSchool = xSchoolMapper.map(eventLog.getSchool());
        }
        else {
            xSchool = new XSchool(eventLog.getObjectRefId());
        }
        xChangeSince.setXSchool(xSchool);
    }

    private void mapXCalendar(XChangeSince xChangeSince, EventLog eventLog) {
        XCalendar xCalendar;
        if(eventLog.getCalendar() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xCalendar = xCalendarMapper.map(eventLog.getCalendar());
        }
        else {
            xCalendar = new XCalendar(eventLog.getObjectRefId());
        }
        xChangeSince.setXCalendar(xCalendar);
    }

    private void mapXCourse(XChangeSince xChangeSince, EventLog eventLog) {
        XCourse xCourse;
        if(eventLog.getCourse() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xCourse = xCourseMapper.map(eventLog.getCourse());
        }
        else {
            xCourse = new XCourse(eventLog.getObjectRefId());
        }
        xChangeSince.setXCourse(xCourse);
    }

    private void mapXRoster(XChangeSince xChangeSince, EventLog eventLog) {
        XRoster xRoster;
        if(eventLog.getRoster() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xRoster = xRosterMapper.map(eventLog.getRoster());
        }
        else {
            xRoster = new XRoster(eventLog.getObjectRefId());
        }
        xChangeSince.setXRoster(xRoster);
    }

    private void mapXStaff(XChangeSince xChangeSince, EventLog eventLog) {
        XStaff xStaff;
        if(eventLog.getStaff() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xStaff = xStaffMapper.map(eventLog.getStaff());
        }
        else {
            xStaff = new XStaff(eventLog.getObjectRefId());
        }
        xChangeSince.setxStaff(xStaff);
    }

    private void mapXStudent(XChangeSince xChangeSince, EventLog eventLog) {
        XStudent xStudent;
        if(eventLog.getStudent() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xStudent = xStudentMapper.map(eventLog.getStudent());
        }
        else {
            xStudent = new XStudent(eventLog.getObjectRefId());
        }
        xChangeSince.setXStudent(xStudent);
    }

    private void mapXContact(XChangeSince xChangeSince, EventLog eventLog) {
        XContact xContact;
        if(eventLog.getContact() != null && !eventLog.getEventType().equals(EventType.DELETE)) {
            xContact = xContactMapper.map(eventLog.getContact());
        }
        else {
            xContact = new XContact(eventLog.getObjectRefId());
        }
        xChangeSince.setXContact(xContact);
    }
}
