package bbro.iut_book_v01.group;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Group_ {
    @Id
    @GeneratedValue
    private long groupId;

    private String department;
    private String noOfGroup;

    public Group_(String department, String noOfGroup) {
        this.department = department;
        this.noOfGroup = noOfGroup;
    }

    public Group_() {
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNoOfGroup() {
        return noOfGroup;
    }

    public void setNoOfGroup(String noOfGroup) {
        this.noOfGroup = noOfGroup;
    }

    @Override
    public String toString() {
        return "Group_{" +
                "groupId=" + groupId +
                ", department='" + department + '\'' +
                ", noOfGroup='" + noOfGroup + '\'' +
                '}';
    }
}
