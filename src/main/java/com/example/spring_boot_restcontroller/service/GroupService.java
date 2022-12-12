package com.example.spring_boot_restcontroller.service;

import com.example.spring_boot_restcontroller.dto.request.GroupRequest;
import com.example.spring_boot_restcontroller.dto.response.GroupResponse;

import java.io.IOException;
import java.util.List;

public interface GroupService {

    List<GroupResponse> getAllGroups();

    List<GroupResponse> getAllGroup(Long courseId);

    GroupResponse saveGroup(GroupRequest groupRequest, Long courseId) throws IOException;

    GroupResponse getGroupById(Long id);

    GroupResponse updateGroup(GroupRequest groupRequest, Long id);

    GroupResponse deleteGroup(Long courseId, Long id);

    GroupResponse assignGroup(Long courseId, Long groupId) throws IOException;
}
