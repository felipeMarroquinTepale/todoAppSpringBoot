package com.felipe.todoapp.service;

import com.felipe.todoapp.exceptions.ToDoExceptions;
import com.felipe.todoapp.mapper.TaskInDTOToTask;
import com.felipe.todoapp.persistence.entity.Task;
import com.felipe.todoapp.persistence.entity.TaskStatus;
import com.felipe.todoapp.persistence.repository.TaskRepository;
import com.felipe.todoapp.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //obtener todas las tareas
    public List<Task> findAll(){
        return this.repository.findAll();
    }
    //Obtener todas las tareas por estado
    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
