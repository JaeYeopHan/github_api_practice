package com.example.demo.controller;

import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Project;
import com.example.demo.domain.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import service.GithubLookUpService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    private ProjectDao projectDao;

    @Autowired
    public ProjectController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Autowired
    private GithubLookUpService service;

    @PostMapping("/prj")
    public String pages(String projectName, Model model) {
        logger.debug("pages::prjName: {}", projectName);
//        Test data
//        List<Project> projects = new ArrayList<>();
//        projects.add(new Project("Mafia", "2017년 1학기 휴먼 디자인 프로젝트 Respository"));
//        projects.add(new Project("React-docs-tutorial", "React 라이브러리 튜토리얼 문서 Respository"));
        List<Repo> projects = service.getRepos("", "");
        model.addAttribute("projects", projects);
        return "index";
    }
}
