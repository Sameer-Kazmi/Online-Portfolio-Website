package com.example.onlineportfolio.model;

public class Project {

    private Integer id;
    private String projectName;
    private String description;
    private String technologies;
    private String category;
    private String projectLink;

    public Project() {
    }

    public Project(Integer id, String projectName, String description,
                    String technologies, String category, String projectLink) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.technologies = technologies;
        this.category = category;
        this.projectLink = projectLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}