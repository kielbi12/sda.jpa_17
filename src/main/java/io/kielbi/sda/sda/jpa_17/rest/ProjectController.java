package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.entity.Project;
import io.kielbi.sda.sda.jpa_17.repository.ProjectRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects")

public class ProjectController extends AbstractCustomController<Project, Long> {


    public ProjectController(ProjectRepository projectRepository) {
        super(projectRepository);
    }

}
