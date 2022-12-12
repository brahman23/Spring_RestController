package com.example.spring_boot_restcontroller.service.Impl;

import com.example.spring_boot_restcontroller.converter.group.GroupConverterRequest;
import com.example.spring_boot_restcontroller.converter.group.GroupConverterResponse;
import com.example.spring_boot_restcontroller.dto.request.GroupRequest;
import com.example.spring_boot_restcontroller.dto.response.GroupResponse;
import com.example.spring_boot_restcontroller.entity.Course;
import com.example.spring_boot_restcontroller.entity.Group;
import com.example.spring_boot_restcontroller.repository.CourseRepository;
import com.example.spring_boot_restcontroller.repository.GroupRepository;
import com.example.spring_boot_restcontroller.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final GroupConverterRequest groupConverterRequest;
    private final GroupConverterResponse groupConverterResponse;

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupConverterResponse.getAll(groupRepository.findAll());
    }

    @Override
    public List<GroupResponse> getAllGroup(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return groupConverterResponse.getAll(course.getGroups());

    }

    @Override
    public GroupResponse saveGroup(GroupRequest groupRequest, Long courseId) throws IOException {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupConverterRequest.create(groupRequest);
        course.addGroup(group);
        group.addCourse(course);
        groupRepository.save(group);
        return groupConverterResponse.create(group);
    }


    @Override
    public GroupResponse getGroupById(Long id) {
        Group group = groupRepository.findById(id).get();
        return groupConverterResponse.create(group);
    }

    @Override
    public GroupResponse updateGroup(GroupRequest groupRequest, Long id) {
        Group group = groupRepository.findById(id).get();
        groupConverterRequest.update(group, groupRequest);
        return groupConverterResponse.create(groupRepository.save(group));

    }

    @Override
    public GroupResponse deleteGroup(Long courseId, Long id) {
        Group group = groupRepository.findById(id).get();
        groupRepository.delete(group);
        return groupConverterResponse.create(group);
    }

    @Override
    public GroupResponse assignGroup(Long courseId, Long id) throws IOException {
        Group group = groupRepository.findById(id).get();
        Course course = courseRepository.findById(courseId).get();
        if (course.getGroups() != null) {
            for (Group g : course.getGroups()) {
                if (g.getId() == id) {
                    throw new IOException("This group already exists!");
                }
            }
        }
        group.addCourse(course);
        course.addGroup(group);
        courseRepository.save(course);
        groupRepository.save(group);
        return groupConverterResponse.create(group);
    }
}
