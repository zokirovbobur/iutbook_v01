package bbro.iut_book_v01.staff.task.taskType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepo extends JpaRepository<TaskType,Long> {
    TaskType findByTaskTypeId(long taskTypeId);
    boolean existsByTaskTypeId(long id);
}
