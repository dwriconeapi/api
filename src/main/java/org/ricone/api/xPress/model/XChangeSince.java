/*
 * RIC One File Bridge
 * Version: 1.0.0 Build 20170604-1
 * Copyright © 2017 New York State Education Department
 * Created At Northeastern Regional Information Center By Daniel Whitehouse
 */

package org.ricone.api.xPress.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.ricone.api.core.model.EventObject;
import org.ricone.api.core.model.EventType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({"@refId", "eventObject", "eventType", "eventDate", "xLea", "xSchool", "xCalendar", "xCourse", "xRoster", "xStaff", "xStudent", "xContact"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XChangeSince extends XWrapper {

    @JsonProperty("@refId")
    @XmlElement(name = "@refId")
    private String refId;
    @JsonProperty("eventObject")
    @XmlElement(name = "eventObject")
    private EventObject eventObject;
    @JsonProperty("eventType")
    @XmlElement(name = "eventType")
    private EventType eventType;
    @JsonProperty("eventDate")
    @XmlElement(name = "eventDate")
    private String eventDate;
    @JsonProperty("xLea")
    @XmlElement(name = "xLea")
    private XLea xLea;
    @JsonProperty("xSchool")
    @XmlElement(name = "xSchool")
    private XSchool xSchool;
    @JsonProperty("xCalendar")
    @XmlElement(name = "xCalendar")
    private XCalendar xCalendar;
    @JsonProperty("xCourse")
    @XmlElement(name = "xCourse")
    private XCourse xCourse;
    @JsonProperty("xRoster")
    @XmlElement(name = "xRoster")
    private XRoster xRoster;
    @JsonProperty("xStaff")
    @XmlElement(name = "xStaff")
    private XStaff xStaff;
    @JsonProperty("xStudent")
    @XmlElement(name = "xStudent")
    private XStudent xStudent;
    @JsonProperty("xContact")
    @XmlElement(name = "xContact")
    private XContact xContact;

    public XChangeSince() {
    }

    public XChangeSince(String refId, EventObject eventObject, EventType eventType, String eventDate) {
        super();
        this.refId = refId;
        this.eventObject = eventObject;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    @JsonProperty("@refId")
    public String getRefId() {
        return refId;
    }

    @JsonProperty("@refId")
    public void setRefId(String refId) {
        this.refId = refId;
    }

    @JsonProperty("eventObject")
    public EventObject getEventObject() {
        return eventObject;
    }

    @JsonProperty("eventObject")
    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
    }

    @JsonProperty("eventType")
    public EventType getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("eventDate")
    public String getEventDate() {
        return eventDate;
    }

    @JsonProperty("eventDate")
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @JsonProperty("xLea")
    public XLea getXLea() {
        return xLea;
    }

    @JsonProperty("xLea")
    public void setXLea(XLea xLea) {
        this.xLea = xLea;
    }

    @JsonProperty("xSchool")
    public XSchool getXSchool() {
        return xSchool;
    }

    @JsonProperty("xSchool")
    public void setXSchool(XSchool xSchool) {
        this.xSchool = xSchool;
    }

    @JsonProperty("xCalendar")
    public XCalendar getXCalendar() {
        return xCalendar;
    }

    @JsonProperty("xCalendar")
    public void setXCalendar(XCalendar xCalendar) {
        this.xCalendar = xCalendar;
    }

    @JsonProperty("xCourse")
    public XCourse getXCourse() {
        return xCourse;
    }

    @JsonProperty("xCourse")
    public void setXCourse(XCourse xCourse) {
        this.xCourse = xCourse;
    }

    @JsonProperty("xRoster")
    public XRoster getXRoster() {
        return xRoster;
    }

    @JsonProperty("xRoster")
    public void setXRoster(XRoster xRoster) {
        this.xRoster = xRoster;
    }

    @JsonProperty("xStaff")
    public XStaff getxStaff() {
        return xStaff;
    }

    @JsonProperty("xStaff")
    public void setxStaff(XStaff xStaff) {
        this.xStaff = xStaff;
    }

    @JsonProperty("xStudent")
    public XStudent getXStudent() {
        return xStudent;
    }

    @JsonProperty("xStudent")
    public void setXStudent(XStudent xStudent) {
        this.xStudent = xStudent;
    }

    @JsonProperty("xContact")
    public XContact getXContact() {
        return xContact;
    }

    @JsonProperty("xContact")
    public void setXContact(XContact xContact) {
        this.xContact = xContact;
    }

    @Override
    public String toString() {
        return "XChangeSince{" + "refId='" + refId + '\'' + ", eventTObject='" + eventObject + '\'' + ", eventType='" + eventType + '\'' + ", eventDate=" + eventDate + '}';
    }
}