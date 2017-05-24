package com.example.demo.controller;

import com.example.demo.domain.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.GithubLookUpService;

import java.util.List;

/**
 * Created by Jbee on 2017. 5. 24..
 */
@Controller
public class IssueController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private GithubLookUpService service;

    @GetMapping("{prj}/issues")
    public String issues(@PathVariable String prj) {
        logger.debug("issues::prj: {}", prj);
        List<Repo> repos = service.getRepos("", "");
        Repo repo = repos.get(0);
        logger.debug("issues::repo.getName(): {}", repo.getName());
        return "index";
    }
}
