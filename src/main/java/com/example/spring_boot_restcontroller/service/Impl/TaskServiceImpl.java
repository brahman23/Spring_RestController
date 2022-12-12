package com.example.spring_boot_restcontroller.service.Impl;

import com.example.spring_boot_restcontroller.converter.task.TaskConverterRequest;
import com.example.spring_boot_restcontroller.converter.task.TaskConverterResponse;
import com.example.spring_boot_restcontroller.dto.request.TaskRequest;
import com.example.spring_boot_restcontroller.dto.response.TaskResponse;
import com.example.spring_boot_restcontroller.entity.Lesson;
import com.example.spring_boot_restcontroller.entity.Task;
import com.example.spring_boot_restcontroller.repository.LessonRepository;
import com.example.spring_boot_restcontroller.repository.TaskRepository;
import com.example.spring_boot_restcontroller.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final LessonRepository lessonRepository;
    private final TaskRepository taskRepository;
    private final TaskConverterRequest taskConverterRequest;
    private final TaskConverterResponse taskConverterResponse;


    @Override
    public List<TaskResponse> getAllTask() {
        return taskConverterResponse.getAll(taskRepository.findAll());
    }

    @Override
    public List<TaskResponse> getAllTask(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        return taskConverterResponse.getAll(lesson.getTaskList());
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return taskConverterResponse.create(taskRepository.findById(id).get());
    }

    @Override
    public TaskResponse saveTask(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        Task task = taskConverterRequest.create(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return taskConverterResponse.create(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id).get();
        taskConverterRequest.update(task, taskRequest);
        return taskConverterResponse.create(task);
    }

    @Override
    public TaskResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
        return taskConverterResponse.create(task);
    }

}
