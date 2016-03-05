package com.arca.app.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by machu on 03/03/2016.
 */

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.NONE)
public class Line {

    @JsonProperty
    private String timestamp;

    private String value;

    private String country;

    public String getTimestamp() {
        return timestamp;
    }

    public String getCountry() {
        return country;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString () {
        return "timestamp : " + timestamp + ", value : " + value + ", country : " + country;
    }
}
