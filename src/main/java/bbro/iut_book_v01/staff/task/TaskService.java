package bbro.iut_book_v01.staff.task;

import bbro.iut_book_v01.staff.staff.StaffRepo;
import bbro.iut_book_v01.staff.task.taskType.TaskTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private TaskTypeRepo taskTypeRepo;

    public List<Task> findAll(){
        return taskRepo.findAll();
    }

    public ResponseEntity<String> save(Task task){

        System.out.println(isObjectNotNull(task.getTaskType()));
        //taskRepo.createTeam(task);
        return ResponseEntity.ok("new task added");
    }

    public boolean isObjectNotNull(Object object){
        return object!=null;
    }

    public boolean isStaffProper(Task task){
        return staffRepo.existsByStaffId(task.getStaff().getStaffId());
    }

    public boolean isTaskTypeProper(Task task){
        return taskTypeRepo.existsByTaskTypeId(task.getTaskType().getTaskTypeId());
    }



    private boolean isTaskNew(Task task){
        return true;
    }

    private boolean isTaskExists(Task task){
        return true;
    }

    private boolean isDeadlineIsCorrect(Task task){
        return true;
    }
}
