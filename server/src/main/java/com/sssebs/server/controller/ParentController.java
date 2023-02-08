package com.sssebs.server.controller;

import com.sssebs.server.model.Parent;
import com.sssebs.server.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    ParentService parentService;
    @GetMapping("/")
    public List<Parent> getAllParent() {
        return parentService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value="/")
    public void addParent(@RequestBody Parent parent) {
        parentService.addParent(parent);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void updateParent(@RequestBody Parent parent){
        parentService.updateParent(parent);
    }

    @RequestMapping("/{parent_id}")
    public Optional<Parent> getParent(@PathVariable String parent_id) {
        return parentService.getParent(parent_id);
    }

    @RequestMapping("/page")
    public Map<String, Object> getAllParentInPage(
            @RequestParam(name="pageNum",defaultValue = "0") Integer pageNum,
            @RequestParam(name="pageSize", defaultValue = "2") Integer pageSize,
            @RequestParam(name="sortBy", defaultValue = "parent_id") String sortBy) {
        return parentService.getAllParentInPage(pageNum, pageSize, sortBy);
    }

    @RequestMapping("/example")
    public List<Parent> getAllParentByExample(@RequestBody Parent parent) {
        return parentService.getAllByExample(parent);
    }

}
