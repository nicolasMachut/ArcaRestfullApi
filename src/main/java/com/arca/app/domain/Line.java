package com.arca.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

/**
 * Created by machu on 03/03/2016.
 */
public class Line {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("value")
    private String value;

    @JsonProperty("country")
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
}
