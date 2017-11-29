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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "xLea"
})
public class XLeaResponse {

    @JsonProperty("xLea")
    private XLea xLea;

    public XLeaResponse() {
    }

    public XLeaResponse(XLea xLea) {
        super();
        this.xLea = xLea;
    }

    @JsonProperty("xLea")
    public XLea getXLea() {
        return xLea;
    }

    @JsonProperty("xLea")
    public void setXLea(XLea xLea) {
        this.xLea = xLea;
    }

    @Override
    public String toString() {
        return "XLeaResponse{" +
                "xLea=" + xLea +
                '}';
    }
}