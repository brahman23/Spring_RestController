package com.example.spring_boot_restcontroller.converter.task;

import com.example.spring_boot_restcontroller.dto.request.TaskRequest;
import com.example.spring_boot_restcontroller.dto.response.TaskResponse;
import com.example.spring_boot_restcontroller.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverterResponse {

    public TaskResponse create(Task task) {
        if (task == null) return null;
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTaskName(task.getTaskName());
        taskResponse.setTaskText(task.getTaskText());
        taskResponse.setDeadline(task.getDeadline());
        return taskResponse;
    }

    public List<TaskResponse> getAll(List<Task> tasks) {
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task t : tasks) {
            taskResponses.add(create(t));
        }
        return taskResponses;
    }
}
