package com.sssebs.server.service;

import com.sssebs.server.model.Parent;
import com.sssebs.server.repository.ParentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{
    private static Logger logger = LogManager.getLogger(ParentServiceImpl.class);

    @Autowired
    ParentRepository parentRepository;
    @Override
    public List<Parent> getAll() {
        return parentRepository.findAll();
    }

    @Override
    public void addParent(Parent parent) {
        try {
            parentRepository.insert(parent);
            logger.info("Successfully added Parent");
        } catch (Exception ex) {
            logger.warn("Failed to add new Parent", ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void updateParent(Parent parent) {
        try {
            parentRepository.save(parent);
            logger.info("Successfully updated Parent");
        } catch ( Exception ex) {
            logger.warn("Failed to update Parent information", ex);
            ex.printStackTrace();
        }
    }

    @Override
    public Optional<Parent> getParent(String parentId) {
        return parentRepository.findById(parentId);
    }

    @Override
    public Map<String, Object> getAllParentInPage(Integer pageNum, Integer pageSize, String sortBy) {
        Map<String, Object> response = new HashMap<>();
        Sort sort = Sort.by(sortBy);
        Pageable page = PageRequest.of(pageNum,pageSize,sort);
        Page<Parent> parentPage = parentRepository.findAll(page);
        response.put("data", parentPage.getContent());
        response.put("Total Page",parentPage.getTotalPages());
        response.put("Total Elements", parentPage.getTotalElements());
        response.put("Current Page", parentPage.getNumber());
        return response;
    }

    @Override
    public List<Parent> getAllByExample(Parent parent) {
        Example<Parent> e = Example.of(parent);
        return parentRepository.findAll(e);
    }
}
