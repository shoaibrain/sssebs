package com.sssebs.server.service;

import com.sssebs.server.model.Parent;
import com.sssebs.server.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ParentService {
    List<Parent> getAll();

    void addParent(Parent parent);

    void updateParent(Parent parent);

    Optional<Parent> getParent(String parentId);

    Map<String, Object> getAllParentInPage(Integer pageNum, Integer pageSize, String sortBy);

    List<Parent> getAllByExample(Parent parent);
}
