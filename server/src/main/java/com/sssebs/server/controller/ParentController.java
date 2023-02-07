package com.sssebs.server.controller;

import com.sssebs.server.collection.Parent;
import com.sssebs.server.collection.Student;
import com.sssebs.server.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    ParentService parentService;
    @GetMapping("/")
    public List<Parent> getAllParent() {
        return parentService.getAll();
    }

}
