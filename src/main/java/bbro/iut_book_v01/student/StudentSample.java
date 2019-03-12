package bbro.iut_book_v01.student;

import bbro.iut_book_v01.group.Group_;

public class StudentSample {


    private String firstName;
    private String lastName;

    private String userId;

    private Group_ group;

    private int fs;

    public StudentSample() {
        group = new Group_();
        firstName = "Bobur";
        userId = "u1710117";


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Group_ getGroup() {
        return group;
    }

    public void setGroup(Group_ group) {
        this.group = group;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    @Override
    public String toString() {
        return "StudentSample{" +
                "firstName='" + firstName + '\'' +
                ", userId='" + userId + '\'' +
                ", group='" + group + '\'' +
                ", fs=" + fs +
                '}';
    }
}
