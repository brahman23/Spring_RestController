package com.example.spring_boot_restcontroller.converter.task;

import com.example.spring_boot_restcontroller.dto.request.TaskRequest;
import com.example.spring_boot_restcontroller.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskConverterRequest {

    public Task create(TaskRequest taskRequest) {
        if (taskRequest == null) return null;
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
        return task;
    }

    public void update(Task task, TaskRequest taskRequest) {
        if (taskRequest.getTaskName() != null) {
            task.setTaskName(taskRequest.getTaskName());
        }
        if (taskRequest.getTaskText() != null) {
            task.setTaskText(taskRequest.getTaskText());
        }
        if (taskRequest.getDeadline() != null) {
            task.setDeadline(taskRequest.getDeadline());
        }
    }
}
