package bbro.iut_book_v01.personalCabinet.interests.studentInterest;

import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;
import bbro.iut_book_v01.student.Student;

import java.util.List;

public class StudentInterestList {
    private Student student;
    private List<Interest> interests;
    private String comment;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "StudentInterestList{" +
                "student=" + student +
                ", interests=" + interests +
                ", comment='" + comment + '\'' +
                '}';
    }
}
