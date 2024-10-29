package com.felipe.todoapp.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data //Proporciona los getter y setter
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDateTime eta;


}
