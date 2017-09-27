/*
 * RIC One File Bridge
 * Version: 1.0.0 Build 20170604-1
 * Copyright © 2017 New York State Education Department
 * Created At Northeastern Regional Information Center By Daniel Whitehouse
 */

package org.ricone.api.model.xpress;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "phoneNumber"
})
public class OtherPhoneNumbers {

    @JsonProperty("phoneNumber")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PhoneNumber> phoneNumber;

    public OtherPhoneNumbers() {
        phoneNumber = new ArrayList<>();
    }

    public OtherPhoneNumbers(List<PhoneNumber> phoneNumber) {
        super();
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public List<PhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(List<PhoneNumber> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "OtherPhoneNumbers{" +
                "phoneNumber=" + phoneNumber +
                '}';
    }
}