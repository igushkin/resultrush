package com.example.ResultRush.controller;

import com.example.ResultRush.entity.Priority;
import com.example.ResultRush.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priorities")
public class PriorityController {

    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping
    public List<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Priority getPriorityById(@PathVariable Long id) {
        return priorityRepository.findById(id).get();
    }

    @PostMapping
    public Priority createPriority(@RequestBody Priority priority) {
        return priorityRepository.save(priority);
    }

    @PutMapping
    public Priority updatePriority(@RequestBody Priority priority) {
        if (priority.getPriorityId() == null) {
            throw new RuntimeException("Priority id cannot be null");
        }
        return priorityRepository.save(priority);
    }

    @DeleteMapping("/{id}")
    public void deletePriority(@PathVariable Long id) {
        try {
            priorityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException(String.format("Priority with id \'%s\' not found", id));
        }
    }
}
