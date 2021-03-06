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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"email"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherEmails {

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "email")
    private List<Email> email;

    public OtherEmails() {
        email = new ArrayList<>();
    }

    public OtherEmails(List<Email> email) {
        super();
        this.email = email;
    }

    @JsonProperty("email")
    public List<Email> getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(List<Email> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OtherEmails{" + "email=" + email + '}';
    }
}