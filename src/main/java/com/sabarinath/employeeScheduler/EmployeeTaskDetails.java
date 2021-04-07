package com.sabarinath.employeeScheduler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="SCHEDULED_TASKS")
public class EmployeeTaskDetails {

    @Id
    @Column(name="EMPLOYEEID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    @Column(name="STARTDATE")
    private java.util.Date startdate;

    @Column(name="ENDDATE")
    private java.util.Date enddate;

    @Column(name="TIMEOFTASK")
    private LocalTime timeoftask;

    @Column(name="DURATION")
    private int duration;

    @Column(name="IS_REPEAT")
    private boolean is_repeat;

    @Column(name="FREQUENCY")
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(name="NAMEOFEMP")
    private String nameofemp;

    public EmployeeTaskDetails() {}

    public EmployeeTaskDetails (int employeeid, java.util.Date startdate, java.util.Date enddate, LocalTime timeoftask, int duration, boolean is_repeat, Frequency frequency, String nameofemp )
    {
        this.setEmployeeid(employeeid);
        this.setDuration(duration);
        this.setStartdate(startdate);
        this.setEnddate(enddate);
        this.setTimeoftask(timeoftask);
        this.setFrequency(frequency);
        this.setIs_repeat(is_repeat);
        this.setNameofemp(nameofemp);
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public java.util.Date getStartdate() {
        return startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public LocalTime getTimeoftask() {
        return timeoftask;
    }

    public void setTimeoftask(LocalTime timeoftask) {
        this.timeoftask = timeoftask;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIs_repeat(boolean is_repeat) {
        this.is_repeat = is_repeat;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Frequency getFrequency(){
        return frequency;
    }
    public Boolean getIsRepeat(){
        return  is_repeat;
    }

    public void setNameofemp(String nameofemp) {
        this.nameofemp = nameofemp;
    }

    public String getNameofemp() {
        return nameofemp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", ID='" + employeeid + '\'' +
                ", Start Date=" + startdate + '\'' +
                ", End Date=" + enddate + '\'' +
                ", Time of Task=" + timeoftask + '\'' +
                ", Duration=" + duration + '\'' +
                ", Repeated=" + is_repeat + '\'' +
                ", Frequency=" + frequency + '\'' +
                '}';
}
}
