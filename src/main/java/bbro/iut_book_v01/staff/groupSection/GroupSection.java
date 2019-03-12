package bbro.iut_book_v01.staff.groupSection;

import bbro.iut_book_v01.staff.staff.Staff;

import javax.persistence.*;

@Entity
public class GroupSection {
    @Id
    @GeneratedValue
    private long groupSectionId;

    @ManyToOne
    private Staff responsibleStaff;

    private String courseName;

    private int sectionNumber;

    public long getGroupSectionId() {
        return groupSectionId;
    }

    public void setGroupSectionId(long groupSectionId) {
        this.groupSectionId = groupSectionId;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Staff getResponsibleStaff() {
        return responsibleStaff;
    }

    public void setResponsibleStaff(Staff responsibleStaff) {
        this.responsibleStaff = responsibleStaff;
    }

    @Override
    public String toString() {
        return "GroupSection{" +
                "groupSectionId=" + groupSectionId +
                ", responsibleStaff=" + responsibleStaff +
                ", courseName='" + courseName + '\'' +
                ", sectionNumber=" + sectionNumber +
                '}';
    }
}
