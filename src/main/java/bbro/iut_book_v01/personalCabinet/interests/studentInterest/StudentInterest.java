package bbro.iut_book_v01.personalCabinet.interests.studentInterest;

import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;
import bbro.iut_book_v01.student.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentInterest {
    @Id
    @GeneratedValue
    private long studentInterestId;

    @ManyToOne
    private Interest interest;

    @ManyToOne
    private Student student;

    private String comment;

    public long getStudentInterestId() {
        return studentInterestId;
    }

    public void setStudentInterestId(long studentInterestId) {
        this.studentInterestId = studentInterestId;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "StudentInterest{" +
                "studentInterestId=" + studentInterestId +
                ", interest=" + interest +
                ", student=" + student +
                ", comment='" + comment + '\'' +
                '}';
    }
}
