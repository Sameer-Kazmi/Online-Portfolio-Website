package com.example.onlineportfolio.service;

import com.example.onlineportfolio.model.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final List<Project> projects = new ArrayList<>();

    public ProjectService() {

        projects.add(new Project(
                1,
                "Online Portfolio Website",
                "A Spring Boot + Bootstrap based personal portfolio website",
                "Java, Spring Boot, HTML, CSS, JS",
                "Web Development",
                "https://github.com/yourusername/onlineportfolio"
        ));

        projects.add(new Project(
                2,
                "DevOps CI/CD Pipeline",
                "End-to-end CI/CD pipeline using Jenkins, Docker and Kubernetes",
                "Jenkins, Docker, Kubernetes",
                "DevOps",
                "https://github.com/yourusername/devops-pipeline"
        ));

    }

    // Get All Projects
    public List<Project> getAllProjects() {
        return projects;
    }

    // Get Project By ID
    public Project getProjectById(Integer id) {

        for (Project project : projects) {

            if (project.getId().equals(id)) {
                return project;
            }

        }

        return null;
    }

    // Add New Project
    public void addProject(Project project) {

        project.setId(projects.size() + 1);

        projects.add(project);

    }

    // Update Project
    public void updateProject(Integer id, Project updatedProject) {

        for (Project project : projects) {

            if (project.getId().equals(id)) {

                project.setProjectName(updatedProject.getProjectName());
                project.setDescription(updatedProject.getDescription());
                project.setTechnologies(updatedProject.getTechnologies());
                project.setCategory(updatedProject.getCategory());
                project.setProjectLink(updatedProject.getProjectLink());

                return;
            }

        }

    }

    // Delete Project
    public void deleteProject(Integer id) {

        projects.removeIf(project -> project.getId().equals(id));

    }

}