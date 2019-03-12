package bbro.iut_book_v01.team;

import bbro.iut_book_v01.staff.staff.Staff;
import bbro.iut_book_v01.student.Student;
import bbro.iut_book_v01.subject.Subject;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private long teamId;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "studentRequest", nullable = false)
    private Student studentRequest;

    @ManyToOne
    private Staff staff;

    @ManyToOne
    private Subject subject;

    @Column(nullable = false)
    private int maxNoOfStudents;

    private String comment;

    public Team() {
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public Student getStudentRequest() {
        return studentRequest;
    }

    public void setStudentRequest(Student studentRequest) {
        this.studentRequest = studentRequest;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMaxNoOfStudents() {
        return maxNoOfStudents;
    }

    public void setMaxNoOfStudents(int maxNoOfStudents) {
        this.maxNoOfStudents = maxNoOfStudents;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", studentRequest=" + studentRequest +
                ", subject=" + subject +
                ", maxNoOfStudents=" + maxNoOfStudents +
                ", comment='" + comment + '\'' +
                '}';
    }
}
