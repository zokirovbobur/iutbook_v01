package bbro.iut_book_v01.staff.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Task findByTaskId(long taskId);

}
