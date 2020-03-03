package com.example.springbootproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeData {

    @JsonProperty("data")
    private EmployeeInfo employeeInfo;

    public  EmployeeData() {}

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }
}
