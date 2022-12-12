package com.example.spring_boot_restcontroller.converter.group;

import com.example.spring_boot_restcontroller.dto.request.GroupRequest;
import com.example.spring_boot_restcontroller.entity.Group;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GroupConverterRequest {

    public Group create(GroupRequest groupRequest) {
        if (groupRequest == null) return null;
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setImage(groupRequest.getImage());
        group.setDataOfStart(LocalDate.now());
        return group;
    }

    public void update(Group group, GroupRequest groupRequest) {
        if (groupRequest.getGroupName() != null) {
            group.setGroupName(groupRequest.getGroupName());
        }
        if (groupRequest.getImage() != null) {
            group.setImage(groupRequest.getImage());
        }
        group.setDataOfStart(LocalDate.now());
    }
}
