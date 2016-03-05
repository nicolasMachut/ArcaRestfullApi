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
    @JsonProperty
    private String value;
    @JsonProperty
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

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString () {
        return "Hosting [id=" + timestamp + ", name=" + country + "]";
        //return "timestamp : " + timestamp + ", value : " + value + ", country : " + country;
    }
}
