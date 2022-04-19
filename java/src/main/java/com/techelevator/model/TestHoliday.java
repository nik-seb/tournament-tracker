package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "status",
        "error",
        "warning",
        "requests",
        "holidays"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestHoliday {

    public Integer status;

    private List<Holiday> holidayList;

    private String error;

    private String warning;


    public TestHoliday(Integer status, List<Holiday> holidayList, String error, String warning) {
        this.status = status;
        this.holidayList = holidayList;
        this.error = error;
        this.warning = warning;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Holiday> getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(List<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
}
