package bbro.iut_book_v01.transfer;

import bbro.iut_book_v01.group.Group_;
import bbro.iut_book_v01.student.Student;

import javax.persistence.*;

@Entity
public class Transfer {
    @Id
    @GeneratedValue
    private long transferId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student studentRequest;

    @ManyToOne
    private Student studentResponse;

    @ManyToOne
    @JoinColumn(name = "transferToGroup", nullable = false)
    private Group_ toGroup;


    public Transfer() {
    }

    public boolean isFixed(){
        return studentResponse!=null;
    }

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public Student getStudentRequest() {
        return studentRequest;
    }

    public void setStudentRequest(Student studentRequest) {
        this.studentRequest = studentRequest;
    }

    public Student getStudentResponse() {
        return studentResponse;
    }

    public void setStudentResponse(Student studentResponse) {
        this.studentResponse = studentResponse;
    }

    public Group_ getToGroup() {
        return toGroup;
    }

    public void setToGroup(Group_ toGroup) {
        this.toGroup = toGroup;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", studentRequest=" + studentRequest +
                ", studentResponse=" + studentResponse +
                ", toGroup='" + toGroup.toString() + '\'' +
                '}';
    }
}
