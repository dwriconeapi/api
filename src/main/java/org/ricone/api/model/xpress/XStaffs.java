/*
 * RIC One File Bridge
 * Version: 1.0.0 Build 20170604-1
 * Copyright © 2017 New York State Education Department
 * Created At Northeastern Regional Information Center By Daniel Whitehouse
 */

package org.ricone.api.model.xpress;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "xStaff"
})
public class XStaffs {

    @JsonProperty("xStaff")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<XStaff> xStaff;

    public XStaffs() {
        xStaff = new ArrayList<>();
    }

    public XStaffs(List<XStaff> xStaff) {
        super();
        this.xStaff = xStaff;
    }

    @JsonProperty("xStaff")
    public List<XStaff> getXStaff() {
        return xStaff;
    }

    @JsonProperty("xStaff")
    public void setXStaff(List<XStaff> xStaff) {
        this.xStaff = xStaff;
    }

    @Override
    public String toString() {
        return "XStaffs{" +
                "xStaff=" + xStaff +
                '}';
    }
}