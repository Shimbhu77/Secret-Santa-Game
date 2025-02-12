package com.secret.santa.model;

public class Employee {
    private String employeeName;
    private String employeeEmailId;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmailId() {
        return employeeEmailId;
    }

    public void setEmployeeEmailId(String employeeEmailId) {
        this.employeeEmailId = employeeEmailId;
    }

    public Employee(String employeeName, String employeeEmailId) {
        this.employeeName = employeeName;
        this.employeeEmailId = employeeEmailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeEmailId='" + employeeEmailId + '\'' +
                '}';
    }
}
