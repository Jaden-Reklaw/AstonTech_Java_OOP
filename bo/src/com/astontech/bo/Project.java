package com.astontech.bo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Project extends BaseBO{
    //Params
    private int ProjectId;
    private String ProjectName;
    private String Notes;
    private String StartDate;
    private String EndDate;
    private double Rate;
    private int ClientId;
    private int EntityTypeId;

    //Constructors
    public Project() {}
    public Project(String projectName, String startDate, String endDate) {
        this.setProjectName(projectName);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    //Setters and Getters
    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }



    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    //Custom Method for Project
    public long GetDaysTillCompletion() {
        LocalDate start = LocalDate.parse(this.getStartDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate end = LocalDate.parse(this.getEndDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(start.atStartOfDay(), end.atStartOfDay());
        long diffDays = diff.toDays();
        return diffDays;
    }
}
