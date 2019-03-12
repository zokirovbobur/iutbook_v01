package bbro.iut_book_v01.staff.task.taskType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taskType")
public class TaskTypeController {
    @Autowired
    private TaskTypeRepo repo;

    @GetMapping
    public TaskType taskType(){return new TaskType();}

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TaskType taskType){
        repo.save(taskType);
        return ResponseEntity.ok("Type of task has been added successfully");
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody TaskType taskType){
        repo.delete(taskType);
        return ResponseEntity.ok("Task type deleted successfully");
    }
    @GetMapping("all")
    public List<TaskType> findAll(){
        return repo.findAll();
    }
}
