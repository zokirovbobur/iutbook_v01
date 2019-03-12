package bbro.iut_book_v01.staff.task.taskType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TaskType {
    @Id
    @GeneratedValue
    private long taskTypeId;

    private String taskTypeValue;

    public long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeValue() {
        return taskTypeValue;
    }

    public void setTaskTypeValue(String taskTypeValue) {
        this.taskTypeValue = taskTypeValue;
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "taskTypeId=" + taskTypeId +
                ", taskTypeValue='" + taskTypeValue + '\'' +
                '}';
    }
}
