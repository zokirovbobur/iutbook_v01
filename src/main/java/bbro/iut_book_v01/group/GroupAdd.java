package bbro.iut_book_v01.group;

import java.util.ArrayList;
import java.util.List;

public class GroupAdd {

    private int courseYearNumber;

    private String department;

    private int maxNoOfGroups;


    public List<Group_> calculateAll(){
        List<Group_> groups = new ArrayList<>();

        for (int i=1;i<=maxNoOfGroups;i++){
            groups.add(new Group_(this.department, courseYearNumber +"-"+i));
        }
        return groups;
    }

    public int getCourseYearNumber() {
        return courseYearNumber;
    }

    public void setCourseYearNumber(int courseYearNumber) {
        this.courseYearNumber = courseYearNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMaxNoOfGroups() {
        return maxNoOfGroups;
    }

    public void setMaxNoOfGroups(int maxNoOfGroups) {
        this.maxNoOfGroups = maxNoOfGroups;
    }
}
