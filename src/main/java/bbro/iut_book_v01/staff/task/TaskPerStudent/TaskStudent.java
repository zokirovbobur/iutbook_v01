package bbro.iut_book_v01.staff.task.TaskPerStudent;

import bbro.iut_book_v01.staff.task.Task;
import bbro.iut_book_v01.student.Student;

import javax.persistence.*;

@Entity
public class TaskStudent {
    @Id
    @GeneratedValue
    private long taskStudentId;

    @ManyToOne
    private Task task;

    @ManyToOne
    private Student student;

    private boolean submitted;

    public long getTaskStudentId() {
        return taskStudentId;
    }

    public void setTaskStudentId(long taskStudentId) {
        this.taskStudentId = taskStudentId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    @Override
    public String toString() {
        return "TaskStudent{" +
                "taskStudentId=" + taskStudentId +
                ", task=" + task +
                ", student=" + student +
                '}';
    }
}
