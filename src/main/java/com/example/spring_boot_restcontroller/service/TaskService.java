package com.example.spring_boot_restcontroller.service;

import com.example.spring_boot_restcontroller.dto.request.TaskRequest;
import com.example.spring_boot_restcontroller.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAllTask();

    List<TaskResponse> getAllTask(Long lessonId);

    TaskResponse getTaskById(Long id);

    TaskResponse saveTask(Long lessonId, TaskRequest taskRequest);

    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    TaskResponse deleteTask(Long id);
}
