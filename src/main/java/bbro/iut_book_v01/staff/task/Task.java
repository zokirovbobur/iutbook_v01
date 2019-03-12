package bbro.iut_book_v01.staff.task;

import bbro.iut_book_v01.staff.staff.Staff;
import bbro.iut_book_v01.subject.Subject;
import bbro.iut_book_v01.staff.task.taskType.TaskType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long taskId;

    @ManyToOne
    @JoinColumn(name = "staffTask")
    private Staff staff;

    @ManyToOne
    private TaskType taskType;

    @ManyToOne
    @JoinColumn(name = "subjectTask")
    private Subject subject;

    private String title;
    private String instruction;

    private String docUrl;

    @Column(nullable = false)
    private Timestamp givenDate;

    private Timestamp deadline;



    public void giveCurrentDate() {
        givenDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public Task() {
        giveCurrentDate();
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public Timestamp getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(Timestamp givenDate) {
        this.givenDate = givenDate;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", staff=" + staff +
                ", taskType=" + taskType +
                ", subject=" + subject +
                ", title='" + title + '\'' +
                ", instruction='" + instruction + '\'' +
                ", docUrl='" + docUrl + '\'' +
                ", givenDate=" + givenDate +
                ", deadline=" + deadline +
                '}';
    }
}
