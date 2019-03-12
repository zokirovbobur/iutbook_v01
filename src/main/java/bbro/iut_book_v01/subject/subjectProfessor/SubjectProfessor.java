package bbro.iut_book_v01.subject.subjectProfessor;

import bbro.iut_book_v01.staff.staff.Staff;
import bbro.iut_book_v01.subject.Subject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubjectProfessor {
    @Id
    @GeneratedValue
    private long subjectProfessorId;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Staff staff;

    public long getSubjectProfessorId() {
        return subjectProfessorId;
    }

    public void setSubjectProfessorId(long subjectProfessorId) {
        this.subjectProfessorId = subjectProfessorId;
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
}
