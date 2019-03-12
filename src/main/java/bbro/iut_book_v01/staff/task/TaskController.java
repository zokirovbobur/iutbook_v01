package bbro.iut_book_v01.staff.task;

import bbro.iut_book_v01.staff.groupSection.GroupSection;
import bbro.iut_book_v01.staff.groupSection.groupsPerSection.GroupsPerSection;
import bbro.iut_book_v01.staff.groupSection.groupsPerSection.GroupsPerSectionRepo;
import bbro.iut_book_v01.staff.task.TaskPerStudent.TaskStudent;
import bbro.iut_book_v01.staff.task.TaskPerStudent.TaskStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskStudentRepo taskStudentRepo;
    @Autowired
    private GroupsPerSectionRepo groupsPerSectionRepo;

    @GetMapping
    public Task sample(){return new Task();}

    @PostMapping
    public ResponseEntity<String> newTask(
            @RequestBody Task task
    ){
        return taskService.save(task);
    }
    @PostMapping("perSection")
    public ResponseEntity<String> perSection(@RequestBody GroupSection groupSection){
        ArrayList<TaskStudent> taskStudents;
        List<GroupsPerSection> groups = groupsPerSectionRepo
                .findAllByGroupSection_GroupSectionId(groupSection.getGroupSectionId());
        return ResponseEntity.ok("");
    }

}
