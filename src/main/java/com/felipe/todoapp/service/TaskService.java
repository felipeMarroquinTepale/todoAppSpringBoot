package com.felipe.todoapp.service;

import com.felipe.todoapp.mapper.TaskInDTOToTask;
import com.felipe.todoapp.persistence.entity.Task;
import com.felipe.todoapp.persistence.repository.TaskRepository;
import com.felipe.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    //Crear unaa tareas
    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}
