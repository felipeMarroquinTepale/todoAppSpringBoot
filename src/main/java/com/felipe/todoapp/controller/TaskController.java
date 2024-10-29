package com.felipe.todoapp.controller;

import com.felipe.todoapp.persistence.entity.Task;
import com.felipe.todoapp.service.TaskService;
import com.felipe.todoapp.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

}
