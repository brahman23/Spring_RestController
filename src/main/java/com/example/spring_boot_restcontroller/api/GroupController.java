package com.example.spring_boot_restcontroller.api;

import com.example.spring_boot_restcontroller.dto.request.GroupRequest;
import com.example.spring_boot_restcontroller.dto.response.GroupResponse;
import com.example.spring_boot_restcontroller.dto.response.StudentResponse;
import com.example.spring_boot_restcontroller.service.GroupService;
import com.example.spring_boot_restcontroller.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final StudentService studentService;

    @GetMapping("/getAllGroup")
    public List<GroupResponse> getAllGroup(){
        return groupService.getAllGroups();
    }

    @GetMapping("/getAllGroupByCourseId/{courseId}")
    public List<GroupResponse> getAllGroupByCourseId(@PathVariable Long courseId){
        return groupService.getAllGroup(courseId);
    }

    @GetMapping("/getGroupById/{id}")
    public GroupResponse getGroupById(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @PostMapping("/{courseId}/saveGroup")
    public  GroupResponse saveGroup(@PathVariable Long courseId, @RequestBody GroupRequest groupRequest) throws IOException{
        return groupService.saveGroup(groupRequest,courseId);
    }

    @PutMapping("/updateGroupByCourseId/{id}")
    public GroupResponse updateGroupByCourseId(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(groupRequest, id);
    }

    @DeleteMapping("/deleteGroupById/{courseId}/{id}")
    public GroupResponse deleteGroupById(@PathVariable Long courseId, @PathVariable Long id) {
        return groupService.deleteGroup(courseId, id);
    }
    @PostMapping("/assignStudent/{id}/{groupId}")
    private StudentResponse assignStudent(@PathVariable Long id,
                                          @PathVariable Long groupId) throws IOException {
        return studentService.assignStudent(id, groupId);
    }

}
