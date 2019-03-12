package bbro.iut_book_v01.staff.task.TaskPerStudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TaskStudentRepo extends JpaRepository<TaskStudent, Long> {
    TaskStudent findByTaskStudentId(long id);
    List <TaskStudent> findAllByStudent_Uuid(long uuid);
    List<TaskStudent> findAllByTask_Staff_StaffId(long id);
    List<TaskStudent> findAllBySubmittedIsTrue();

}
