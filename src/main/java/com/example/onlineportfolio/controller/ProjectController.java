package com.example.onlineportfolio.controller;

import com.example.onlineportfolio.model.Project;
import com.example.onlineportfolio.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    // ==========================
    // GET ALL PROJECTS
    // ==========================
    @GetMapping
    public List<Project> getProjects() {

        return service.getAllProjects();

    }

    // ==========================
    // GET PROJECT BY ID
    // ==========================
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id) {

        return service.getProjectById(id);

    }

    // ==========================
    // ADD NEW PROJECT
    // ==========================
    @PostMapping
    public String addProject(@RequestBody Project project) {

        service.addProject(project);

        return "Project Added Successfully";

    }

    // ==========================
    // UPDATE PROJECT
    // ==========================
    @PutMapping("/{id}")
    public String updateProject(@PathVariable Integer id,
                                 @RequestBody Project project) {

        service.updateProject(id, project);

        return "Project Updated Successfully";

    }

    // ==========================
    // DELETE PROJECT
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Integer id) {

        service.deleteProject(id);

        return "Project Deleted Successfully";

    }

}