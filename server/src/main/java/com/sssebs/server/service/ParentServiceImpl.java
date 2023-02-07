package com.sssebs.server.service;

import com.sssebs.server.collection.Parent;
import com.sssebs.server.collection.Student;
import com.sssebs.server.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService{

    @Autowired
    ParentRepository parentRepository;
    @Override
    public List<Parent> getAll() {
        return parentRepository.findAll();
    }
}
